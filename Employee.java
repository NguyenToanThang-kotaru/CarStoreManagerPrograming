
import java.util.Scanner;


public class Employee extends Person{
    protected  String ID;
    private String position;
    private String startDate;
    private long salary;
    public Employee(String ID,String name,String address,String phone,short age, String position,String startDate,long salary){
        super(name, address, phone, age);
        this.ID=ID;
        this.position=position;
        this.startDate=startDate;
        this.salary=salary;
    }
    public String getID(){
        return ID;
    }
    public void setID(String ID){
        this.ID=ID;
    }
    public String getPosition(){
        return position;
    }
    public void setPosition(String position){
        this.position=position;
    }
    public String getStartDate(){
        return startDate;
    }
    public void setStartDate(String startDate){
        this.startDate=startDate;
    }
    public Long getSalary(){
        return salary;
    }
    public void setSalary(long salary){
        this.salary=salary;
    }
    public void input(){
        super.input();
        Scanner reader=new Scanner(System.in);
        System.out.println("Nhập EmployeeID ");
        this.ID=reader.nextLine();
        System.out.println("Nhập Position  ");
        this.position=reader.nextLine();
        System.out.println("Nhập StartDate ");
        this.startDate=reader.nextLine();
        System.out.println("Nhập Salary ");
        this.salary=reader.nextLong();
        reader.nextLine();
       
    }
    public void display(){
        super.display();
        System.out.println("EmployeeID "+ID);
        System.out.println("Position "+position);
        System.out.println("StartDate "+startDate);
        System.out.println("Salary "+salary);
    }
    // public String toString(){
        
    // }
}

