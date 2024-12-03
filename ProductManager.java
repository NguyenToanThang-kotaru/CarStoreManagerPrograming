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

    public void showProducts(ProductList productList) {
        int stt = 1;
        Product[] products = productList.getProducts();
        HeaderFooter.printHeader("Car");
        System.out.printf("%-6s", "STT");
        HeaderFooter.printProductHeader("car");
        for(Product product : products){
            if(product instanceof Car){
                System.out.printf("%-6s", stt + ".");
                product.display();
                stt++;
            }
        }
        HeaderFooter.printHeader("Motorbike");
        System.out.printf("%-5s", "STT");
        HeaderFooter.printProductHeader("motorbike");
        for(Product product : products){
            if(product instanceof Motorbike){
                System.out.printf("%-6s", stt + ".");
                product.display();
                stt++;
            }
        }

        System.out.println("exit. Thoát");
    }

    public ProductList buyProducts() {
        ProductList currentProducts = new ProductList();
        ProductList filteredProducts = new ProductList();
        boolean exit = false;
        do {
            System.out.println("1. Tất cả sản phẩm");
            System.out.println("2. Lọc sản phẩm theo hãng");
            System.out.println("3. Lọc sản phẩm theo tên");
            System.out.println("exit. Thoát");
            String luachon = "";
            luachon = sc.nextLine();
            switch (luachon) {
                case "1":
                    while (true) {
                        HeaderFooter.printHeader("Tất cả sản phẩm của cửa hàng");
                        showProducts(shopProducts);
                        HeaderFooter.printFooter();
                        System.out.println("Nhập số thứ tự sản phẩm cần mua: ");
                        String luachonSP = "";
                        luachonSP = sc.nextLine();
                        if (luachonSP.equalsIgnoreCase("exit")) {
                            break;
                        } else if (Validation.isInteger(luachon)) {
                            int index = Integer.parseInt(luachonSP);
                            if (index >= 1 && index <= shopProducts.getLength()) {
                                String xacnhan = "";
                                do {
                                    System.out.println("Y/N (Xác nhận mua hàng/Huỷ bỏ)");
                                    xacnhan = sc.nextLine();
                                } while (!xacnhan.equalsIgnoreCase("Y") && !xacnhan.equalsIgnoreCase("N"));
                                if (xacnhan.equalsIgnoreCase("Y")) {
                                    Product selectedProduct = shopProducts.getProducts()[index - 1];
                                    Product check = currentProducts.search(selectedProduct.getID());
                                    if(check == null){
                                        selectedProduct.setQuantity(1);
                                        currentProducts.add(selectedProduct);
                                        shopProducts.decreaseQuantityByOneOfProduct(selectedProduct.getID());
                                    } else{
                                        currentProducts.increaseQuantityByOneOfProduct(selectedProduct.getID());
                                        shopProducts.decreaseQuantityByOneOfProduct(selectedProduct.getID());
                                    }
                                }
                            }
                        }

                        System.out.println("Vui lòng nhập số trong khoảng hợp lệ hoặc \"exit\"");
                    }
                    break;
                case "2":
                    System.out.print("Nhập hãng muốn tìm: ");
                    String brand = sc.nextLine();
                    filteredProducts = shopProducts.searchByBrand(brand);
                    if(filteredProducts.getLength() == 0){
                        System.out.println("Không tìm thấy sản phẩm có hãng " + brand);
                        break;
                    }
                    while(true){
                        HeaderFooter.printHeader("Các sản phẩm có hãng là " + brand);
                        showProducts(filteredProducts);
                        HeaderFooter.printFooter();
                        String luachonSP = "";
                        luachonSP = sc.nextLine();
                        if(luachonSP.equalsIgnoreCase("exit")){
                            break;
                        } else
                        if(Validation.isInteger(luachon)){
                            int index = Integer.parseInt(luachonSP);
                            if(index >= 1 && index <= filteredProducts.getLength()){
                                String xacnhan = "";
                                do{
                                    System.out.println("Y/N (Xác nhận/Huỷ bỏ)");
                                    xacnhan = sc.nextLine();
                                } while(!xacnhan.equalsIgnoreCase("Y") && !xacnhan.equalsIgnoreCase("N"));
                                if(xacnhan.equalsIgnoreCase("Y")){
                                    Product selectedProduct = filteredProducts.getProducts()[index - 1];
                                    Product check = currentProducts.search(selectedProduct.getID());
                                    if(check == null){
                                        selectedProduct.setQuantity(1);
                                        currentProducts.add(selectedProduct);
                                    } else{
                                        Product[] products = currentProducts.getProducts();
                                        for(Product product : products){
                                            if(product.getID().equals(selectedProduct.getID())){
                                                product.setQuantity(product.getQuantity() + 1);
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        System.out.println("Vui lòng nhập số trong khoảng hợp lệ hoặc \"exit\"");
                    }
                    break;
                case "3":
                    System.out.print("Nhập tên sản phẩm muốn tìm: ");
                    String name = sc.nextLine();
                    filteredProducts = shopProducts.searchByName(name);
                    if (filteredProducts.getLength() == 0) {
                        System.out.println("Không tìm thấy sản phẩm có tên chứa " + name);
                        break;
                    }
                    while (true) {
                        HeaderFooter.printHeader("Các sản phẩm có tên chứa " + name);
                        showProducts(filteredProducts);
                        HeaderFooter.printFooter();
                        String luachonSP = "";
                        boolean isValid = false;
                        luachonSP = sc.nextLine();
                        if (luachonSP.equalsIgnoreCase("exit")) {
                            isValid = true;
                            break;
                        } else if (Validation.isInteger(luachon)) {
                            int index = Integer.parseInt(luachonSP);
                            if (index >= 1 && index <= filteredProducts.getLength()) {
                                isValid = true;
                                String xacnhan = "";
                                do {
                                    System.out.println("Y/N (Xác nhận/Huỷ bỏ)");
                                    xacnhan = sc.nextLine();
                                } while (!xacnhan.equalsIgnoreCase("Y") && !xacnhan.equalsIgnoreCase("N"));
                                if (xacnhan.equalsIgnoreCase("Y")) {
                                    Product selectedProduct = filteredProducts.getProducts()[index - 1];
                                    Product check = currentProducts.search(selectedProduct.getID());
                                    if(check == null){
                                        selectedProduct.setQuantity(1);
                                        currentProducts.add(selectedProduct);
                                    } else{
                                        Product[] products = currentProducts.getProducts();
                                        for(Product product : products){
                                            if(product.getID().equals(selectedProduct.getID())){
                                                product.setQuantity(product.getQuantity() + 1);
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        if (!isValid) {
                            System.out.println("Vui lòng nhập số trong khoảng hợp lệ hoặc \"exit\"");
                        }
                    }

                    break;
                case "exit":
                    exit = true;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, nếu muốn thoát nhập \"exit\"");
                    break;
            }
        } while (!exit);

        return currentProducts;
    }

    public void menu() {
        boolean exit = false;
        do {
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
                    if (product != null) {
                        if(product instanceof Car){
                            HeaderFooter.printProductHeader("car");
                        } else
                        if(product instanceof Motorbike){
                            HeaderFooter.printProductHeader("motorbike");;
                        }
                        product.display();
                    } else {
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
        } while (!exit);
    }

    public void readFromFile() {
        try {
            BufferedReader input = new BufferedReader(new FileReader("./database/products.txt"));
            String line = input.readLine();
            while (line != null) {
                String[] arr = line.split(",");
                if (arr[0].equalsIgnoreCase("Car")) {
                    this.shopProducts.add(new Car(arr[1], arr[2], arr[3], arr[4], Long.parseLong(arr[5]),
                            arr[6], Integer.parseInt(arr[7]), Byte.parseByte(arr[8])));
                    Car.increaseCurrentIDNumer();
                } else if (arr[0].equalsIgnoreCase("Motorbike")) {
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
            for (Product product : products) {
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