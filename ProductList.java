import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProductList {
    Scanner sc = new Scanner(System.in);
    Product[] products;
    int lenght;

    public ProductList() {
        lenght = 0;
        products = new Product[0];
    }

    public ProductList(int lenght, Product[] products) {
        this.lenght = lenght;
        this.products = products;
    }

    public int getLenght() {
        return lenght;
    }

    public void input() {
        System.out.print("Nhập số lượng sản phẩm: ");
        lenght = Integer.parseInt(sc.nextLine());
        products = new Product[lenght];

        for (int i = 0; i < lenght; i++) {
            boolean check = false;
            do {
                System.out.println("1: Car");
                System.out.println("2: Motorbike");
                String loaixe;
                loaixe = sc.nextLine();
                switch (loaixe) {
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
            } while (!check);
            products[i].input();
        }
    }

    public void display() {
        for (int i = 0; i < lenght; i++) {
            products[i].display();
        }
    }

    public void add() {
        products = Arrays.copyOf(products, lenght + 1);
        boolean check = false;
        do {
            System.out.println("Xe bạn muốn chọn để thêm vào: ");
            System.out.println("1: Car");
            System.out.println("2: Motorbike");
            String loaixe;
            loaixe = sc.nextLine();
            switch (loaixe) {
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
        } while (!check);
        products[lenght].input();
        lenght++;
    }

    public void add(Product x) {
        products = Arrays.copyOf(products, lenght + 1);
        products[lenght] = new Product(x);
        lenght++;
    }

    public void delete() {
        String id;
        System.out.print("Nhập ID sản phẩm cần xóa: ");
        id = sc.nextLine();
        delete(id);
    }

    public void delete(String ma) {
        for (int i = 0; i < lenght; i++) {
            if (products[i].getID().equals(ma)) {
                for (int j = i; j < lenght - 1; j++) {
                    products[j] = products[j + 1];
                }
                products = Arrays.copyOf(products, lenght - 1);
                lenght--;
                break;
            }
        }
    }

    // public void edit() {
    // String id;
    // System.out.print("Nhập ID sản phẩm cần sửa: ");
    // id = sc.nextLine();
    // search()
    // edit(id);
    // }

    public void edit(String id) {
        Product product = search(id);
        if(product!=null)
        {
            boolean exit = false;
            do {
                System.out.println("---Thông tin sản phẩm hiện tại---");
                product.display();
                System.out.println("1: Sửa ID");
                System.out.println("2: Sửa hãng");
                System.out.println("3: Sửa tên");
                System.out.println("4: Sửa năm sản xuất");
                System.out.println("5: Sửa giá");
                System.out.println("exit: Thoát");
                String luachon = "";
                System.out.print("Nhập lựa chọn: ");
                luachon = sc.nextLine();
                switch (luachon) {
                    case "1":
                        System.out.print("Nhập ID mới: ");
                        String newID = sc.nextLine();
                        product.setID(newID);
                        break;
                    case "2":
                        System.out.print("Nhập hãng mới: ");
                        String newBrand = sc.nextLine();
                        product.setBrand(newBrand);
                        break;
                    case "3":
                        System.out.print("Nhập tên mới: ");
                        String newName = sc.nextLine();
                        product.setName(newName);
                        break;
                    case "4":
                        System.out.print("Nhập năm sản xuất mới: ");
                        String newDate = sc.nextLine();
                        product.setDate(newDate);
                        break;
                    case "5":
                        System.out.print("Nhập giá mới: ");
                        Long newPrice = sc.nextLong();
                        product.setPrice(newPrice);;
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

    }

    public ProductList searchbyname(String key) {
        ProductList productsNew = new ProductList();
        for (int i = 0; i < lenght; i++) {
            if (products[i].getName().contains(key))
                productsNew.add(products[i]);
        }
        return productsNew;
    }

    public Product search(){
        System.out.println("Nhập ID bạn cần tìm kiếm: ");
        String ID = sc.nextLine();
        return search(ID);
    }

    public Product search(String Id) {
        for (int i = 0; i < lenght; i++) {
            if (Id.equals(products[i].getID())) {
                return products[i];
            }
        }
        return null;
    }

    // public static void main(String[] args) {
    // ProductList a = new ProductList();
    // a.add();
    // a.add();
    // a.display();
    // }

}
