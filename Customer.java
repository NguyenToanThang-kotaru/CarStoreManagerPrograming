import java.util.Scanner;

public class Customer extends Person {    
    Scanner sc = new Scanner(System.in);
    private String ID;
    private static int currentIDNumber = -1;
    private OrderList orderHistory;
    public Customer() {
        super();
        ID = "";
        orderHistory = new OrderList();
    }

    public Customer(String ID, String name, String address, String phone, short age) {
        super(name, address, phone, age);
        this.ID = ID;
    }

    public Customer(Customer customer) {
        super((Person)customer);
        this.ID = customer.ID;
    }

    // Tạo ra ID mới, format: flag 0 (đệm thêm '0' cho đủ chiều rộng), 
    private static String generateNextID(){
        return String.format("KH-%05d", ++currentIDNumber);
    }

    public static String getNewestID(){
        return String.format("KH-%05d", currentIDNumber);
    }

    public static void increaseCurrentIDNumer(){
        Customer.currentIDNumber++;
    }
    @Override
    public void input() {
        super.input();
        ID = generateNextID();
    }

    @Override
    public void display() {
        System.out.println("ID khách hàng: " + ID);
        super.display();
    }

    public void displayOrderHistory() {
        
    }

    public String getID() {
        return ID;
    }
    
    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String toString(){
        return "Customer," + ID + "," + name + "," + address + "," + phone + "," + age;
    }
}
