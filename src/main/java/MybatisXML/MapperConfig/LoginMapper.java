package MybatisXML.MapperConfig;

import MybatisXML.Entitymodel.LoginUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Configuration
@Mapper
@Component
public interface LoginMapper {
	
	@Select ("select * from spring_users where user_name = #{username}")
	LoginUser findUserByName(String username);
	
	//get User Passwd for login authentication, assert AccountStatus >0
	LoginUser getUserByAuth(@Param("username") String username, @Param("password") String password);

	@Update("UPDATE spring_users set last_login= now() where user_id= #{userId}")
	void updateLastLogin(@Param("userId") int userId);
}
