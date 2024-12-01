import java.util.Scanner;
import java.util.Arrays;
// import java.io.FileReader;
// import java.io.BufferedReader;
// import java.io.FileWriter;

public class OrderList implements IDisplayable {
    Scanner r = new Scanner(System.in);
    private Order orders[];
    private static int length = 0;
    public OrderList(){
        length = 0;
        orders = new Order[0];
    }
    public OrderList(int n, Order[] orderlist){
        length = n;
        orders = Arrays.copyOf(orderlist, n);
    }
    public static int getLength(){
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
            System.out.println("Order "+ i+1 + ":");
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
    public void edit(String orderID){
        for(int i=0; i<length; i++){
            if(orders[i].getID().equals(orderID)){
                System.out.println("Đã tìm thấy mã đơn hàng, vui lòng nhập lại thông tin:");
                orders[i].input();
                break;
            }
        }
        System.out.println("Không tìm thấy mã đơn hàng!");
    }
    public void delete(){
        System.out.print("Nhập mã đơn hàng muốn xóa: ");
        String orderID = r.nextLine();
        delete(orderID);
    }
    public void delete(String orderID){
        for(int i=0; i<length; i++){
            if(orders[i].getID().equals(orderID)){
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
            if(orders[i].getID().equals(orderID)){
                System.out.println("Đã tìm thấy mã đơn hàng.");
                return orders[i];
            }
        }
        System.out.println("Không tìm thấy mã đơn hàng!");
        return null;
    }
    public Order[] getOrderList(){
        return orders;
    }
}
