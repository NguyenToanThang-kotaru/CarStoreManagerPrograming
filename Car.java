import java.text.NumberFormat;

public class Car extends Product {
    private byte seat;
    private static int currentIDNumber = -1;

    public Car() {
        super();
        seat = 4;
    }

    public Car(String ID, String brand, String name, String date, long price, String color, int quantity, byte seat) {
        super(ID, brand, name, date, price, color, quantity);
        this.seat = seat;
    }

    public Car(Car x) {
        // UPCASTING
        super((Product) x);
        this.seat = x.seat;
    }

    // Tạo ra ID mới, format:
    // flag 0 (đệm thêm '0' cho đủ chiều rộng),
    // width 5 (chiều rộng tối thiểu), nếu ko đủ, kết hợp với flag 0 ở trên đệm thêm
    // '0'
    // conversion d, thể hiện số nguyên
    private static String generateNextID() {
        return String.format("C-%05d", ++currentIDNumber);
    }
    // Lấy ra ID của khách hàng mới nhất

    public static String getNewestID() {
        return String.format("C-%05d", currentIDNumber);

    }

    // Tăng số ID, sử dụng khi đọc file, khi khởi động chương trình
    public static void increaseCurrentIDNumer() {
        Car.currentIDNumber++;
    }

    public void input() {
        super.input();
        System.out.print("Số chỗ: ");
        seat = Byte.parseByte(sc.nextLine());
        ID = generateNextID();

    }

    public void display() {
        NumberFormat numberFormat = NumberFormat.getInstance(); // Tạo đối tượng NumberFormat
        numberFormat.setGroupingUsed(true); // Bật tính năng nhóm số
    
        // Hiển thị thông tin sản phẩm với giá được định dạng
        System.out.printf("%-10s | %-15s | %-13s | %-13s | %-17s | %-10s | %-10s | %-10s%n",
                          ID, brand, name, date, numberFormat.format(price), color, quantity, seat);
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
    }

    public byte getSeat() {
        return seat;
    }

    public void setSeat(byte seat) {
        this.seat = seat;
    }

    public void edit() {
        boolean exit = false;
        do {
            System.out.println("---Thông tin sản phẩm hiện tại---");
            System.out.printf("%-10s | %-15s | %-13s | %-13s | %-17s | %-10s | %-10s | %-10s%n",
                    "ID", "Hãng xe", "Tên xe", "Năm sản xuất", "Giá", "Màu", "Số lượng", "Số chỗ ngồi");
            System.out.println(
                    "------------------------------------------------------------------------------------------------------------------------");
            this.display();
            System.out.println("1: Sửa hãng");
            System.out.println("2: Sửa tên");
            System.out.println("3: Sửa năm sản xuất");
            System.out.println("4: Sửa giá");
            System.out.println("5: Sửa màu");
            System.out.println("6: Sửa số lượng");
            System.out.println("7: Sửa số phân khối");

            System.out.println("exit: Thoát");
            String luachon = "";
            System.out.print("Nhập lựa chọn: ");
            luachon = sc.nextLine();
            switch (luachon) {
                case "1":
                    System.out.print("Nhập hãng mới: ");
                    String newBrand = sc.nextLine();
                    this.setBrand(newBrand);
                    break;
                case "2":
                    System.out.print("Nhập tên mới: ");
                    String newName = sc.nextLine();
                    this.setName(newName);
                    break;
                case "3":
                    System.out.print("Nhập năm sản xuất mới: ");
                    String newDate = sc.nextLine();
                    this.setDate(newDate);
                    break;
                case "4":
                    System.out.print("Nhập giá mới: ");
                    Long newPrice = Long.parseLong(sc.nextLine());
                    this.setPrice(newPrice);
                    break;
                case "5":
                    System.out.print("Nhập màu mới: ");
                    String newColor = sc.nextLine();
                    this.setColor(newColor);
                    break;
                case "6":
                    System.out.print("Nhập số lượng mới: ");
                    int newQuantity = Integer.parseInt(sc.nextLine());
                    this.setQuantity(newQuantity);
                    break;
                case "7":
                    System.out.print("Nhập số chỗ ngồi mới: ");
                    byte newSeat = Byte.parseByte(sc.nextLine());
                    this.setSeat(newSeat);
                    break;
                case "exit":
                    exit = true;
                    break;
                default:
                    System.out.println("!------Lỗi------!");
                    System.out.println("Nếu muốn thoát vui lòng nhập \"exit\"");
                    break;
            }
        } while (!exit);
    }

    @Override
    public String toString() {
        return "Car," + this.ID + "," + this.brand + "," + this.name + "," + this.date + "," + this.price + ","
                + this.color + "," + this.quantity + "," + this.seat;
    }
}