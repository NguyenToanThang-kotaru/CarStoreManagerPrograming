public class Car extends Product {
    private byte seat;

    public Car() {
        super();
        seat = 4;
    }

    public Car(String ID, String brand, String name, String date, long price, String color, int quantity, byte seat) {
        super(ID, brand, name, date, price, color, quantity);
        this.seat = seat;
    }

    public Car(Car x){
        // UPCASTING
        super((Product)x);
        this.seat = x.seat;
    }
    public void input() {
        super.input();
        System.out.print("Số chỗ: ");
        seat = Byte.parseByte(sc.nextLine());
    }

    public void display() {
        super.display();
        System.out.println("Số chỗ: " + seat);
    }
    
    public byte getSeat(){
        return seat;
    }
    
    public void setSeat(byte seat){
        this.seat=seat;
    }
    public void edit() {
        boolean exit = false;
        do {
            System.out.println("---Thông tin sản phẩm hiện tại---");
            this.display();
            System.out.println("1: Sửa ID");
            System.out.println("2: Sửa hãng");
            System.out.println("3: Sửa tên");
            System.out.println("4: Sửa năm sản xuất");
            System.out.println("5: Sửa giá");
            System.out.println("6: Sửa màu");
            System.out.println("7: Sửa số lượng");
            System.out.println("8: Sửa số chỗ");


            System.out.println("exit: Thoát");
            String luachon = "";
            System.out.print("Nhập lựa chọn: ");
            luachon = sc.nextLine();
            switch (luachon) {
                case "1":
                    System.out.print("Nhập ID mới: ");
                    String newID = sc.nextLine();
                    this.setID(newID);
                    break;
                case "2":
                    System.out.print("Nhập hãng mới: ");
                    String newBrand = sc.nextLine();
                    this.setBrand(newBrand);
                    break;
                case "3":
                    System.out.print("Nhập tên mới: ");
                    String newName = sc.nextLine();
                    this.setName(newName);
                    break;
                case "4":
                    System.out.print("Nhập năm sản xuất mới: ");
                    String newDate = sc.nextLine();
                    this.setDate(newDate);
                    break;
                case "5":
                    System.out.print("Nhập giá mới: ");
                    Long newPrice = Long.parseLong(sc.nextLine());
                    this.setPrice(newPrice);
                    break;
                case "6":
                    System.out.print("Nhập màu mới: ");
                    String newColor = sc.nextLine();
                    this.setColor(newColor);
                    break;
                case "7":
                    System.out.print("Nhập số lượng mới: ");
                    int newQuantity = Integer.parseInt(sc.nextLine());
                    this.setQuantity(newQuantity);
                    break;
                case "8":
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
        return "Car," + getID() + "," + getBrand() + "," + getName() + "," + getDate()  + "," + getPrice() + "," + getColor() + "," + getQuantity()+"," + getSeat();
    }
}