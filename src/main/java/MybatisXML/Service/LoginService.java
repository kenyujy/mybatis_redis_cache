package MybatisXML.Service;

import MybatisXML.Entitymodel.LoginUser;
import MybatisXML.MapperConfig.LoginMapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

	@Autowired
	private LoginMapper loginMapper;  //@Component?
	
	public LoginUser getUserByAuth(String loginName, String passwd) {
		LoginUser loginUser= loginMapper.getUserByAuth(loginName, passwd);
		return loginUser;
	}

	public void updateLastLogin(int userId){
		loginMapper.updateLastLogin(userId);
	}
}
