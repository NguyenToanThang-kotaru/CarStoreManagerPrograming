
import java.util.Scanner;

public class Employee extends Person {
    Scanner reader = new Scanner(System.in);
    private static int currentIDNumber = -1;
    private String ID;
    private String position;
    private String startDate;
    private long salary;

    public Employee(){
        ID = "";
        position = "";
        startDate = "";
        salary = 0;
    }

    public Employee(Employee employee){
        super((Person)employee);
        this.ID = employee.ID;
        this.position = employee.position;
        this.startDate = employee.startDate;
        this.salary = employee.salary;    
    }

    public Employee(String ID, String name, String address, String phone, short age, String position, String startDate, long salary) {
        super(name, address, phone, age);
        this.ID = ID;
        this.position = position;
        this.startDate = startDate;
        this.salary = salary;
    }

    // Tạo ID mới cho nhân viên
    private static String generateNextID(){
        return String.format("NV-%05d", ++currentIDNumber);
    }

    // Lấy ID của nhân viên mới nhất
    public static String getLatestID (){
        return String.format("NV-%05d", currentIDNumber);
    }

    // Tăng số ID, sử dụng khi đọc file, khi khởi động chương trình
    public static void increaseCurrentIDNumber(){
        Employee.currentIDNumber++;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public void input() {
        super.input();
        System.out.print("Nhập vị trí: ");
        this.position = reader.nextLine();
        System.out.print("Nhập ngày vào công ty: ");
        this.startDate = reader.nextLine();
        System.out.print("Nhập lương: ");
        this.salary = reader.nextLong();
        reader.nextLine();
        this.ID = generateNextID();
    }

    @Override
    public void display() {
        super.display();
        System.out.println("EmployeeID " + ID);
        System.out.println("Position " + position);
        System.out.println("StartDate " + startDate);
        System.out.println("Salary " + salary);
    }

    @Override
    public String toString() {
        return "Employee," + this.ID + "," + this.name + "," + this.address + "," + this.phone + "," + this.age + ","
                + this.position + "," + this.startDate + "," + this.salary;
    }
}
