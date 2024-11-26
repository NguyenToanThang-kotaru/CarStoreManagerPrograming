import java.util.Scanner;

public abstract class Person {
    Scanner reader = new Scanner(System.in);
    protected String name;
    protected String address;
    protected String phone;
    protected short age;

    public Person() {
        name = "";
        address = "";
        phone = "";
        age = 0;
    }

    public Person(Person person) {
        this.name = person.name;
        this.address = person.address;
        this.phone = person.phone;
        this.age = person.age;
    }

    public Person(String name, String address, String phone, short age) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public void input() {
        
        System.out.print("Nhập tên: ");
        this.name = reader.nextLine();
        System.out.print("Nhập địa chỉ: ");
        this.address = reader.nextLine();
        System.out.print("Nhâp số điện thoại: ");
        this.phone = reader.nextLine();
        System.out.print("Nhập số tuổi: ");
        this.age = Short.parseShort(reader.nextLine());

    }

    public void display() {
        System.out.println("Tên: " + name);
        System.out.println("Địa chỉ: " + address);
        System.out.println("Số điện thoại: " + phone);
        System.out.println("Tuổi: " + age);
    }

    
    public abstract String toString(); 
        
    
}
