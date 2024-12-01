import java.util.Scanner;

public class Order implements IDisplayable {
    Scanner r = new Scanner(System.in);
    private String ID;
    private String customerID;
    private ProductList orderedProducts;
    private String status;
    private String orderDate;
    private long totalPrice;
    private static int currentIDNumber = -1;
    public Order(){
        ID = "";
        customerID= "";
        status = "Đang xử lý";
        orderDate = "";
        totalPrice = 0;
        orderedProducts = new ProductList();
    }
    public Order(String ID, String customerID, long totalPrice, String orderDate, String status){
        this.ID = ID;
        this.customerID = customerID;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.status = status;
        orderedProducts = new ProductList();
    }
    public Order(Order order){
        this.ID = order.ID;
        this.customerID = order.customerID;
        this.status = order.status;
        this.orderDate = order.orderDate;
        this.totalPrice = order.totalPrice;
        this.status = order.status;
        this.orderedProducts = order.orderedProducts;
    }
    // Tạo ra ID mới, format:
    // flag 0 (đệm thêm '0' cho đủ chiều rộng),
    // width 5 (chiều rộng tối thiểu), nếu ko đủ, kết hợp với flag 0 ở trên đệm thêm '0'
    // conversion d, thể hiện số nguyên
    private static String generateNextID(){
        return String.format("OD-%05d", ++currentIDNumber);
    }

    // Lấy ra ID của khách hàng mới nhất
    public static String getNewestID(){
        return String.format("OD-%05d", currentIDNumber);
    }

    // Tăng số ID, sử dụng khi đọc file, khi khởi động chương trình
    public static void increaseCurrentIDNumer(){
        Order.currentIDNumber++;
    }
    public void input(){
        ID = generateNextID();
        System.out.print("Nhập ID khách hàng: ");
        customerID = r.nextLine();
        System.out.print("Nhập ngày đặt: ");
        orderDate = r.nextLine();
        totalPrice = 0;
    }
    public void display(){
        System.out.println("Mã đơn: "+ID);
        System.out.println("Mã khách hàng: "+customerID);
        System.out.println("Trạng thái: "+status);
        System.out.println("Ngày đặt: "+orderDate);
        System.out.println("Giá đơn: "+totalPrice);
        System.out.println("Danh sách xe: ");
        if(orderedProducts != null)
            orderedProducts.display();
        else
            System.out.println("Chưa có xe nào.");
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
    public ProductList getOrderedProducts(){
        return orderedProducts;
    }
    public void setCustomerID(String customerID){
        this.customerID = customerID;
    }
    public void setOrderDate(String orderDate){
        this.orderDate = orderDate;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public void calculateTotalePrice(){
        for(int j=0; j<orderedProducts.getlength(); j++){
            Product product = orderedProducts.getProducts()[j];
            totalPrice += product.getPrice();
        }
    }
    // public void addProductToOrder(){
    //     Product x = null;
    //     boolean isTypedTrue = false;
    //     do{
    //         System.out.println("Loại xe:");
    //         System.out.println("1. Xe máy");
    //         System.out.println("2. Xe hơi");
    //         System.out.println("Nhập số: ");
    //         byte type = r.nextByte();
    //         switch (type) {
    //             case 1:
    //                 x = new Motorbike();
    //                 isTypedTrue = true;
    //                 break;
    //             case 2:
    //                 x = new Car();
    //                 isTypedTrue = true;
    //                 break;
    //             default:
    //             System.out.println("Không thể tìm thấy!");
    //             System.out.println("Vui lòng nhập lại");
    //                 break;
    //         }

    //     }while(isTypedTrue == true);
    //     addProductToOrder(x);
    // }

    public void addProductToOrder(Product x){
        orderedProducts.add(x);
        calculateTotalePrice();
    }
    @Override
    public String toString(){
        return "Order," + ID + "," + customerID + "," + totalPrice + "," + orderDate + "," + status;
    }
}
