package MybatisXML.MvcConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@EnableWebMvc
@Component
public class MyMvcConfig implements WebMvcConfigurer {
	
	//@Autowired
	//LoginHandlerInterceptor loginHandlerInterceptor; //inject loginHandlerInterceptor
	/*
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/home").setViewName("index");
	}
	*/

	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
			.excludePathPatterns("/user_login","/user_login*","/listall","index","/","home","/css/**","/i18n/**","/templates/**"); //必须把静态资源都排除,把登录页的login排除，否则stack overflow
		
		//registry.addInterceptor(localeChangeInterceptor());
	}
}
