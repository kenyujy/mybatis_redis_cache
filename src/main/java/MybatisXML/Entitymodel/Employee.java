package MybatisXML.Entitymodel;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;


public class Employee implements Serializable {

    @Nullable
	private Integer ID;
	
    @NotEmpty(message="名字不能为空") // 数据非空校验
    @Length(min=2, max=10)  //长度校验
    private String Name;
    
    @NotNull
    @Min(value=2000)  // 最小值
    private float Salary;
    
    @NotEmpty
    private String Dept;
    
    @NotEmpty 
    //@javax.validation.constraints.Email // 对邮箱格式校验是否合法
    private String Email;
    
    @NotEmpty
    private String Phone;

    public Employee(){

    }

    //constructor 函数参数要写全，否则不能把查询返回的值封装成Employee类！
    public Employee(int ID, String Name, float Salary, String Dept, String Email, String Phone){
    	this.ID=ID;
        this.Name=Name;
        this.Salary=Salary;
        this.Dept=Dept;
        this.Email=Email;
        this.Phone=Phone;
    }
    
    public Employee(String Name, float Salary, String Dept, String Email, String Phone){
        this.Name=Name;
        this.Salary=Salary;
        this.Dept=Dept;
        this.Email=Email;
        this.Phone=Phone;
    }
    
    public int getID() {  
        return ID;  
    }  
  
    public void setID(int ID) {  
        this.ID = ID;  
    }
  
    public String getName() {  
        return Name;  
    }  
  
    public void setName(String name) {  
        this.Name = name;  
    }
    
    public float getSalary() {  
        return Salary;  
    } 
    
    public void setSalary(float salary) {  
        this.Salary = salary;  
    } 
    
    public String getDept() {  
        return Dept;  
    } 
    
    public void setDept(String Dept) {  
        this.Dept = Dept;  
    } 
    
    public String getEmail() {  
        return Email;  
    } 
    
    public void setEmail(String Email) {  
        this.Email = Email;  
    } 
    
    public String getPhone() {  
        return Phone;  
    } 
    
    public void setPhone(String phone) {  
        this.Phone = phone;  
    } 
  
    @Override
    public String toString(){  
        return "EmployeeID: "+ ID +", "+"Employee Name: "+ Name +", "+"Salary: "+ Salary+", "+"Dept: "+Dept+", Email: "+Email+", "+"Phone: "+Phone;  
    }  
}  