
import java.util.Scanner;


public class Employee extends Person{
    protected  String EmployeeID;
    private String Position;
    private String StartDate;
    private Long Salary;
    public Employee(String EmployeeID,String name,String address,String phone,short age, String Position,String StartDate,Long Salary){
        super(name, address, phone, age);
        this.EmployeeID=EmployeeID;
        this.Position=Position;
        this.StartDate=StartDate;
        this.Salary=Salary;
    }
    public String getEmployeeID(){
        return EmployeeID;
    }
    public void setEmployeeID(String EmployeeID){
        this.EmployeeID=EmployeeID;
    }
    public String getPosition(){
        return Position;
    }
    public void setPosition(String Position){
        this.Position=Position;
    }
    public String getStartDate(){
        return StartDate;
    }
    public void setStartDate(String StartDate){
        this.StartDate=StartDate;
    }
    public Long getSalary(){
        return Salary;
    }
    public void setSalary(Long Salary){
        this.Salary=Salary;
    }
    public void input(){
        super.input();
        Scanner reader=new Scanner(System.in);
        System.out.println("Nhập EmployeeID ");
        this.EmployeeID=reader.nextLine();
        System.out.println("Nhập Position  ");
        this.Position=reader.nextLine();
        System.out.println("Nhập StartDate ");
        this.StartDate=reader.nextLine();
        System.out.println("Nhập Salary ");
        this.Salary=reader.nextLong();
        reader.nextLine();
       
    }
    public void display(){
        super.display();
        System.out.println("EmployeeID "+getEmployeeID());
        System.out.println("Position "+getPosition());
        System.out.println("StartDate "+getStartDate());
        System.out.println("Salary "+getSalary());
    }
}

