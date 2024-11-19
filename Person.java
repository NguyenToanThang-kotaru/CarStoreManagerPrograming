import java.util.Scanner;

public class Person {
    private String Name;
    private String Address;
    private String Phone;
    private Short Age;

    public Person(String Name,String Address,String Phone,Short Age){
        this.Name=Name;
        this.Address=Address;
        this.Phone=Phone;
        this.Age=Age;
    }
    public String getName(){
        return Name;
    }
    public void setName(String Name){
        this.Name=Name;
    }
    public String getAddress(){
        return Address;
    }
    public void setAddress(String Address){
        this.Address=Address;
    }
    public String getPhone(){
        return Phone;
    }
    public void setPhone(String Phone){
        this.Phone=Phone;
    }
    public Short getAge(){
        return Age;
    }
    public void setAge(Short Age){
        this.Age=Age;
    }
    public void Input(){
        Scanner reader=new Scanner(System.in);
        System.out.print("Nhập tên: ");
        this.Name=reader.nextLine();
        System.out.print("Nhập địa chỉ ");
        this.Address=reader.nextLine();
        System.out.print("Nhâp số điện thoại ");
        this.Phone=reader.nextLine();
        System.out.print("Nhập số tuổi ");
        this.Age=Short.parseShort(reader.nextLine());
    }
    public void Output(){
        System.out.println("Thông tin người dùng");
        System.out.println("Tên: "+getName());
        System.out.println("Địa chỉ: "+getAddress());
        System.out.println("Số điện thoại: "+getPhone());
        System.out.println("Tuổi: "+getAge());
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + Name + '\'' +
                ", address='" + Address + '\'' +
                ", phone='" + Phone + '\'' +
                ", age=" + Age +
                '}';
    }
}   
