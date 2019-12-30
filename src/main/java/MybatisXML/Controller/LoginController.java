package MybatisXML.Controller;

import javax.servlet.http.HttpSession;

import MybatisXML.Entitymodel.LoginUser;
import MybatisXML.Entitymodel.UserFromForm;
import MybatisXML.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value={"/","/user_login","user_login","index.html","home.html"}, method=RequestMethod.GET) //把映射做好
    public String index() { 
        return "user_login";
	}
	
	//SpringMVC自动将表单请求参数和入参对象封装，要求请求参数的名字和入参对象里面的属性名一样
	@RequestMapping(value={"/user_login"}, method=RequestMethod.POST)
	public ModelAndView loginAuthenticate(@ModelAttribute UserFromForm user, ModelMap model, HttpSession session) {
		LoginUser loginUser= loginService.getUserByAuth(user.getUsername(), user.getPassword());
		//比较2个String是否相等 String.equals(Object)方法
		System.out.println(user);
		System.out.println(loginUser);
		if (loginUser!= null && loginUser.getPassword().equals(user.getPassword())) {

			session.setAttribute("username", loginUser.getUser_name());
			session.setAttribute("userId",loginUser.getUser_id());
			session.setAttribute("lastLogin",loginUser.getLastLogin());
			loginService.updateLastLogin(loginUser.getUser_id());    //更新用户登陆时间
			return new ModelAndView ("redirect:dashboard");
			}else {
			model.addAttribute("msg", "用户名或密码错误!");
			return new ModelAndView("user_login");
		}
	}
		
	@RequestMapping(value= {"/dashboard","main","main.html"}, method=RequestMethod.GET)
    public String dashboard() { 
        return "dashboard";
	}
	
	@RequestMapping(value="/errors", method=RequestMethod.GET)
    public String errors() { 
        return "errors";
	}
}
