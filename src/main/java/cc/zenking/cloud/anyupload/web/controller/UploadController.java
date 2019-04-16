/**  
* <p>Title: UploadController.java</p>
* <p>Description: </p> 
* @author pxx 
* @date 2019年4月12日  
*/  
package cc.zenking.cloud.anyupload.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cc.zenking.cloud.anyupload.core.model.KindeditorUploadResult;
import cc.zenking.cloud.anyupload.core.model.UploadResult;
import cc.zenking.cloud.anyupload.web.service.UploadService;
import lombok.extern.slf4j.Slf4j;


/**  
* <p>Title: UploadController</p>  
* <p>Description: </p>  
* @author pxx  
* @date 2019年4月12日  
*/
@Controller
@Slf4j
@RequestMapping(value="/upload")
public class UploadController {
	
	@Value("${resource.uploadurl}")
	private String serverUrl;
	
	@Autowired
	private UploadService uploadService;
	
	@RequestMapping(value="/uploadfile", method = RequestMethod.POST)
	@ResponseBody
    public Map<String, Object> uploadfile(HttpServletRequest request, HttpServletResponse response, String key,
			@RequestParam MultipartFile file) throws IOException {
		HashMap<String, Object> map = new  HashMap<>();
		UploadResult uploadResult=uploadService.uploadFile(serverUrl,file,key);//保存到服务器的路径
		if (uploadResult.getStatus() > 0) {
			map.put("code", 0);
			map.put("msg", "上传成功");
			map.put("data", uploadResult);
		}else{
			map.put("code", 1);
			map.put("msg", "失败");
		}
		return map;
    }
	
	@RequestMapping(value = "/forkindeditor", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> forkindeditor(HttpServletRequest req, String key) {
		HashMap<String, Object> map = new HashMap<>();
		MultipartHttpServletRequest r = (MultipartHttpServletRequest) req;
		Collection<MultipartFile> files = r.getFileMap().values();
		KindeditorUploadResult uploadResult=null;
		if (!files.isEmpty()) {
			MultipartFile file = files.iterator().next();
			uploadResult = uploadService.KindeditorUploadFile(serverUrl, file, key);// 保存到服务器的路径
		}
		HashMap<String, Object> errorMap = new HashMap<>();
		if (uploadResult.getResult() > 0) {
			map.put("uploaded", 1);
			map.put("fileName", uploadResult.getName());
			map.put("url", uploadResult.getUrl());
			errorMap.put("message", "上传成功!");
			map.put("error", errorMap);
		} else {
			errorMap.put("message", "上传失败!");
			map.put("uploaded", 0);
			map.put("error", errorMap);
		}
		return map;
	}
}
