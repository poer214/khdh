package gb.common.dto;

public class DTO {
	String type;
	String content;
	
	public DTO() {}
	public DTO(String type, String content) {
		this.type = type;
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}