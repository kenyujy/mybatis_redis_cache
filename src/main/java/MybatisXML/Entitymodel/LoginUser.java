package MybatisXML.Entitymodel;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Date;

//LoginUser 即数据库spring_test 里面的 spring_user
public class LoginUser {
	
	private int user_id;
	
	@NotEmpty
	private String user_name;
	
	@NotEmpty
	private String password;
	
	//@NotEmpty
	private int account_status;

	private int userRoleId;
	private Date lastLogin;

	public LoginUser(){ }

	public LoginUser(int user_id, @NotEmpty String user_name, @NotEmpty String password, int account_status, int userRoleId, Date lastLogin) {
		this.user_id = user_id;
		this.user_name = user_name;
		this.password = password;
		this.account_status = account_status;
		this.userRoleId = userRoleId;
		this.lastLogin = lastLogin;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAccount_status() {
		return account_status;
	}

	public void setAccount_status(int account_status) {
		this.account_status = account_status;
	}

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	@Override
	public String toString() {
		return "LoginUser{" +
				"user_id=" + user_id +
				", user_name='" + user_name + '\'' +
				", password='" + password + '\'' +
				", account_status=" + account_status +
				", userRoleId=" + userRoleId +
				", lastLogin=" + lastLogin +
				'}';
	}
}