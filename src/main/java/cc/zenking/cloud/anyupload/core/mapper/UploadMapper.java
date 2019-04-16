/**  
* <p>Title: UploadMapper.java</p>
* <p>Description: </p> 
* @author pxx 
* @date 2019年4月12日  
*/  
package cc.zenking.cloud.anyupload.core.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cc.zenking.cloud.anyupload.core.entity.UploadConfig;

/**  
* <p>Title: UploadMapper</p>  
* <p>Description: </p>  
* @author pxx  
* @date 2019年4月12日  
*/
@Mapper
public interface UploadMapper {

	/**
	 * <p>Title: getUploadConfig</p>  
	 * <p>Description: </p>  
	 * @param key
	 * @return  
	 */  
	@Select(" SELECT config_key as configKey, fileTypes, height, imageMethod, securityAssces, smallHeight, smallMethod, smallWidth, width, description, user_type from sys_uploadconfig  where config_key=#{key}")
	UploadConfig getUploadConfig(@Param("key")String key);

}
