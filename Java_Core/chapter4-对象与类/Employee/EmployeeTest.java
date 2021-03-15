package Employee;
import java.time.*;

public class EmployeeTest {
    public static void main(String[]args){
        Employee[]staff =new Employee[2];

        staff[0]=new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[1]=new Employee("Harry Jacker", 50000, 1989, 10, 1);

        for(Employee e:staff)
            e.raiseSalary(5);
        
        for(Employee e:staff)
            System.out.println("name="+e.getName()+",salary="+e.getSalary()+",hireDay="+e.getHireDay());
    }
}

class Employee{
    private String name;
    private double salary;
    private LocalDate hireDay;
    
    public Employee(String n,double s,int year,int month,int day){
        name=n;
        salary=s;
        hireDay=LocalDate.of(year,month,day);//构造一个以参数给定的日期对象
    }

    public String getName(){
        return name;
    }

    public double getSalary(){
        return salary;
    }

    public LocalDate getHireDay(){
        return hireDay;
    }

    public void raiseSalary(double byPrecent){
        double raise=salary*byPrecent/100;
        salary+=raise;
    }
}
