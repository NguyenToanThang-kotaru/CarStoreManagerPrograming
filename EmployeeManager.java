import java.util.Scanner;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;


public class EmployeeManager{
    Scanner scanner=new Scanner(System.in);
    private EmployeeList1 employeeList1;
    public EmployeeManager(){
        employeeList1= new EmployeeList1();
       

    }
    public void readFromFile("./employee.txt"){
        try {
            BufferedReader input = new BufferedReader(new FileReader("./database/employee.txt"));
            String line = input.readLine();
            while (line != null) {
                String[] arr = line.split(",");
               this.employeeList1.add(new Employee(arr[1],arr[2],arr[3],arr[4],Short.parseShort(arr[5]),arr[6],arr[7]));
                
                line = input.readLine();
            }
    
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }            
    }
    
    public void writeToFile("./employee.txt"){
        Employee[] employees = EmployeeList1.getEmployees();
        try {
            FileWriter fw = new FileWriter("./database/employee.txt");
            for(Employee employee : employees){
                fw.write(employee.toString());
                fw.write("\r\n");
            }
            fw.close();
            } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void displayMenu() {
        while (true) {
            System.out.println("==== MENU ====");
            System.out.println("1. Đọc danh sách nhân viên từ tệp");
            System.out.println("2. Hiển thị danh sách nhân viên");
            System.out.println("3. Thêm nhân viên mới");
            System.out.println("4. Ghi danh sách nhân viên vào tệp");
            System.out.println("5. Thoát");
            System.out.print("Chọn một lựa chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    readFromFile("./employees.txt");
                    break;
                case 2:
                    displayEmployees();
                    break;
                case 3:
                    addEmployee();
                    break;
                case 4:
                    writeToFile("./employees.txt");
                    break;
                case 5:
                    System.out.println("Thoát chương trình...");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại.");
                    break;
            }
        }
    }
    
}