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
        Product[] products = productList.getProducts();
        int productsLength = productList.getlength();
        for (int i = 0; i < productsLength; i++) {
            System.out.println((i + 1) + ".");
            System.out.println("Tên: " + products[i].getName() + "   " + "Hãng: " + products[i].getBrand());
            System.out.println("Màu: " + products[i].getColor() + "   " + "Giá: " + products[i].getPrice());
            System.out.print("\n");
        }

        System.out.println("exit. Thoát");
    }

    public ProductList buyProducts() {
        ProductList currentProducts = new ProductList();
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
                        showProducts(shopProducts);
                        String luachonSP = "";
                        luachonSP = sc.nextLine();
                        if (luachonSP.equalsIgnoreCase("exit")) {
                            break;
                        } else if (Validation.isInteger(luachon)) {
                            int index = Integer.parseInt(luachonSP);
                            if (index >= 1 && index <= shopProducts.getlength()) {
                                String xacnhan = "";
                                do {
                                    System.out.println("Y/N (Xác nhận/Huỷ bỏ)");
                                    xacnhan = sc.nextLine();
                                } while (!xacnhan.equalsIgnoreCase("Y") && !xacnhan.equalsIgnoreCase("N"));
                                if (xacnhan.equalsIgnoreCase("Y")) {
                                    currentProducts.add(shopProducts.getProducts()[index - 1]);
                                }
                            }
                        }

                        System.out.println("Vui lòng nhập số trong khoảng hợp lệ hoặc \"exit\"");
                    }
                    break;
                case "2":
                    System.out.print("Nhập hãng muốn tìm: ");
                    String brand = sc.nextLine();
                    // ProductList filteredProducts = shopProducts.searchByBrand(brand);
                    // if(filteredProducts.getlength() == 0){
                    // System.out.println("Không tìm thấy sản phẩm có hãng " + brand);
                    // break;
                    // }
                    // while(true){
                    // showProducts(filteredProducts);
                    // String luachonSP = "";
                    // luachonSP = sc.nextLine();
                    // if(luachonSP.equalsIgnoreCase("exit")){
                    // break;
                    // } else
                    // if(Validation.isInteger(luachon)){
                    // int index = Integer.parseInt(luachonSP);
                    // if(index >= 1 && index <= filteredProducts.getlength()){
                    // String xacnhan = "";
                    // do{
                    // System.out.println("Y/N (Xác nhận/Huỷ bỏ)");
                    // xacnhan = sc.nextLine();
                    // } while(!xacnhan.equalsIgnoreCase("Y") && !xacnhan.equalsIgnoreCase("N"));
                    // if(xacnhan.equalsIgnoreCase("Y")){
                    // currentProducts.add(filteredProducts.getProducts()[index - 1]);
                    // }
                    // }
                    // }

                    // System.out.println("Vui lòng nhập số trong khoảng hợp lệ hoặc \"exit\"");
                    // }
                    break;
                case "3":
                    System.out.print("Nhập tên sản phẩm muốn tìm: ");
                    String name = sc.nextLine();
                    ProductList filteredProducts = shopProducts.searchByName(name);
                    if (filteredProducts.getlength() == 0) {
                        System.out.println("Không tìm thấy sản phẩm có tên chứa " + name);
                        break;
                    }
                    while (true) {
                        showProducts(filteredProducts);
                        String luachonSP = "";
                        boolean isValid = false;
                        luachonSP = sc.nextLine();
                        if (luachonSP.equalsIgnoreCase("exit")) {
                            isValid = true;
                            break;
                        } else if (Validation.isInteger(luachon)) {
                            int index = Integer.parseInt(luachonSP);
                            if (index >= 1 && index <= filteredProducts.getlength()) {
                                isValid = true;
                                String xacnhan = "";
                                do {
                                    System.out.println("Y/N (Xác nhận/Huỷ bỏ)");
                                    xacnhan = sc.nextLine();
                                } while (!xacnhan.equalsIgnoreCase("Y") && !xacnhan.equalsIgnoreCase("N"));
                                if (xacnhan.equalsIgnoreCase("Y")) {
                                    currentProducts.add(filteredProducts.getProducts()[index - 1]);
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
                        System.out.printf("%-10s | %-15s | %-13s | %-13s | %-17s | %-10s | %-10s | %-10s%n",
                                "ID", "Hãng xe", "Tên xe", "Năm sản xuất", "Giá", "Màu", "Số lượng", "Số chỗ ngồi");
                        System.out.println(
                                "------------------------------------------------------------------------------------------------------------------------");
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