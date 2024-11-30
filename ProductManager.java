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




    




    public void readFromFile() {
        try {
            BufferedReader input = new BufferedReader(new FileReader("./database/products.txt"));
            String line = input.readLine();
            while (line != null) {
                String[] arr = line.split(",");
                if (arr[0]=="Car") {
                    this.shopProducts.add(new Car(arr[1], arr[2], arr[3], arr[4], Long.parseLong(arr[5]),
                        arr[6], Integer.parseInt(arr[7]), Byte.parseByte(arr[8])));  
                    line = input.readLine();
                }
                else
                {
                    this.shopProducts.add(new Motorbike(arr[1], arr[2], arr[3], arr[4], Long.parseLong(arr[5]),
                        arr[6], Integer.parseInt(arr[7]), Short.parseShort(arr[8])));  
                    line = input.readLine();
                }

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
}