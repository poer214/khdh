import java.io.Serializable;
import java.time.LocalDateTime;

public class LoginDTO implements Serializable{
	private String type = "login";
	private String id;
	private String pw;
	
	public LoginDTO() {}
	public LoginDTO(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
}
