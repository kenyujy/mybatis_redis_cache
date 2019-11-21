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
		LoginUser loginUser= loginService.getUserByAuth(user.getUserName(), user.getPasswd());
		//比较2个String是否相等 String.equals(Object)方法
		if (loginUser!= null && loginUser.getPasswd().equals(user.getPasswd())) {
			if (loginUser.getLevel1_auth()>0) {
				session.setAttribute("level1",1);
			}
			if (loginUser.getLevel2_auth()>0) {
				session.setAttribute("level2",1);
			}
			if (loginUser.getLevel3_auth()>0) {
				session.setAttribute("level3",1);
			}
			session.setAttribute("username", loginUser.getUserName());
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
