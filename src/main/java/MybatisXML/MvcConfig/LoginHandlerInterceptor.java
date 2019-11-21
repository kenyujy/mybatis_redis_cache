package MybatisXML.MvcConfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/*
 * 登录检查 HandlerInterceptorAdapter做条件判断
 */
@Component
public class LoginHandlerInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Object user= request.getSession().getAttribute("username");
		if (user== null) {
			//未登录
			request.setAttribute("msg", "please sign in");
			request.getRequestDispatcher("/user_login").forward(request, response);;
			return false;
		} else{
			//已登录
			return true;}
	}	
}
