import java.util.Scanner;
public class Shop {
    Scanner sc = new Scanner(System.in);
    private CustomerManager customerManager = new CustomerManager();
    private ProductManager productManager = new ProductManager();
    private OrderManager orderManager = new OrderManager();

    private void muaHang(){
        ProductList currentProducts = new ProductList();
        currentProducts = productManager.buyProducts();

        if(currentProducts.getLength() > 0){
            System.out.print("Nhập số điện thoại: ");
            String phone = sc.nextLine();
            Customer customer = customerManager.searchByPhone(phone);
            if(customer == null){
                System.out.println("Khách hàng chưa tồn tại, mời thêm mới");
                HeaderFooter.printHeader("Thêm khách hàng mới");
                customerManager.add();
                HeaderFooter.printFooter();
                HeaderFooter.printHeader("Thông tin khách hàng mới");
                customerManager.search(Customer.getLatestID()).display();
                HeaderFooter.printFooter();
            } else{
                HeaderFooter.printHeader("Thông tin khách hàng");
                customer.display();
                HeaderFooter.printFooter();
            }

            Order newOrder = new Order();
            newOrder.input();
            newOrder.addProductListToOrder(currentProducts);
            HeaderFooter.printHeader("Thông tin đơn hàng vừa đặt");
            newOrder.display();
            HeaderFooter.printFooter();
            orderManager.add(newOrder);
        } else{
            System.out.println("Chưa có sản phẩm nào được mua");
        }

    }

    private void admin(){
        boolean exit = false;
        do{
            System.out.println("1. Quản lý khách hàng");
            System.out.println("2. Quản lý đơn hàng");
            System.out.println("3. Quản lý sản phẩm");
            System.out.println("4. Quản lý nhân viên");
            System.out.println("exit. Thoát");
            String luachon = "";
            luachon = sc.nextLine();
            switch (luachon) {
                case "1":
                    this.customerManager.menu();
                    break;
                case "2":
                    this.orderManager.menu();
                    break;
                case "3":
                    this.productManager.menu();
                    break;
                case "4":
                    // this.employeeManager.menu();
                    break;
                case "exit":
                    exit = true;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, muốn thoát nhập \"exit\"");
                    break;
            }
        } while(!exit);
    }
    public void menu(){
        boolean exit = false;
        do{
            System.out.println("1. Mua sản phẩm");
            System.out.println("2. Admin");
            System.out.println("exit. Thoát");
            String luachon = "";
            luachon = sc.nextLine();
            switch (luachon) {
                case "1":
                    this.muaHang();
                    break;
                case "2":
                    this.admin();
                    break;
                case "exit":
                    exit = true;
                    this.customerManager.writeToFile();
                    this.orderManager.writeToFile();
                    this.productManager.writeToFile();
                    // this.employeeManager.writeToFile();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
            }
        } while(!exit);
    }
}
