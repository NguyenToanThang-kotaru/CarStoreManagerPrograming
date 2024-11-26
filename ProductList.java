import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ProductList {
    Scanner sc = new Scanner(System.in);
    Product[] products;
    int lenght;
    public ProductList(){
        lenght = 0;
        products = new Product[0];
    }
    public ProductList(int lenght,Product[] products){
        this.lenght = lenght;
        this.products = products;
    }
    public int getLenght(){
        return lenght;
    }
    public void input(){
        System.out.print("Nhập số lượng sản phẩm: ");
        lenght = Integer.parseInt(sc.nextLine());
        products = new Product[lenght];

        for(int i=0;i<lenght;i++)
        {
            boolean check = false;
            do{
                System.out.println("1: Car");
                System.out.println("2: Motorbike");
                String loaixe;
                loaixe = sc.nextLine();
                switch(loaixe){
                    case "1":
                        products[i] = new Car();
                        check = true;
                        break;
                    case "2":
                        products[i] = new Motorbike();
                        check = true;
                        break;
                    default:
                        break;
                }
            } while(!check);
            products[i].input();
        }
    }
    public void display(){
        for(int i=0;i<lenght;i++)
        {
            products[i].display();
        }
    }

    public void add(){
        products = Arrays.copyOf(products, lenght+1);
        boolean check = false;
            do{
                System.out.println("Xe bạn muốn chọn để thêm vào: ");
                System.out.println("1: Car");
                System.out.println("2: Motorbike");
                String loaixe;
                loaixe = sc.nextLine();
                switch(loaixe){
                    case "1":
                        products[lenght] = new Car();
                        check = true;
                        break;
                    case "2":
                        products[lenght] = new Motorbike();
                        check = true;
                        break;
                    default:
                        break;
                }
            } while(!check);
            products[lenght].input();
            lenght++;
    }

    public void add(Product x){
        products = Arrays.copyOf(products, lenght+1);
        products[lenght] = new Product(x);
        lenght++;
    }

    public void delete(){
        String id;
        System.out.print("Nhập ID sản phẩm cần xóa: ");
        id = sc.nextLine();
        delete(id);
    }

    public void delete (String ma) {
        for(int i = 0; i < lenght; i++)
        {
            if(products[i].getID().equals(ma))
            {
                for(int j = i; j < lenght-1; j++)
                {
                    products[j] = products[j+1];
                }
                products = Arrays.copyOf(products, lenght-1);
                lenght--;
                break;
            }
        }
    }        

    // public void edit() {
    //     String id;
    //     System.out.print("Nhập ID sản phẩm cần sửa: ");
    //     id = sc.nextLine();
    //     edit(id);
    // }

    // public void edit(String ma) {
    //     for (int i = 0; i < lenght; i++) {
    //         if (products[i].getID().equals(ma)) {
    //             System.out.println("Sản phẩm hiện tại:");
    //             products[i].display(); // Hiển thị thông tin sản phẩm hiện tại

    //             // Nhập thông tin mới
    //             System.out.print("Nhập tên sản phẩm mới: ");
    //             String newName = sc.nextLine();
    //             System.out.print("Nhập giá sản phẩm mới: ");
    //             long newPrice = sc.nextLong();
    //             sc.nextLine(); // Đọc dòng còn lại

    //             // Cập nhật thông tin sản phẩm
    //             products[i].setName(newName);
    //             products[i].setPrice(newPrice);
    //             System.out.println("Thông tin sản phẩm đã được cập nhật.");
    //             break;
    //         }
    //     }
    // }
        
   
    // public static void main(String[] args) {
    //     ProductList a = new ProductList();
    //     a.add();
    //     a.add();
    //     a.display();
    // }


}
