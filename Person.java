import java.util.Scanner;

public class Person {
    private String name;
    private String address;
    private String phone;
    private short  age;
    public Person(){
        name=" ";
        address=" ";
        phone=" ";
        age=0;
    }

    public Person(String name, String address, String phone, short age){
        this.name=name;
        this.address=address;
        this.phone=phone;
        this.age=age;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
    public Short getAge(){
        return age;
    }
    public void setAge(short age){
        this.age=age;
    }
    public void input(){
        Scanner reader=new Scanner(System.in);
        System.out.print("Nhập tên: ");
        this.name=reader.nextLine();
        System.out.print("Nhập địa chỉ: ");
        this.address=reader.nextLine();
        System.out.print("Nhâp số điện thoại: ");
        this.phone=reader.nextLine();
        System.out.print("Nhập số tuổi: ");
        this.age=Short.parseShort(reader.nextLine());
        
    }
    public void display(){
        System.out.println("Tên: "+name);
        System.out.println("Địa chỉ: "+address);
        System.out.println("Số điện thoại: "+phone);
        System.out.println("Tuổi: "+age);
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                '}';
    }
}   
