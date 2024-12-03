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
            System.out.println("2: Xem lịch sử mua hàng của khách hàng");
            System.out.println("3: Thêm khách hàng");
            System.out.println("4: Sửa thông tin khách hàng");
            System.out.println("5: Xoá khách hàng");
            System.out.println("6: Tìm khách hàng");
            System.out.println("exit: Thoát");
            String luachon = "";
            System.out.print("Nhập lựa chọn: ");
            luachon = sc.nextLine();
            Customer customer;
            switch (luachon) {
                case "1":
                    HeaderFooter.printHeader("Thông tin của các khách hàng");
                    shopCustomers.display();
                    HeaderFooter.printFooter();
                    break;
                case "2":
                    System.out.print("Nhập ID khách hàng muốn xem lịch sử mua: ");
                    String ID = sc.nextLine();
                    customer = shopCustomers.search(ID);
                    if(customer != null){
                        customer.displayOrderHistory();
                    } else{
                        System.out.println("Không tìm thấy khách hàng");
                    }
                    break;
                case "3":
                    HeaderFooter.printHeader("Thêm khách hàng");
                    shopCustomers.add();
                    HeaderFooter.printFooter();
                    Customer newCustomer = shopCustomers.search(Customer.getLatestID());
                    if(newCustomer != null){
                        HeaderFooter.printHeader("Khách hàng vừa thêm");
                        newCustomer.display();
                        HeaderFooter.printFooter();
                    } else{
                        System.out.println("!!!Lỗi, chưa thêm khách hàng thành công");
                    }
                    break;
                case "4":
                    HeaderFooter.printHeader("Sửa khách hàng");
                    shopCustomers.edit();
                    HeaderFooter.printFooter();
                    break;
                case "5":
                    HeaderFooter.printHeader("Xoá khách hàng");
                    shopCustomers.delete();
                    HeaderFooter.printFooter();
                    break;
                case "6":
                    HeaderFooter.printHeader("Tìm kiếm khách hàng");
                    customer = shopCustomers.search();
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
            Customer currentCustomer = null;
            OrderList currentOrderHistory = null;
            Order currentOrder = null;
            while (line != null) {
                String[] arr = line.split(",");
                if(arr[0].equals("Customer")){
                    if(currentCustomer != null){
                        currentOrderHistory.add(currentOrder);
                        currentCustomer.addOrdersToOrderHistory(currentOrderHistory);
                        shopCustomers.add(currentCustomer);
                    }
                    currentCustomer = new Customer(arr[1], arr[2], arr[3], arr[4], Short.parseShort(arr[5]));
                    currentOrderHistory = new OrderList();
                    Customer.increaseCurrentIDNumer();
                } else
                if(arr[0].equals("Order")){
                    if(currentOrder != null){
                        currentOrderHistory.add(currentOrder);
                    }
                    currentOrder = new Order(arr[1], arr[2], Long.parseLong(arr[3]), arr[4], arr[5]);
                } else
                if(arr[0].equals("Car")){
                    currentOrder.addProductToOrder(new Car(arr[1], arr[2], arr[3], arr[4], Long.parseLong(arr[5]), arr[6], Integer.parseInt(arr[7]), Byte.parseByte(arr[8])));
                } else
                if(arr[0].equals("Motorbike")){
                    currentOrder.addProductToOrder(new Motorbike(arr[1], arr[2], arr[3], arr[4], Long.parseLong(arr[5]), arr[6], Integer.parseInt(arr[7]), Short.parseShort(arr[8])));
                }

                line = input.readLine();
            }
            if(currentOrder != null){
                currentOrderHistory.add(currentOrder);
            }

            if(currentCustomer != null){
                currentCustomer.addOrdersToOrderHistory(currentOrderHistory);
                shopCustomers.add(currentCustomer);
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
                Order[] orderHistory = customer.getOrderHistory();
                for(Order order : orderHistory){
                    fw.write(order.toString());
                    fw.write("\r\n");
                    Product[] orderedProducts = order.getOrderedProducts();
                    for(Product product : orderedProducts){
                        fw.write(product.toString());
                        fw.write("\r\n");
                    }
                }
            }
            fw.close();
            } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Customer searchByPhone(String phone){
        return shopCustomers.searchByPhone(phone);
    }

    public void add(){
        shopCustomers.add();
    }

    public Customer search(String ID){
        return shopCustomers.search(ID);
    }

    public void addOrderToOrderHistoryOfCustomer(String ID, Order order){
        shopCustomers.addOrderToOrderHistoryOfCustomer(ID, order);
    }
}
