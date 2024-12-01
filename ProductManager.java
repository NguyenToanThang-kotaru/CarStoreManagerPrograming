import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.util.Scanner;

public class ProductManager {
    Scanner sc = new Scanner(System.in);
    private ProductList shopProducts;

    public ProductManager() {
        shopProducts = new ProductList();
        this.readFromFile();
    }



    public void menu() {
        boolean exit = false;
        do{
            HeaderFooter.printHeader("Menu");
            System.out.println("1: Xem sản phẩm");
            System.out.println("2: Thêm sản phẩm");
            System.out.println("3: Sửa thông tin sản phẩm");
            System.out.println("4: Xoá sản phẩm");
            System.out.println("5: Tìm sản phẩm");
            System.out.println("exit: Thoát");
            String luachon = "";
            System.out.print("Nhập lựa chọn: ");
            luachon = sc.nextLine();
            switch (luachon) {
                case "1":
                    HeaderFooter.printHeader("Thông tin của các sản phẩm");
                    shopProducts.display();
                    HeaderFooter.printFooter();
                    break;
                case "2":
                    HeaderFooter.printHeader("Thêm sản phẩm");
                    shopProducts.add();
                    HeaderFooter.printFooter();
                    break;
                case "3":
                    HeaderFooter.printHeader("Sửa sản phẩm");
                    shopProducts.edit();
                    HeaderFooter.printFooter();
                    break;
                case "4":
                    HeaderFooter.printHeader("Xoá sản phẩm");
                    shopProducts.delete();
                    HeaderFooter.printFooter();
                    break;
                case "5":
                    HeaderFooter.printHeader("Tìm kiếm sản phẩm");
                    Product product = shopProducts.search();
                    if(product != null){
                        product.display();
                    } else{
                        System.out.println("Không tìm thấy sản phẩm!!!");
                    }
                    HeaderFooter.printFooter();
                    break;
                case "exit":
                    exit = true;
                    this.writeToFile();
                    break;
                default:
                    System.out.println("!------Lỗi------!");
                    System.out.println("Nếu muốn thoát vui lòng nhập \"exit\"");
                    break;
            }
        } while(!exit);
    }
    




    public void readFromFile() {
        try {
            BufferedReader input = new BufferedReader(new FileReader("./database/products.txt"));
            String line = input.readLine();
            while (line != null) {
                String[] arr = line.split(",");
                if (arr[0].equals("Car")) {
                    this.shopProducts.add(new Car(arr[1], arr[2], arr[3], arr[4], Long.parseLong(arr[5]),
                        arr[6], Integer.parseInt(arr[7]), Byte.parseByte(arr[8])));  
                        Car.increaseCurrentIDNumer();
                } else
                if(arr[0].equals("Motorbike")) {
                    this.shopProducts.add(new Motorbike(arr[1], arr[2], arr[3], arr[4], Long.parseLong(arr[5]),
                    arr[6], Integer.parseInt(arr[7]), Short.parseShort(arr[8])));
                    Motorbike.increaseCurrentIDNumer();
                }
                
                line = input.readLine();
            }

            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void writeToFile() {
        Product[] products = shopProducts.getProducts();
        try {
            FileWriter fw = new FileWriter("./database/products.txt");
            for (Product product :products) {
                fw.write(product.toString());
                fw.write("\r\n");
            }
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        ProductManager a = new ProductManager();
        a.menu();
    }
}