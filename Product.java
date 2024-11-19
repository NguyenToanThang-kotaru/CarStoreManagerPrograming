package CarStoreManagerPrograming;
import java.util.ArrayList;
import java.util.Scanner;

public class Product {
    Scanner sc = new Scanner(System.in);
    private String Name;
    private String Date;
    private int price;
    private String id;
    private String hangxe;
    private static ArrayList<String> checkid = new ArrayList<>();

    public Product() {
        Name = "product";
        price = 0;
        id = "0";
        hangxe = "Honda";
        Date = "2000";
    }

    public Product(String id, String hangxe, String Name, String Date, int price) {
        this.id = id;
        this.hangxe = hangxe;
        this.Name = Name;
        this.price = price;
        this.Date = Date;
    }

    String getID() {
        return id;
    }

    public void outputProduct() {
        System.out.println("ID: " + id);
        System.out.println("Hãng xe: " + hangxe);
        System.out.println("Tên xe: " + Name);
        System.out.println("Năm sản xuất: " + Date);
        System.out.println("Giá: " + price);
    }

    public void inputProduct() {
        while (true) {
            System.out.print("ID: ");
            id = sc.nextLine();
            if (checkid.contains(id)) {
                System.out.println("Trùng ID! Vui lòng nhập lại.");
            } else {
                checkid.add(id);
                break;
            }
        }

        System.out.print("Hãng xe: ");
        hangxe = sc.nextLine();
        System.out.print("Tên xe: ");
        Name = sc.nextLine();
        System.out.print("Năm sản xuất: ");
        Date = sc.nextLine();
        System.out.print("Giá: ");
        
        while (true) {
            try {
                price = Integer.parseInt(sc.nextLine());
                if (price < 0) {
                    System.out.println("Giá không thể âm. Vui lòng nhập lại:");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Giá không hợp lệ. Vui lòng nhập lại:");
            }
        }
    }
}

class Car extends Product {
    private String socho;

    public Car() {
        super();
        socho = "4 chỗ";
    }

    public Car(String id, String hangxe, String Name, String Date, int price, String socho) {
        super(id, hangxe, Name, Date, price);
        this.socho = socho;
    }

    public String getIDCar() {
        return super.getID();
    }

    public void inputCar() {
        super.inputProduct();
        System.out.print("Số chỗ: ");
        socho = sc.nextLine();
    }

    public void outputCar() {
        super.outputProduct();
        System.out.println("Số chỗ: " + socho);
    }
}