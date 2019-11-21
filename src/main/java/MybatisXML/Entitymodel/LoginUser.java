package MybatisXML.Entitymodel;

import javax.validation.constraints.NotEmpty;

//LoginUser 即数据库spring_test 里面的 spring_user
public class LoginUser {
	
	private int userid;
	
	@NotEmpty
	private String username;
	
	@NotEmpty
	private String password;
	
	@NotEmpty
	private int AccountStatus;
	private int Level1_auth;
	private int Level2_auth;
	private int Level3_auth;
	
	public LoginUser(int userid, String username, String password, int AccountStatus, int Level1_auth, int Level2_auth, int Level3_auth) {
		this.userid=userid;
		this.username=username;
		this.password=password;
		this.AccountStatus=AccountStatus;
		this.Level1_auth= Level1_auth;
		this.Level2_auth= Level2_auth;
		this.Level3_auth= Level3_auth;
	}
	
	public LoginUser (String username, String password) {
		this.username=username;
		this.password=password;
	}
	
	public int getUserID() {
		return userid;
	}
	
	public void setUserID(int UserID) {
		this.userid=UserID;
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
	
	public int getAccountStatus() {
		return AccountStatus;
	}
	
	public void setAccountStatus(int AccountStatus) {
		this.AccountStatus=AccountStatus;
	}
	
	public int getLevel1_auth() {
		return Level1_auth;
	}
	
	public void setLevel1_auth(int Level1_auth) {
		this.Level1_auth=Level1_auth;
	}
	
	public int getLevel2_auth() {
		return Level2_auth;
	}
	
	public void setLevel2_auth(int Level2_auth) {
		this.Level2_auth=Level2_auth;
	}
	
	public int getLevel3_auth() {
		return Level3_auth;
	}
	
	public void setLevel3_auth(int Level3_auth) {
		this.Level3_auth=Level3_auth;
	}
	
	@Override
	public String toString() {
		return "UserID: " + userid +",UserName: " + username + ",Passwd: " + password + ",AccountStatus: " + AccountStatus
				+",Level1_auth: "+Level1_auth+",Level2_auth: "+Level2_auth+",Level3_auth: "+Level3_auth;
	}
}