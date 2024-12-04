import java.util.Scanner;

public class Customer extends Person {    
    Scanner sc = new Scanner(System.in);
    private String ID;
    private static int currentIDNumber = -1;
    public Customer() {
        super();
        ID = "";
    }

    public Customer(String ID, String name, String address, String phone, short age) {
        super(name, address, phone, age);
        this.ID = ID;
    }

    public Customer(Customer customer) {
        super((Person)customer);
        this.ID = customer.ID;
    }

    // Tạo ra ID mới, format:
    // flag 0 (đệm thêm '0' cho đủ chiều rộng),
    // width 5 (chiều rộng tối thiểu), nếu ko đủ, kết hợp với flag 0 ở trên đệm thêm '0'
    // conversion d, thể hiện số nguyên
    private static String generateNextID(){
        return String.format("KH-%05d", ++currentIDNumber);
    }

    // Lấy ra ID của khách hàng mới nhất
    public static String getLatestID (){
        return String.format("KH-%05d", currentIDNumber);
    }

    // Tăng số ID, sử dụng khi đọc file, khi khởi động chương trình
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
        System.out.printf("%-9s | %-31s | %-51s | %-10s | %-5s%n", ID, name, address, phone, age);
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
