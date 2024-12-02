import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class EmployeeManager {
    Scanner scanner = new Scanner(System.in);
    private EmployeeList shopEmployee;

    public EmployeeManager() {
        shopEmployee = new EmployeeList();
        this.readFromFile();

    }

    public void readFromFile(){
        try {
            BufferedReader input = new BufferedReader(new FileReader("./database/employees.txt"));
            String line = input.readLine();
            while (line != null) {
                String[] arr = line.split(",");
               this.shopEmployee.add(new Employee(arr[1],arr[2],arr[3],arr[4],Short.parseShort(arr[5]),arr[6],arr[7],Long.parseLong(arr[8])));
                Employee.increaseCurrentIDNumber();
                line = input.readLine();
            }
    
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }            
    }

    public void writeToFile(){
        Employee[] employees = shopEmployee.getEmployees();
        try {
            FileWriter fw = new FileWriter("./database/employees.txt");
            for(Employee employee : employees){
                fw.write(employee.toString());
                fw.write("\r\n");
            }
            fw.close();
            } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void menu() {
        boolean exit = false;
        do {
            HeaderFooter.printHeader("Menu");
            System.out.println("1: Xem nhân viên");
            System.out.println("2: Thêm nhân viên");
            System.out.println("3: Sửa thông tin nhân viên");
            System.out.println("4: Xoá nhân viên");
            System.out.println("5: Tìm nhân viên");
            System.out.println("exit: Thoát");
            String luachon = "";
            System.out.print("Nhập lựa chọn: ");
            luachon = scanner.nextLine();
            switch (luachon) {
                case "1":
                    HeaderFooter.printHeader("Thông tin của các nhân viên");
                    shopEmployee.display();
                    HeaderFooter.printFooter();
                    break;
                case "2":
                    HeaderFooter.printHeader("Thêm nhân viên");
                    shopEmployee.add();
                    HeaderFooter.printFooter();
                    break;
                case "3":
                    HeaderFooter.printHeader("Sửa nhân viên");
                    shopEmployee.edit();
                    HeaderFooter.printFooter();
                    break;
                case "4":
                    HeaderFooter.printHeader("Xoá nhân viên");
                    shopEmployee.delete();
                    HeaderFooter.printFooter();
                    break;
                case "5":
                    HeaderFooter.printHeader("Tìm kiếm nhân viên");
                    Employee employee = shopEmployee.search();
                    if (employee != null) {
                        employee.display();
                    } else {
                        System.out.println("Không tìm thấy nhân viên!!!");
                    }
                    HeaderFooter.printFooter();
                    break;
                case "exit":
                    exit = true;
                    this.writeToFile();
                    break;
                default:
                    System.out.println("!------Lỗi------!");
                    System.out.println("Nếu muốn thoát vui lòng nhập \"exit\"");
                    break;
            }
        } while (!exit);
    }

}
