import java.util.Scanner;

public class Customer extends Person {    
    Scanner sc = new Scanner(System.in);
    private String ID;

    public Customer() {
        super();
        ID = "";
    }

    public Customer(String ID, String name, String address, String phone, short age) {
        super(name, address, phone, age);
        this.ID = ID;
    }

    public Customer(Customer customer) {
        super((Person)customer);
        this.ID = customer.ID;
    }

    @Override
    public void input() {
        super.input();
        System.out.print("ID khách hàng: ");
        ID = sc.nextLine();
    }

    @Override
    public void display() {
        System.out.println("ID khách hàng: " + ID);
        super.display();
    }

    public void displayOrderHistory() {
        
    }

    public String getID() {
        return ID;
    }
    
    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String toString(){
        return "Customer," + ID + "," + name + "," + address + "," + phone + "," + age;
    }
}
