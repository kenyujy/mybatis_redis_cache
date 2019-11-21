package MybatisXML.Controller;

import java.util.Collection;
import java.util.Map;
import javax.validation.Valid;

import MybatisXML.Entitymodel.Employee;
import MybatisXML.Service.EmployeeService;
import MybatisXML.Service.FormCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebCrudController {

	@Autowired
    private EmployeeService employeeService;
	//一行@Autowired配一行!
	
	@ResponseBody
	@RequestMapping(value={"/emp/{id}"}, method=RequestMethod.GET)
    public Employee getEmp(@PathVariable("id") Integer id) {
		Employee emp= employeeService.findEmpById(id);
        return emp;
	}
	
	@ResponseBody
	@RequestMapping(value={"/emp/name/{name}"}, method=RequestMethod.GET)
    public Employee getEmpByName(@PathVariable("name") String name) {
		Employee emp= employeeService.findEmpByName(name);
        return emp;
	}
	
	@RequestMapping(value={"/emps"}, method=RequestMethod.GET)
    public String ListAllEmp(Map<String,Object> map) {
		Collection<Employee> EmpList=employeeService.getAllEmp();
		map.put("Emps", EmpList);
        return "list";
	}

	@RequestMapping(value="/addemp", method=RequestMethod.GET)
	public String addEmp(Map<String,Object> map) {
		//select distinct Dept from database
		Collection<String> Depts=employeeService.getAllDept();
		map.put("depts", Depts);
		return "addpage";
    }

	//SpringMVC自动将请求参数和入参对象封装，要求请求参数的名字和入参对象里面的属性名一样
	//方法参数上加 @Valid 表示根据Entity规则 校验数据的合法性, BindingResult
	@RequestMapping(value="/addemp", method=RequestMethod.POST)
	public ModelAndView addEmpCommit(@Valid @ModelAttribute Employee e, ModelMap model) throws Exception{
		//form data validity check
		Employee s= employeeService.findEmpByName(e.getName());
        if (s!=null) {
        	throw new IllegalArgumentException("Empoyee with that name already exist!");
        }
        if ( FormCheckService.emailChecker(e.getEmail())){
			employeeService.insertEmp(e);
			//redirect 重定向到一个地址, forward 转发到一个地址
			return new ModelAndView("redirect:/emps");
		}else {
			model.addAttribute("email_error","email invalid");
			Collection<String> Depts=employeeService.getAllDept();
			model.put("depts", Depts);
			return new ModelAndView("addpage");  // forward 不需要加model
		}
	}
		
	@RequestMapping(value="/editemp/{id}", method=RequestMethod.GET)
	public String updateEmp(@PathVariable("id") Integer id, Map<String,Object> map) {
		//retrieve employee by id and put into map
		Employee retrieved = employeeService.findEmpById(id);
		map.put("employee", retrieved);
		//select distinct Dept from database
		Collection<String> Depts= employeeService.getAllDept();
		map.put("depts", Depts);
		return "editpage";
    }
	
	//POST request 回到list.html
	//SpringMVC自动将请求参数和入参对象封装，要求请求参数的名字和如参对象里面的属性名一样
	@RequestMapping(value="/updateemp", method=RequestMethod.POST)
	public ModelAndView updateEmpCommit(@ModelAttribute Employee ex, ModelMap model) {
		//form data validity check

		if ( FormCheckService.emailChecker(ex.getEmail())){
			employeeService.updateEmp(ex);
			//redirect 重定向到一个地址, forward 转发到一个地址
			return new ModelAndView("redirect:/emps");
		}else {
			model.addAttribute("email_error","email invalid");
			Collection<String> Depts=employeeService.getAllDept();
			model.put("depts", Depts);
			model.put("employee", ex);
			return new ModelAndView("editpage");  // forward 不需要加model
		}
	}

	@ResponseBody
	@CrossOrigin  //允许 Cross-Origin Resource Sharing
	@RequestMapping(value={"/listall"}, method=RequestMethod.GET)
	public Collection<Employee> ListAllEmpl() {
		Collection<Employee> EmpList=employeeService.getAllEmp();
		return EmpList;
	}


	/* 注掉删除
	@RequestMapping(value="/deleteemp/{id}", method=RequestMethod.GET)
	public String deleteEmpCommit(@PathVariable("id") Integer id) {
		Employee ex= employeeMapper.findEmpById(id);
		System.out.println("deleting "+ex);
		employeeMapper.deleteEmpById(id);
		//redirect 重定向到一个地址
		return "redirect:/emps";
	}
	*/
}
