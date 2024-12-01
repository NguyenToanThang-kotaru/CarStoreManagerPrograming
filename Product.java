import java.util.Scanner;

public abstract class Product {
    Scanner sc = new Scanner(System.in);
    protected String ID;
    protected String brand;
    protected String name;
    protected String date;
    protected long price;
    protected String color;
    protected int quantity;

    public Product() {
        ID = "";
        brand = "";
        name = "";  
        date = "";
        price = 0;
        color = "";
        quantity = 0;
    }

    
    public Product(String ID, String brand, String name, String date, long price, String color, int quantity) {
        this.ID = ID;
        this.brand = brand;
        this.name = name;
        this.date = date;
        this.price = price;
        this.color = color;
        this.quantity = quantity;
    }

    public Product(Product x)
    {
        this.ID = x.ID;
        this.brand = x.brand;
        this.name = x.name;
        this.date = x.date;
        this.price = x.price;
        this.color = x.color;
        this.quantity = x.quantity;
    }

      
    public void input() {
        System.out.print("Hãng xe: ");
        brand = sc.nextLine();
        System.out.print("Tên xe: ");
        name = sc.nextLine();
        System.out.print("Năm sản xuất: ");
        date = sc.nextLine();
        System.out.print("Giá: ");
        while (true) {
            try {
                price = Long.parseLong(sc.nextLine());
                if (price < 0) {
                    System.out.println("Giá không thể âm. Vui lòng nhập lại:");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Giá không hợp lệ. Vui lòng nhập lại:");
            }
        }
        System.out.print("Màu: ");
        color = sc.nextLine();
        System.out.print("Số lượng: ");
        quantity = Integer.parseInt(sc.nextLine());

    }
// ---------------------------------------------Get
    public String getID() {
        return ID;
    }

    public String getBrand() {
        return brand;
    }    
    public String getName() {
        return name;
    }    

    public String getDate() {
        return date;
    }

    public String getColor() {
        return color;
    }

    public long getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
// ---------------------------------------------Set
    public void setID(String ID) {
        this.ID=ID;
    }

    public void setBrand(String brand) {
        this.brand=brand;
    }   

    public void setName(String name) {
        this.name=name;
    }   

    public void setDate(String date) {
        this.date=date;
    } 

    public void setColor(String color) {
        this.color=color;
    }

    public void setPrice(long price) {
        this.price=price;
    }

    public void setQuantity(int quantity) {
        this.quantity=quantity;
    }
    
    public abstract void display();
    public abstract void edit();
    public abstract String toString();
}
