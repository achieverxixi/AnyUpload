/**  
* <p>Title: Snippet.java</p>
* <p>Description: </p> 
* @author pxx 
* @date 2019年4月12日  
*/  
package cc.zenking.cloud.anyupload.core.entity;

/**  
* <p>Title: Snippet</p>  
* <p>Description: </p>  
* @author pxx  
* @date 2019年4月12日  
*/ 
public class UploadConfig {

	private String configKey;
	private String fileTypes;
	private Integer width;
	private Integer height;
	private int imageMethod;
	private Integer smallWidth;
	private Integer smallHeight;
	private int smallMethod;
	private boolean securityAssces;
	private String description;

	public UploadConfig() {
	}

	public UploadConfig(String configKey) {
		this.configKey = configKey;
	}

	public String getconfigKey() {
		return this.configKey;
	}

	public String getFileTypes() {
		return this.fileTypes;
	}

	public Integer getWidth() {
		return this.width;
	}

	public Integer getHeight() {
		return this.height;
	}

	public int getImageMethod() {
		return this.imageMethod;
	}

	public Integer getSmallWidth() {
		return this.smallWidth;
	}

	public Integer getSmallHeight() {
		return this.smallHeight;
	}

	public int getSmallMethod() {
		return this.smallMethod;
	}

	public boolean isSecurityAssces() {
		return this.securityAssces;
	}

	public String getDescription() {
		return this.description;
	}

	public void setconfigKey(String configKey) {
		this.configKey = configKey;
	}

	public void setFileTypes(String fileTypes) {
		this.fileTypes = fileTypes;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public void setImageMethod(int imageMethod) {
		this.imageMethod = imageMethod;
	}

	public void setSmallWidth(Integer smallWidth) {
		this.smallWidth = smallWidth;
	}

	public void setSmallHeight(Integer smallHeight) {
		this.smallHeight = smallHeight;
	}

	public void setSmallMethod(int smallMethod) {
		this.smallMethod = smallMethod;
	}

	public void setSecurityAssces(boolean securityAssces) {
		this.securityAssces = securityAssces;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (!(o instanceof UploadConfig)) {
			return false;
		} else {
			UploadConfig other = (UploadConfig) o;
			if (!other.canEqual(this)) {
				return false;
			} else {
				label107: {
					String this$configKey = this.getconfigKey();
					String other$configKey = other.getconfigKey();
					if (this$configKey == null) {
						if (other$configKey == null) {
							break label107;
						}
					} else if (this$configKey.equals(other$configKey)) {
						break label107;
					}

					return false;
				}

				String this$fileTypes = this.getFileTypes();
				String other$fileTypes = other.getFileTypes();
				if (this$fileTypes == null) {
					if (other$fileTypes != null) {
						return false;
					}
				} else if (!this$fileTypes.equals(other$fileTypes)) {
					return false;
				}

				Integer this$width = this.getWidth();
				Integer other$width = other.getWidth();
				if (this$width == null) {
					if (other$width != null) {
						return false;
					}
				} else if (!this$width.equals(other$width)) {
					return false;
				}

				label86: {
					Integer this$height = this.getHeight();
					Integer other$height = other.getHeight();
					if (this$height == null) {
						if (other$height == null) {
							break label86;
						}
					} else if (this$height.equals(other$height)) {
						break label86;
					}

					return false;
				}

				if (this.getImageMethod() != other.getImageMethod()) {
					return false;
				} else {
					Integer this$smallWidth = this.getSmallWidth();
					Integer other$smallWidth = other.getSmallWidth();
					if (this$smallWidth == null) {
						if (other$smallWidth != null) {
							return false;
						}
					} else if (!this$smallWidth.equals(other$smallWidth)) {
						return false;
					}

					label71: {
						Integer this$smallHeight = this.getSmallHeight();
						Integer other$smallHeight = other.getSmallHeight();
						if (this$smallHeight == null) {
							if (other$smallHeight == null) {
								break label71;
							}
						} else if (this$smallHeight.equals(other$smallHeight)) {
							break label71;
						}

						return false;
					}

					if (this.getSmallMethod() != other.getSmallMethod()) {
						return false;
					} else if (this.isSecurityAssces() != other.isSecurityAssces()) {
						return false;
					} else {
						String this$description = this.getDescription();
						String other$description = other.getDescription();
						if (this$description == null) {
							if (other$description == null) {
								return true;
							}
						} else if (this$description.equals(other$description)) {
							return true;
						}

						return false;
					}
				}
			}
		}
	}

	protected boolean canEqual(Object other) {
		return other instanceof UploadConfig;
	}

	public int hashCode() {
		boolean PRIME = true;
		byte result = 1;
		String $configKey = this.getconfigKey();
		int result1 = result * 59 + ($configKey == null ? 0 : $configKey.hashCode());
		String $fileTypes = this.getFileTypes();
		result1 = result1 * 59 + ($fileTypes == null ? 0 : $fileTypes.hashCode());
		Integer $width = this.getWidth();
		result1 = result1 * 59 + ($width == null ? 0 : $width.hashCode());
		Integer $height = this.getHeight();
		result1 = result1 * 59 + ($height == null ? 0 : $height.hashCode());
		result1 = result1 * 59 + this.getImageMethod();
		Integer $smallWidth = this.getSmallWidth();
		result1 = result1 * 59 + ($smallWidth == null ? 0 : $smallWidth.hashCode());
		Integer $smallHeight = this.getSmallHeight();
		result1 = result1 * 59 + ($smallHeight == null ? 0 : $smallHeight.hashCode());
		result1 = result1 * 59 + this.getSmallMethod();
		result1 = result1 * 59 + (this.isSecurityAssces() ? 79 : 97);
		String $description = this.getDescription();
		result1 = result1 * 59 + ($description == null ? 0 : $description.hashCode());
		return result1;
	}

	public String toString() {
		return "UploadConfig(configKey=" + this.getconfigKey() + ", fileTypes=" + this.getFileTypes() + ", width=" + this.getWidth()
				+ ", height=" + this.getHeight() + ", imageMethod=" + this.getImageMethod() + ", smallWidth="
				+ this.getSmallWidth() + ", smallHeight=" + this.getSmallHeight() + ", smallMethod="
				+ this.getSmallMethod() + ", securityAssces=" + this.isSecurityAssces() + ", description="
				+ this.getDescription() + ")";
	}
}

