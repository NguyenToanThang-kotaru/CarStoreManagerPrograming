import java.util.Arrays;
import java.util.Scanner;

public class EmployeeList implements IDisplayable{
    Scanner scanner=new Scanner(System.in);
    private int length;
    private Employee[] employees;
    public EmployeeList(){
        length = 0;
        employees = new Employee[0];
    }
    public EmployeeList(int length, Employee[] employees){
        this.length=length;
        this.employees=employees;

    }
    public void input(){
        System.out.println("Nhập số lượng nhân viên ");
        length=Integer.parseInt(scanner.nextLine());
        employees=new Employee[length];
        for(int i=0;i<length;i++){
           employees[i] = new Employee();
           employees[i].input();
        }
    }
    public void display(){
        if(length == 0){
            System.out.println("Không có nhân viên nào");
        }else{
            System.out.printf("\n");
            for(Employee employee:employees){
                employee.display();
                System.out.printf("\n");
            }
        }
    }
    public void add(){
        employees=Arrays.copyOf(employees,length+1);
        employees[length]=new Employee();
        employees[length].input();
        length++;
    }
    public void add(Employee employee){
        employees=Arrays.copyOf(employees,length+1);
        employees[length]= new Employee(employee);
        length++;
    }
    public Employee search(String ID){
        for(Employee employee:employees){
            if(employee.getID().equalsIgnoreCase(ID)){
                return employee;
            }
        }
        return null;

    }
    public Employee search(){
        System.out.print("Nhập ID nhân viên cần tìm: ");
        String ID=scanner.nextLine();
        return search(ID);
    }
    public int getLength(){
        return length;
    }
    public void edit(String ID) {
        Employee employee = search(ID);
        if(employee != null){
            boolean exit = false;
            do{
                System.out.println("---Thông tin nhân viên hiện tại---");
                employee.display();
                System.out.println("1: Sửa tên");
                System.out.println("2: Sửa địa chỉ");
                System.out.println("3: Sửa số điện thoại");
                System.out.println("4: Sửa tuổi");
                System.out.println("exit: Thoát");
                String luachon = "";
                System.out.print("Nhập lựa chọn: ");
                luachon = scanner.nextLine();
                switch (luachon) {
                    case "1":
                        System.out.print("Nhập tên mới: ");
                        String newName = scanner.nextLine();
                        employee.setName(newName);
                        break;
                    case "2":
                        System.out.print("Nhập địa chỉ mới: ");
                        String newAddress = scanner.nextLine();
                        employee.setAddress(newAddress);
                        break;
                    case "3":
                        System.out.print("Nhập số điện thoại mới: ");
                        String newPhone = scanner.nextLine();
                        employee.setPhone(newPhone);
                        break;
                    case "4":
                        System.out.print("Nhập tuổi mới: ");
                        short newAge = Short.parseShort(scanner.nextLine());
                        employee.setAge(newAge);
                        break;
                    case "exit":
                        exit = true;
                        break;
                    default:
                        System.out.println("!------Lỗi------!");
                        System.out.println("Nếu muốn thoát vui lòng nhập \"exit\"");
                        break;
                }
            } while(!exit);
        } else{
            System.out.println("Không tìm thấy nhân viên!!!");
        }
    }
    public void edit(){
        System.out.println("Nhập ID nhân viên muốn chỉnh sửa ");
        String ID=scanner.nextLine();
        edit(ID);
    }
    public void delete() {
        System.out.println("Nhập ID nhân viên cần xoá: ");
        String ID = scanner.nextLine();
        delete(ID);
    }
    
    public void delete(String ID) {
        boolean isFound = false;
        for(int i = 0; i < length; i++){
            if(employees[i].getID().equalsIgnoreCase(ID)){
                isFound = true;
                for(int j = i; j < length - 1; j++){
                    employees[j] = employees[j + 1];
                }
                employees = Arrays.copyOf(employees, length - 1);
                length--;
                break;
            }
        }

        if(isFound){
            System.out.println("Xoá nhân viên thành công");
        } else{
            System.out.println("Không tìm thấy nhân viên!!!");
        }
    }
    public Employee[] getEmployees(){
        Employee[] copyEmployees = Arrays.copyOf(this.employees, this.length);
        return copyEmployees;
    }    
}
