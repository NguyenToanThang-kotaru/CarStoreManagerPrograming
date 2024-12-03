   import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class OrderManager {
    Scanner r = new Scanner(System.in);
    private OrderList shopOrders;
    
    public OrderManager() {
        shopOrders = new OrderList();
        this.readFromFile();
    }

    public void menu() {
        boolean exit = false;
        do{
            HeaderFooter.printHeader("Menu");
            System.out.println("1: Xem đơn hàng");
            System.out.println("2: Sửa thông tin đơn hàng");
            System.out.println("3: Xoá đơn hàng");
            System.out.println("4: Tìm đơn hàng");
            System.out.println("exit: Thoát");
            String select = "";
            System.out.print("Nhập lựa chọn: ");
            select = r.nextLine();
            switch (select) {
                case "1":
                    HeaderFooter.printHeader("Thông tin của các đơn hàng");
                    shopOrders.display();
                    HeaderFooter.printFooter();
                    break;
                case "2":
                    HeaderFooter.printHeader("Sửa đơn hàng");
                    shopOrders.edit();
                    HeaderFooter.printFooter();
                    break;
                case "3":
                    HeaderFooter.printHeader("Xoá đơn hàng");
                    shopOrders.delete();
                    HeaderFooter.printFooter();
                    break;
                case "4":
                    HeaderFooter.printHeader("Tìm kiếm đơn hàng");
                    Order order = shopOrders.search();
                    if(order != null){
                        order.display();
                    } else{
                        System.out.println("Không tìm thấy đơn hàng!!!");
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
            BufferedReader input = new BufferedReader(new FileReader("./database/orders.txt"));
            String line = input.readLine();
            Order currentOrder = null;
            while (line != null) {
                String[] arr = line.split(",");
                if(arr[0].equals("Order")){
                    currentOrder = new Order(arr[1], arr[2], Long.parseLong(arr[3]), arr[4], arr[5]);
                    this.shopOrders.add(currentOrder);
                    Order.increaseCurrentIDNumer();
                }
                else if(arr[0].equals("Car"))
                    currentOrder.addProductToOrder(new Car(arr[1], arr[2], arr[3], arr[4], Long.parseLong(arr[5]), arr[6], Integer.parseInt(arr[7]), Byte.parseByte(arr[8])));
                else if(arr[0].equals("Motorbike"))
                    currentOrder.addProductToOrder(new Motorbike(arr[1], arr[2], arr[3], arr[4], Long.parseLong(arr[5]), arr[6], Integer.parseInt(arr[7]), Short.parseShort(arr[8])));
                line = input.readLine();
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }            
    }

    public void writeToFile(){
        Order[] orders = shopOrders.getOrders();
        try {
            FileWriter fw = new FileWriter("./database/orders.txt");
            for(int i = 0; i < orders.length; i++){
                fw.write(orders[i].toString());
                fw.write("\r\n");
                Product[] orderedProducts = orders[i].getOrderedProducts();
                for(Product orderedProduct : orderedProducts){
                    fw.write(orderedProduct.toString());
                    fw.write("\r\n");
                }
            }
            fw.close();
            } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void add(Order order){
        shopOrders.add(order);
    }
}
