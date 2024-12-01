public class Motorbike extends Product{
    private short CC;
    public Motorbike(){
        super();
        CC = 100;
    }    

    public Motorbike(String ID, String brand, String name, String date, long price, String color, int quantity,short CC){
        super(ID, brand, name, date, price, color, quantity);
        this.CC=CC;
    }

    public Motorbike(Motorbike x){
        // UPCASTING
        super((Product)x);
        this.CC = x.CC;
    }
    public void input() {
        super.input();
        System.out.print("Phân khối: ");
        CC = Byte.parseByte(sc.nextLine());
    }

    public void display() {
        super.display();
        System.out.println("Phân khối: " + CC);
    }

    public short getCC(){
        return CC;
    }

    public void setCC(short CC){
        this.CC = CC;
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
            System.out.println("8: Sửa số phân khối");


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
                    System.out.print("Nhập số phân khối mới: ");
                    short newCC = Short.parseShort(sc.nextLine());
                    this.setCC(newCC);
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
        return "Motorbike," + ID + "," + brand + "," + name + "," + date + "," + price + "," + color + "," + quantity + "," + CC + ",";
    }
}
