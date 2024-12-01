import java.util.Arrays;
import java.util.Scanner;

public class CustomerList {
    Scanner sc = new Scanner(System.in);
    private Customer[] customers;
    private int length;
    
    public CustomerList() {
        length = 0;
        customers = new Customer[0];
    }
    
    public CustomerList(int length, Customer[] customers){
        this.length = length;
        this.customers = customers;
    }
    
    public void input() {
        System.out.print("Nhập số lượng khách hàng: ");
        length = Integer.parseInt(sc.nextLine());
        customers = new Customer[length];
        for(int i = 0; i < length; i++){
            customers[i] = new Customer();
            customers[i].input();
        }
    }
    
    public void display() {
        if(length == 0){
            System.out.println("\nKhông có khách hàng nào\n");
        } else{
            System.out.printf("\n");
            for(Customer customer:customers){
                customer.display();
                System.out.printf("\n");
            }
        }
    }
    
    public void add() {
        customers = Arrays.copyOf(customers, length + 1);
        customers[length] = new Customer();
        customers[length].input();
        length++;
    }
    
    public void add(Customer customer) {
        customers = Arrays.copyOf(customers, length + 1);
        customers[length] = new Customer(customer);
        length++;
    }
    
    public void edit() {
        System.out.println("Nhập ID khách hàng cần chỉnh sửa: ");
        String ID = sc.nextLine();
        edit(ID);
    }
    
    public void edit(String ID) {
        Customer customer = search(ID);
        if(customer != null){
            boolean exit = false;
            do{
                System.out.println("---Thông tin khách hàng hiện tại---");
                customer.display();
                System.out.println("1: Sửa tên");
                System.out.println("2: Sửa địa chỉ");
                System.out.println("3: Sửa số điện thoại");
                System.out.println("4: Sửa tuổi");
                System.out.println("exit: Thoát");
                String luachon = "";
                System.out.print("Nhập lựa chọn: ");
                luachon = sc.nextLine();
                switch (luachon) {
                    case "1":
                        System.out.print("Nhập tên mới: ");
                        String newName = sc.nextLine();
                        customer.setName(newName);
                        break;
                    case "2":
                        System.out.print("Nhập địa chỉ mới: ");
                        String newAddress = sc.nextLine();
                        customer.setAddress(newAddress);
                        break;
                    case "3":
                        System.out.print("Nhập số điện thoại mới: ");
                        String newPhone = sc.nextLine();
                        customer.setPhone(newPhone);
                        break;
                    case "4":
                        System.out.print("Nhập tuổi mới: ");
                        short newAge = Short.parseShort(sc.nextLine());
                        customer.setAge(newAge);
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
            System.out.println("Không tìm thấy khách hàng!!!");
        }
    }
    
    public void delete() {
        System.out.println("Nhập ID khách hàng cần xoá: ");
        String ID = sc.nextLine();
        delete(ID);
    }
    
    public void delete(String ID) {
        boolean isFound = false;
        for(int i = 0; i < length; i++){
            if(customers[i].getID().equalsIgnoreCase(ID)){
                isFound = true;
                for(int j = i; j < length - 1; j++){
                    customers[j] = customers[j + 1];
                }
                customers = Arrays.copyOf(customers, length - 1);
                length--;
                break;
            }
        }

        if(isFound){
            System.out.println("Xoá khách hàng thành công");
        } else{
            System.out.println("Không tìm thấy khách hàng!!!");
        }
    }
    
    public Customer search() {
        System.out.print("Nhập ID khách hàng cần tìm: ");
        String ID = sc.nextLine();
        return search(ID);
    }

    public Customer search(String ID) {
        for(Customer customer : customers){
            if(customer.getID().equalsIgnoreCase(ID)){
                return customer;
            }
        }

        return null;
    }

    public Customer searchByPhone(String phone){
        for(Customer customer : customers){
            if(customer.getPhone().equalsIgnoreCase(phone)){
                return customer;
            }
        }

        return null;
    }
    public int getLength() {
        return length;
    }

    public Customer[] getCustomers(){
        return this.customers;
    }
}
