import java.text.NumberFormat;
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
    // Tạo ra ID đơn hàng mới
    private static String generateNextID(){
        return String.format("OD-%05d", ++currentIDNumber);
    }

    // Lấy ID của đơn hàng mới nhất
    public static String getLatestID (){
        return String.format("OD-%05d", currentIDNumber);
    }

    // Tăng số ID, sử dụng khi đọc file, khi khởi động chương trình
    public static void increaseCurrentIDNumer(){
        Order.currentIDNumber++;
    }
    public void input(){
        ID = generateNextID();
        System.out.print("Nhập mã khách hàng: ");
        customerID = r.nextLine();
        System.out.print("Nhập ngày đặt hàng (Ngày/Tháng/Năm): ");
        orderDate = r.nextLine();
        while(!Validation.isDate(orderDate)){
            System.out.print("Nhập lại ngày đặt hàng (Ngày/Tháng/Năm): ");
            orderDate = r.nextLine();
        }
    }
    public void display(){
        NumberFormat numberFormat = NumberFormat.getInstance(); // Tạo đối tượng NumberFormat
        numberFormat.setGroupingUsed(true); // Bật tính năng nhóm số
        // Hiển thị thông tin sản phẩm với giá được định dạng
        System.out.printf("%-12s | %-13s | %-13s | %-13s | %-10s%n",
        ID, customerID, numberFormat.format(getTotalPrice()), orderDate, status);
        System.out.println("---------------------------------------------------------------------------------------------------");
        HeaderFooter.printHeader("Danh sách sản phẩm đã đặt:");
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
    public Product[] getOrderedProducts(){
        return orderedProducts.getProducts();
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
    public long calculateTotalePrice(){
        long sum = 0;
        for(int j = 0; j < orderedProducts.getLength(); j++){
            Product product = orderedProducts.getProducts()[j];
            sum += (product.getPrice() * product.getQuantity());
        }

        return sum;
    }
    public long getTotalPrice(){
        totalPrice = calculateTotalePrice();
        return totalPrice;
    }

    public void addProductToOrder(Product x){
        orderedProducts.add(x);
    }
    public void addProductListToOrder(ProductList x){
        for(int i = 0; i < x.getLength(); i++){
            this.addProductToOrder(x.getProducts()[i]);
        }
    }
    @Override
    public String toString(){
        return "Order," + ID + "," + customerID + "," + totalPrice + "," + orderDate + "," + status;
    }
}
