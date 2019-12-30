package MybatisXML.MapperConfig;

import java.util.Collection;

import MybatisXML.Entitymodel.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Mapper
public interface EmployeeMapper
	{
		//注意把特殊字符转义成字符串，例如 '${Email}'
		@Insert ("insert into employee (Name, Salary, Dept, Email, Phone) values(#{Name}, #{Salary}, #{Dept}, #{Email}, #{Phone})")
	    void insertEmp(Employee empl);
		
		@Select ("select * from employee WHERE ID=#{ID}")
	    Employee findEmpById(Integer id);
		
		@Select ("select * from employee WHERE Name=#{Name}")
	    Employee findEmpByName(String Name);
		
		@Select ("select distinct Dept from employee")
		Collection<String> getAllDept();
		
		@Select ("select * from employee")
	    Collection<Employee> findAllEmp();
		
		@Select ("select * from employee order by Dept")
	    Collection<Employee> findAllEmpOrderByDept();
		
		//update与insert不同，构造返回实例的时候需要带上原来的主键ID！immutable
		@Update ("update employee set Name=#{Name}, Salary=#{Salary}, Dept=#{Dept}, Email=#{Email}, Phone=#{Phone} WHERE ID=#{ID}")
	    void updateEmp(Employee empl);	
		
		@Delete ("delete from employee WHERE ID=#{ID}")
	    void deleteEmpById(Integer id);	
		
	}

