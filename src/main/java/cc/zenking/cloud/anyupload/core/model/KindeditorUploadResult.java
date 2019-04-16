/**  
* <p>Title: UploadResult.java</p>
* <p>Description: </p> 
* @author pxx 
* @date 2019年4月12日  
*/  
package cc.zenking.cloud.anyupload.core.model;

/**  
* <p>Title: KindeditorUploadResult</p>  
* <p>Description: </p>  
* @author pxx  
* @date 2019年4月12日  
*/
public class KindeditorUploadResult {

	private int result;
	private String name;
	private String url;
	
	public KindeditorUploadResult(int result) {
		this.result = result;
	}

	public KindeditorUploadResult(int result, String name, String url) {
		this.result = result;
		this.name = name;
		this.url = url;
	}

	public int getResult() {
		return this.result;
	}

	public String getName() {
		return this.name;
	}

	public String getUrl() {
		return this.url;
	}

	public void setResult(int result) {
		this.result = result;
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
		} else if (!(o instanceof KindeditorUploadResult)) {
			return false;
		} else {
			KindeditorUploadResult other = (KindeditorUploadResult) o;
			if (!other.canEqual(this)) {
				return false;
			} else if (this.getResult() != other.getResult()) {
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
		return other instanceof KindeditorUploadResult;
	}

	public int hashCode() {
		boolean PRIME = true;
		byte result = 1;
		int result1 = result * 59 + this.getResult();
		String $name = this.getName();
		result1 = result1 * 59 + ($name == null ? 0 : $name.hashCode());
		String $url = this.getUrl();
		result1 = result1 * 59 + ($url == null ? 0 : $url.hashCode());
		return result1;
	}

	public String toString() {
		return "KindeditorUploadResult(result=" + this.getResult() + ", name=" + this.getName() + ", url=" + this.getUrl() + ")";
	}


}
