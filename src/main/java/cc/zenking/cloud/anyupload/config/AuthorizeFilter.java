package cc.zenking.cloud.anyupload.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * 
* <p>Title: AuthorizeFilter</p>  
* <p>Description: 用来过滤  png jpg 这类资源，目前不需要</p>  
* @author pxx  
* @date 2019年4月16日
 */
@Component
@Slf4j
public class AuthorizeFilter implements Filter {
	
	private static Map<String, Object> allMimeTypes;
	 
	static {
		allMimeTypes = new HashMap<String, Object>();
		allMimeTypes.put("html", "text/html");
		allMimeTypes.put("htm", "text/html");
		allMimeTypes.put("jpg", "image/jpeg");
		allMimeTypes.put("jpeg", "image/jpeg");
		allMimeTypes.put("bmp", "image/bmp");
		allMimeTypes.put("gif", "image/gif");
		allMimeTypes.put("png", "image/png");
		allMimeTypes.put("doc", "application/msword");
		allMimeTypes.put("docx", "application/msword");
		allMimeTypes.put("xls", "application/msexcel");
		allMimeTypes.put("xlsx", "application/msexcel");
		allMimeTypes.put("mp3", "audio/mpeg");
	 }
	
	@Value("${resource.uploadurl}")
	private String serverUrl;
	
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
    	HttpServletRequest req = (HttpServletRequest) request;
		String url = req.getRequestURI();
		String path = url.substring(req.getServletContext().getContextPath().length());
		if(path.startsWith("/anyfile/")){
			path=path.substring(9);
		}
		if (path.startsWith("/kindeditor/")) {
			filterChain.doFilter(request, response);
			return;
		}
		InputStream is = getInputStream(path);
		HttpServletResponse res = (HttpServletResponse) response;
		if (is == null) {
			filterChain.doFilter(request, response);
			return;
		}
		res.setContentType(getMimeType(path));
		transmission(is, response.getOutputStream());
	}

    
    public void transmission(InputStream is, OutputStream os) throws IOException {
		byte[] b = new byte[4096];

		int k;
		while ((k = is.read(b)) != -1) {
			os.write(b, 0, k);
		}

		os.flush();
	}

	/**
	 * <p>Title: getInputStream</p>  
	 * <p>Description: </p>  
	 * @param path
	 * @return  
	 */  
	public InputStream getInputStream(String path) throws IOException {
		File f = this.getFile(path);
		return !f.exists() ? null : new FileInputStream(f);
	}

	/**
	 * <p>Title: getFile</p>  
	 * <p>Description: </p>  
	 * @param path
	 * @return  
	 */  
	private File getFile(String path) {
		return (File) (path == null ? serverUrl : new File(serverUrl, path));
	}
	
	/**
	 * 获得媒体类型
	 * 
	 * @param path
	 *            URL路径
	 * @return 媒体类型
	 */
	private String getMimeType(String path) {
		int k = path.lastIndexOf('.');
		String t = path.substring(k + 1).toLowerCase();
		String rs = (String) allMimeTypes.get(t);
		return rs == null ? "application/octet-stream" : rs;
	}
	
    @Override
    public void destroy() {

    }
}
