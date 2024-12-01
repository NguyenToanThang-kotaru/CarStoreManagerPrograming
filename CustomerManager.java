import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.util.Scanner;

public class CustomerManager {
    Scanner sc = new Scanner(System.in);
    private CustomerList shopCustomers;
    
    public CustomerManager() {
        shopCustomers = new CustomerList();
        this.readFromFile();
    }
    

    public void menu() {
        boolean exit = false;
        do{
            HeaderFooter.printHeader("Menu");
            System.out.println("1: Xem khách hàng");
            System.out.println("2: Thêm khách hàng");
            System.out.println("3: Sửa thông tin khách hàng");
            System.out.println("4: Xoá khách hàng");
            System.out.println("5: Tìm khách hàng");
            System.out.println("exit: Thoát");
            String luachon = "";
            System.out.print("Nhập lựa chọn: ");
            luachon = sc.nextLine();
            switch (luachon) {
                case "1":
                    HeaderFooter.printHeader("Thông tin của các khách hàng");
                    shopCustomers.display();
                    HeaderFooter.printFooter();
                    break;
                case "2":
                    HeaderFooter.printHeader("Thêm khách hàng");
                    shopCustomers.add();
                    HeaderFooter.printFooter();
                    Customer newCustomer = shopCustomers.search(Customer.getNewestID());
                    if(newCustomer != null){
                        HeaderFooter.printHeader("Khách hàng vừa thêm");
                        newCustomer.display();
                        HeaderFooter.printFooter();
                    } else{
                        System.out.println("!!!Lỗi, chưa thêm khách hàng thành công");
                    }
                    break;
                case "3":
                    HeaderFooter.printHeader("Sửa khách hàng");
                    shopCustomers.edit();
                    HeaderFooter.printFooter();
                    break;
                case "4":
                    HeaderFooter.printHeader("Xoá khách hàng");
                    shopCustomers.delete();
                    HeaderFooter.printFooter();
                    break;
                case "5":
                    HeaderFooter.printHeader("Tìm kiếm khách hàng");
                    Customer customer = shopCustomers.search();
                    if(customer != null){
                        customer.display();
                    } else{
                        System.out.println("Không tìm thấy khách hàng!!!");
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
        } while(!exit);
    }

    public void readFromFile(){
        try {
            BufferedReader input = new BufferedReader(new FileReader("./database/customers.txt"));
            String line = input.readLine();
            while (line != null) {
                String[] arr = line.split(",");
                this.shopCustomers.add(new Customer(arr[1], arr[2], arr[3], arr[4], Short.parseShort(arr[5])));
                Customer.increaseCurrentIDNumer();
                line = input.readLine();
            }

            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }            
    }

    public void writeToFile(){
        Customer[] customers = shopCustomers.getCustomers();
        try {
            FileWriter fw = new FileWriter("./database/customers.txt");
            for(Customer customer : customers){
                fw.write(customer.toString());
                fw.write("\r\n");
            }
            fw.close();
            } catch (Exception e) {
            System.out.println(e);
        }
    }
}
