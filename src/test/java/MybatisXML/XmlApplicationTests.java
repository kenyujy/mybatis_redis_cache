package MybatisXML;

import MybatisXML.Entitymodel.Employee;
import MybatisXML.MapperConfig.EmployeeMapper;
import MybatisXML.Service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XmlApplicationTests {

    @Autowired
    EmployeeService employeeService;

    @Test
    public void contextLoads() {

        System.out.println(employeeService);

        Collection<Employee> el= employeeService.getAllEmp();
        System.out.println(el);
    }

}
