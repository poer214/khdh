

public class RequestData {
	private String type;
	private String id;
	private String pw;
	private String content;
	
	// 생성자
	public RequestData() {}
	public RequestData(String type, String id, String pw) {
		this.type = type;
		this.id = id;
		this.pw = pw;
	}
	public RequestData(String type, String content) {
		this.type = type;
		this.content = content;
	}
	
	// getter and setter
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
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
