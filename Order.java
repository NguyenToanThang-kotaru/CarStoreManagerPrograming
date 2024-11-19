import java.util.Scanner;

public class Order implements IDisplayable {
    Scanner r = new Scanner(System.in);
    private String ID;
    private String customerID;
//    private ProductList products;
    private String status;
    private String orderDate;
    private long totalPrice;
    public Order(){
        ID = "";
        customerID= "";
        status = "Đang xử lý";
        orderDate = "";
        totalPrice = 0;
    }
    public Order(String ID, String customerID, String orderDate, long totalPrice){
        this.ID = ID;
        this.customerID = customerID;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
    }
    public Order(Order order){
        this.ID = order.ID;
        this.customerID = order.customerID;
        this.status = order.status;
        this.orderDate = order.orderDate;
        this.totalPrice = order.totalPrice;
    }
    public void input(){
        System.out.print("Nhập ID đơn hàng: ");
        ID = r.nextLine();
        System.out.print("Nhập ID khách hàng: ");
        customerID = r.nextLine();
        System.out.print("Nhập ngày đặt: ");
        orderDate = r.nextLine();
        System.out.print("Nhập giá đơn: ");
        totalPrice = r.nextLong();
    }
    public void display(){
        System.out.println("Mã đơn: "+ID);
        System.out.println("Mã khách hàng: "+customerID);
        System.out.println("Trạng thái: "+status);
        System.out.println("Ngày đặt: "+orderDate);
        System.out.println("Giá đơn: "+totalPrice);
    }
    public String getID(){
        return ID;
    }
    public String getCustomerID(){
        return customerID;
    }
    public String getStatus(){
        return status;
    }
    public String getOrderDate(){
        return orderDate;
    }
    public long getTotalPrice(){
        return totalPrice;
    }
    public void setID(String ID){
        this.ID = ID;
    }
    public void setCustomerID(String customerID){
        this.customerID = customerID;
    }
    public void setOrderDate(String orderDate){
        this.orderDate = orderDate;
    }
    public void setTotalePrice(long totalPrice){
        this.totalPrice = totalPrice;
    }
}
