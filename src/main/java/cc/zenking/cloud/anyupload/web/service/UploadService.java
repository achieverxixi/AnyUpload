/**  
* <p>Title: UploadService.java</p>
* <p>Description: </p> 
* @author pxx 
* @date 2019年4月12日  
*/  
package cc.zenking.cloud.anyupload.web.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cc.zenking.cloud.anyupload.core.entity.UploadConfig;
import cc.zenking.cloud.anyupload.core.mapper.UploadMapper;
import cc.zenking.cloud.anyupload.core.model.KindeditorUploadResult;
import cc.zenking.cloud.anyupload.core.model.UploadResult;


/**  
* <p>Title: UploadService</p>  
* <p>Description: </p>  
* @author pxx  
* @date 2019年4月12日  
*/
@Service
public class UploadService {
	
	@Value("${resource.address}")
	private String address;
	
	@Value("${resource.prefix}")
	private String prefix;
	
	
	@Autowired
	private UploadMapper uploadMapper;
	
	/**
	 * <p>Title: uploadFile</p>  
	 * <p>Description: </p>  
	 * @param serverUrl
	 * @param key 
	 * @param file  
	 * @return 
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */  
	public UploadResult uploadFile(String serverUrl, MultipartFile fileHandler, String key){
		System.out.println("name: " + fileHandler.getOriginalFilename() + "  size: " + fileHandler.getSize());
		//要上传的文件夹是否存在
		//先通过key找到对应的存放目录(找到可以上传的文件格式   磁盘目录)
		//判断磁盘目录是否存在,不存在创建文件夹
		//文件写入到文件夹中
		UploadResult uploadResult = new UploadResult(0);
		String fileUri=null;
		try {
			Calendar calendar = Calendar.getInstance();
			Integer year = calendar.get(Calendar.YEAR);
			Integer month=calendar.get(Calendar.MONTH) + 1;
			Integer date=calendar.get(Calendar.DATE);
			serverUrl+="/"+key+"/"+year + "/"+ month+ "/"+date+ "/";
			fileUri=key+"/"+year + "/"+ month+ "/"+date+ "/";
			System.out.println("serverUrl: " + serverUrl);
			File file = new File(serverUrl);
			if (!file.exists()) {
				file.mkdirs();
			}
			if (key != null && !key.equals("")) {
				// 获取上传文件格式类型
				UploadConfig uploadConfig = uploadMapper.getUploadConfig(key);
				String concat = uploadConfig.getFileTypes().concat(fileHandler.getOriginalFilename()
						.substring(fileHandler.getOriginalFilename().lastIndexOf(".") + 1));
				if (null != concat && !concat.equals("")) {
					String fileUrl = serverUrl + fileHandler.getOriginalFilename();
					FileOutputStream fos = null;
					fos = new FileOutputStream(fileUrl);
					fos.write(fileHandler.getBytes()); // 写入文件
					fos.close();
					uploadResult = new UploadResult(1);
					uploadResult.setUrl(prefix+address+fileUri+fileHandler.getOriginalFilename());
					uploadResult.setName(fileHandler.getOriginalFilename());
				}
			}
		} catch (Exception e) {
			return uploadResult;
		}
		return uploadResult;
	}
	

	/**
	 * <p>Title: uploadFile</p>  
	 * <p>Description: </p>  
	 * @param serverUrl
	 * @param key 
	 * @param file  
	 * @return 
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */  
	public KindeditorUploadResult KindeditorUploadFile(String serverUrl, MultipartFile fileHandler, String key){
		System.out.println("name: " + fileHandler.getOriginalFilename() + "  size: " + fileHandler.getSize());
		//要上传的文件夹是否存在
		//先通过key找到对应的存放目录(找到可以上传的文件格式   磁盘目录)
		//判断磁盘目录是否存在,不存在创建文件夹
		//文件写入到文件夹中
		KindeditorUploadResult uploadResult = new KindeditorUploadResult(0);
		String fileUri=null;
		try {
			Calendar calendar = Calendar.getInstance();
			Integer year = calendar.get(Calendar.YEAR);
			Integer month=calendar.get(Calendar.MONTH) + 1;
			Integer date=calendar.get(Calendar.DATE);
			serverUrl+="/"+key+"/"+year + "/"+ month+ "/"+date+ "/";
			fileUri=key+"/"+year + "/"+ month+ "/"+date+ "/";
			System.out.println("serverUrl: " + serverUrl);
			File file = new File(serverUrl);
			if (!file.exists()) {
				file.mkdirs();
			}
			if (key != null && !key.equals("")) {
				// 获取上传文件格式类型
				UploadConfig uploadConfig = uploadMapper.getUploadConfig(key);
				String concat = uploadConfig.getFileTypes().concat(fileHandler.getOriginalFilename()
						.substring(fileHandler.getOriginalFilename().lastIndexOf(".") + 1));
				if (null != concat && !concat.equals("")) {
					String fileUrl = serverUrl + fileHandler.getOriginalFilename();
					FileOutputStream fos = null;
					fos = new FileOutputStream(fileUrl);
					System.out.println(fileUrl);
					fos.write(fileHandler.getBytes()); // 写入文件
					fos.close();
					uploadResult = new KindeditorUploadResult(1);
					uploadResult.setUrl(prefix+address+fileUri+fileHandler.getOriginalFilename());
					uploadResult.setName(fileHandler.getOriginalFilename());
				}
			}
		} catch (Exception e) {
			return uploadResult;
		}
		return uploadResult;
	}
}
