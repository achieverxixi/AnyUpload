/**  
* <p>Title: UploadResult.java</p>
* <p>Description: </p> 
* @author pxx 
* @date 2019年4月12日  
*/  
package cc.zenking.cloud.anyupload.core.model;

/**  
* <p>Title: UploadResult</p>  
* <p>Description: </p>  
* @author pxx  
* @date 2019年4月12日  
*/
public class UploadResult {

	private int status;
	private String name;
	private String url;
	
	public UploadResult(int status) {
		this.status = status;
	}

	public UploadResult(int status, String name, String url) {
		this.status = status;
		this.name = name;
		this.url = url;
	}

	public int getStatus() {
		return this.status;
	}

	public String getName() {
		return this.name;
	}

	public String getUrl() {
		return this.url;
	}

	public void setResult(int status) {
		this.status = status;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (!(o instanceof UploadResult)) {
			return false;
		} else {
			UploadResult other = (UploadResult) o;
			if (!other.canEqual(this)) {
				return false;
			} else if (this.getStatus() != other.getStatus()) {
				return false;
			} else {
				String this$name = this.getName();
				String other$name = other.getName();
				if (this$name == null) {
					if (other$name != null) {
						return false;
					}
				} else if (!this$name.equals(other$name)) {
					return false;
				}

				String this$url = this.getUrl();
				String other$url = other.getUrl();
				if (this$url == null) {
					if (other$url != null) {
						return false;
					}
				} else if (!this$url.equals(other$url)) {
					return false;
				}

				return true;
			}
		}
	}

	protected boolean canEqual(Object other) {
		return other instanceof UploadResult;
	}

	public int hashCode() {
		boolean PRIME = true;
		byte result = 1;
		int result1 = result * 59 + this.getStatus();
		String $name = this.getName();
		result1 = result1 * 59 + ($name == null ? 0 : $name.hashCode());
		String $url = this.getUrl();
		result1 = result1 * 59 + ($url == null ? 0 : $url.hashCode());
		return result1;
	}

	public String toString() {
		return "UploadResult(result=" + this.getStatus() + ", name=" + this.getName() + ", url=" + this.getUrl() + ")";
	}


}
