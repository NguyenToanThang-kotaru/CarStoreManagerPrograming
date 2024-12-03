import java.util.Arrays;
import java.util.Scanner;
// import java.io.FileReader;
// import java.io.BufferedReader;
// import java.io.FileWriter;

public class OrderList implements IDisplayable {
    Scanner r = new Scanner(System.in);
    private Order orders[];
    private int length = 0;
    public OrderList(){
        length = 0;
        orders = new Order[0];
    }
    public OrderList(int n, Order[] orderlist){
        length = n;
        orders = Arrays.copyOf(orderlist, n);
    }
    public int getLength(){
        return length;
    }
    public void input(){
        System.out.print("Nhập số phần tử: ");
        length = r.nextInt();
        orders = new Order[length];
        for(int i=0; i<length; i++){
            System.out.printf("orders[%d]:\n", i);
            orders[i] = new Order();
            orders[i].input();
        }
    }
    public void display(){
        for(int i=0; i<length; i++){  
            System.out.printf("%-12s | %-13s | %-13s | %-13s |%-10s%n", "Mã đơn hàng", "Mã khách hàng", "Tổng đơn",
            "Ngày đặt hàng", "Trạng thái");
            orders[i].display();
        }
    }
    public void add(){
        orders = Arrays.copyOf(orders, length+1);
        orders[length] = new Order();
        orders[length].input();
        length++;
    }
    public void add(Order x){
        orders = Arrays.copyOf(orders, length+1);
        orders[length] = new Order(x);
        length++;
    }
    public void edit(){
        System.out.print("Nhập mã đơn hàng muốn sửa: ");
        String orderID = r.nextLine();
        edit(orderID);
    }
    public void edit(String ID) {
        Order order = search(ID);
        if(order != null){
            boolean exit = false;
            do{
                HeaderFooter.printHeader("Thông tin đơn hàng hiện tại");
                order.display();
                System.out.println("1: Sửa ngày đặt hàng");
                System.out.println("2: Sửa trạng thái đơn hàng");
                System.out.println("exit: Thoát");
                String select = "";
                System.out.print("Nhập lựa chọn: ");
                select = r.nextLine();
                switch (select) {
                    case "1":
                        System.out.print("Nhập ngày đặt hàng mới: ");
                        String newOrderDate = r.nextLine();
                        order.setOrderDate(newOrderDate);
                        break;
                    case "2":
                        System.out.println("Trạng thái đơn hàng mới: ");
                        System.out.println("1: Đã xử lý");
                        System.out.println("2: Đã giao");
                        System.out.println("3: Đã hủy");
                        System.out.print("Nhập lựa chọn: ");
                        byte selectStatus = r.nextByte();
                        
                        switch (selectStatus) {
                            case 1:
                                order.setStatus("Đã xử lý");
                                break;
                            case 2:
                                order.setStatus("Đã giao");
                                break;
                            case 3:
                                order.setStatus("Đã hủy");
                                break;
                            default:
                                System.out.println("Không tìm thấy lựa chọn!");
                                break;
                        }
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
            System.out.println("Không tìm thấy đơn hàng!!!");
        }
    }
    public void delete(){
        System.out.print("Nhập mã đơn hàng muốn xóa: ");
        String orderID = r.nextLine();
        delete(orderID);
    }
    public void delete(String orderID){
        for(int i=0; i<length; i++){
            if(orders[i].getID().equalsIgnoreCase(orderID)){
                System.out.println("Đã xóa đơn hàng có mã "+orderID);
                for(int j=i ;j<length-1; j++)
                    orders[j] = orders[j+1];
                orders = Arrays.copyOf(orders, length-1);
                length--;
                break;
            }
        }
        System.out.println("Không tìm thấy mã đơn hàng!");
    }
    public Order search(){
        System.out.print("Nhập mã đơn hàng muốn tìm kiếm: ");
        String orderID = r.nextLine();
        return search(orderID);
    }
    public Order search(String orderID){
        for(int i=0; i<length; i++){
            if(orders[i].getID().equalsIgnoreCase(orderID)){
                return orders[i];
            }
        }
        return null;
    }
    public Order[] getOrders(){
        Order[] copyOrders = Arrays.copyOf(this.orders, this.length);
        return copyOrders;
    }
}
