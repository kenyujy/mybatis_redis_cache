package MybatisXML.Service;

import java.util.Collection;

import MybatisXML.Entitymodel.Employee;
import MybatisXML.MapperConfig.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@CacheConfig(cacheNames="emps") //缓存公共配置
@Service
public class EmployeeService {

	@Autowired 
	private EmployeeMapper employeeMapper;
	
	/*  CacheManager 管理Cache。cache管理缓存，每个缓存组件有唯一名字
	 *  @Cacheable 把查询结果加入缓存，以后查询不用调用方法
	 *  cacheNames/value  缓存组件的名字, 数组方式指定多个缓存
	 *  key:缓存数据使用的key，可以指定，默认是方法参数的值
	 *  key/keyGenerator 二取一
	 *  condition 指定符合条件情况下才缓存
	 *  unless 指定符合条件情况下不缓存
	 *  sync 是否使用异步模式
	 *  
	 *  默认配置类SimpleCacheConfiguration ->注册CacheManager ConcurrentMapCacheManager
	 *  	可以获取和创建ConcurrentMapCahce类型缓存组件, 把数据保存到ConcurrentMap
	 *  
	 *  --------- redis ----------
	 *  RedisCacheManager
	 *  RedisCache
	 *  默认以序列化数据保存缓存
	 */
	
	@Cacheable (cacheNames="emps", condition= "#id>0") //缓存, 查询方法调用之前先看有没有缓存数据
	public Employee findEmpById(Integer id) {
		Employee retrieved = employeeMapper.findEmpById(id);
		return retrieved;
	}
	
	public Collection<Employee> getAllEmp(){
		Collection<Employee> EmpList= employeeMapper.findAllEmp();
		return EmpList;
	}
	
	public Collection<String> getAllDept(){
		Collection<String> Depts= employeeMapper.getAllDept();
		return Depts;
	}
	
	/*
	@Caching(										//多个规则
		cacheable = {
				@Cacheable (key="#Name")},//缓存, 利用方法返回的result的ID缓存数据
		put = {
				@CachePut (key="#result.ID") //@CachePut 无论是否有缓存，都会执行方法,undesirable!!!
		}
	)
	*/

	@Cacheable (key="#result.Name")
	public Employee findEmpByName(String Name) {
		Employee s= employeeMapper.findEmpByName(Name);
		return s;
	}
	
	@CachePut(key="#employee.Name")  //既调用查询方法, 也更新缓存, 查询方法调用之后更新缓存数据
			   //保存key默认是Employee Object, 必须改为和查询缓存的key 类型（）一致, 才能一起起作用
	public void updateEmp(Employee employee) {
		employeeMapper.updateEmp(employee);
	}
	
	@CachePut(key="#e.Name") //更新缓存  函数没有返回值不能用 #result!!!!
	public void insertEmp(Employee e) {
		employeeMapper.insertEmp(e);
	}
	
	@CacheEvict(value="emps", key="#id") //清除缓存
	public void deleteEmp(Integer id) {
		employeeMapper.deleteEmpById(id);
	}
}
