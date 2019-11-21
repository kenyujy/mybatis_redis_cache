package MybatisXML.MvcConfig;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

//@Component(value="localeResolver")  //必须改成这个名字才能生效, 替代spring 的localeResolver,spring初始化扫描到这个Bean
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //点击链接改locale，链接需要 ...?locale=zh_CN 或者 ...?locale=en_US
        Locale l=null;
        String localeStr= request.getParameter("locale");  //获取上面请求链接的locale
        if(null!= localeStr && !"".equals(localeStr)) {
            l= new Locale(localeStr.split("-")[0], localeStr.split("-")[1]);
        }else {
            l= request.getLocale();
        }
        return l;
    }

    @Override
    public void setLocale(HttpServletRequest request, @Nullable HttpServletResponse response, @Nullable Locale locale){
    }

}
