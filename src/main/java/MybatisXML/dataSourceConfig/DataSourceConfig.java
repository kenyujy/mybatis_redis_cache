package MybatisXML.dataSourceConfig;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//requires JDBC dependency!
@Component
@Configuration
//@PropertySource(value = {"classpath:person.properties"}) //指定另外单独的配置文件
//@ConfigurationProperties (prefix = "data-source-config") //变量的名字：prefix
public class DataSourceConfig {
	
	@Value("${my.database.url}")
	private String databaseUrl;
	
	@Value("${my.database.username}")
	private String databaseUser;
	
	@Value("${my.datasource.password}")
	private String databasePassword;
	
	@Value("${my.datasource.driver-class-name}")
	private String databaseDriver;	
	
	@Bean
    public DataSource getDataSource() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(databaseDriver);
        dataSourceBuilder.url(databaseUrl);
        dataSourceBuilder.username(databaseUser);
        dataSourceBuilder.password(databasePassword);
        return dataSourceBuilder.build();
	}
	
	/*
	@Bean
    public SqlSessionFactory getSqlSession() throws IOException {
		String resource = "/resources/mybatisConfig/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}
	*/
    
	
	//create datasource from application.properties
	/*
	@Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dateSource() {
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        DataSource dataSource = dataSourceBuilder.build();
        return dataSource;
    }
    */
}
