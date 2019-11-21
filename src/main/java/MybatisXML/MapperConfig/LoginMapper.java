package MybatisXML.MapperConfig;

import MybatisXML.Entitymodel.LoginUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Configuration
@Mapper
@Component
public interface LoginMapper {
	
	@Select ("select * from spring_users where username = #{username}")
	LoginUser findUserByName(String username);
	
	//get User Passwd for login authentication, assert AccountStatus >0"
	@Select ("select * from spring_users where username=#{username} and password=#{password} and accountstatus >0")
	LoginUser getUserByAuth(@Param("username") String username, @Param("password") String password);
}
