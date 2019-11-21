package MybatisXML.Entitymodel;

public class UserFromForm {
	 
	private String username;  
	private String password;
	
	//public UserFromForm() {};
	
	public UserFromForm (String username, String password) {
		this.username=username;
		this.password=password;
	}

	public String getUserName() {
		return username;
	}
	
	public void setName(String UserName) {
		this.username=UserName;
	}
	
	public String getPasswd() {
		return password;
	}
	
	public void setPasswd(String Passwd) {
		this.password=Passwd;
	}
	
	@Override
	public String toString() {
		return "UserName: " + username + ", Passwd: " + password;
	}
}
