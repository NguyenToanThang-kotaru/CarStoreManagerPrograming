import java.util.Arrays;
import java.util.Scanner;

public class ProductList implements IDisplayable, IThemXoaSua{
    Scanner sc = new Scanner(System.in);
    private Product[] products;
    private int length;

    public ProductList() {
        length = 0;
        products = new Product[0];
    }

    public ProductList(int length, Product[] products) {
        this.length = length;
        this.products = products;
    }

    public int getLength() {
        return length;
    }

    public void input() {
        System.out.print("Nhập số lượng sản phẩm: ");
        length = Integer.parseInt(sc.nextLine());
        products = new Product[length];

        for (int i = 0; i < length; i++) {
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
        int cntCars = 0;
        int cntMotorbikes = 0;
        for(int i = 0; i < length; i++){
            if(products[i] instanceof Car){
                cntCars++;
            }
        }

        for(int i = 0; i < length; i++){
            if(products[i] instanceof Motorbike){
                cntMotorbikes++;
            }
        }

        if(cntCars > 0){
            HeaderFooter.printHeader("Car");
            HeaderFooter.printProductHeader("car");
            for (int i = 0; i < length; i++) {
                if(products[i] instanceof Car){
                    products[i].display();
                }
            }
            HeaderFooter.printFooter();
        }

        if(cntMotorbikes > 0){
            HeaderFooter.printHeader("Motorbike");
            HeaderFooter.printProductHeader("motorbike");
            for (int i = 0; i < length; i++) {
                if(products[i] instanceof Motorbike){
                    products[i].display();
                }
            }
            HeaderFooter.printFooter();
        }
    }

    public void add() {
        products = Arrays.copyOf(products, length + 1);
        boolean check = false;
        do {
            System.out.println("Xe bạn muốn chọn để thêm vào: ");
            System.out.println("1: Car");
            System.out.println("2: Motorbike");
            String loaixe;
            loaixe = sc.nextLine();
            switch (loaixe) {
                case "1":
                    products[length] = new Car();
                    check = true;
                    break;
                case "2":
                    products[length] = new Motorbike();
                    check = true;
                    break;
                default:
                    break;
            }
        } while (!check);
        products[length].input();
        length++;
    }

    public void add(Product x) {
        products = Arrays.copyOf(products, length + 1);
        if (x instanceof Car) {
            // DOWNCASTING
            products[length] = new Car((Car) x);
        } else {
            // DOWNCASTING
            products[length] = new Motorbike((Motorbike) x);
        }

        length++;
    }

    public void delete() {
        String id;
        System.out.print("Nhập ID sản phẩm cần xóa: ");
        id = sc.nextLine();
        delete(id);
    }

    public void delete(String ma) {
        for (int i = 0; i < length; i++) {
            if (products[i].getID().equalsIgnoreCase(ma)) {
                for (int j = i; j < length - 1; j++) {
                    products[j] = products[j + 1];
                }
                products = Arrays.copyOf(products, length - 1);
                length--;
                break;
            }
        }
    }

    public void edit() {
        String id;
        System.out.print("Nhập ID sản phẩm cần sửa: ");
        id = sc.nextLine();
        search(id);
        edit(id);
    }

    public void edit(String id) {
        Product product = search(id);
        if (product != null) {
            product.edit();
        }
    }

    public ProductList searchByName(String Name) {
        ProductList productsNew = new ProductList();
        for (int i = 0; i < length; i++) {
            if (products[i].getName().toLowerCase().contains(Name.toLowerCase()))
                productsNew.add(products[i]);
        }
        return productsNew;
    }

    public ProductList searchByBrand(String Brand) {
        ProductList productsNew = new ProductList();
        for (int i = 0; i < length; i++) {
            if (products[i].getBrand().equalsIgnoreCase(Brand))
                productsNew.add(products[i]);
        }
        return productsNew;
    }

    public Product search() {
        System.out.println("Nhập ID bạn cần tìm kiếm: ");
        String ID = sc.nextLine();
        return search(ID);
    }

    public Product search(String Id) {
        for (int i = 0; i < length; i++) {
            if (Id.equalsIgnoreCase(products[i].getID())) {
                return products[i];
            }
        }
        return null;
    }

    public void increaseQuantityByOneOfProduct(String Id){
        for(int i = 0; i < length; i++){
            if(Id.equals(products[i].getID())){
                products[i].quantity++;
                break;
            }
        }
    }

    public void decreaseQuantityByOneOfProduct(String Id){
        for(int i = 0; i < length; i++){
            if(Id.equals(products[i].getID())){
                products[i].quantity--;
                break;
            }
        }
    }

    public Product[] getProducts() {
        Product[] copyProducts = Arrays.copyOf(this.products, this.length);
        return copyProducts;
    }

    // public void getList() {
    // }
    // public static void main(String[] args) {
    // ProductList a = new ProductList();
    // a.add();
    // a.add();
    // a.display();
    // }
}
