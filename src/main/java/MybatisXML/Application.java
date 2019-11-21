package MybatisXML;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("MybatisXML.MapperConfig")//扫描Mapper, 改了以后要注意，否则bean type could not be found
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableCaching  //开启缓存  只要redis 包导入了，redis缓存就会生效， 需要配置redis服务器地址，及运行redis
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
}