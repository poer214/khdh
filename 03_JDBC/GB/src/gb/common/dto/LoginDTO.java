package gb.common.dto;

public class LoginDTO {
	private String type = "login";
	private String id;
	private String password;
	
	public LoginDTO() {};
	public LoginDTO(String id, String password) {
		this.id = id;
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
