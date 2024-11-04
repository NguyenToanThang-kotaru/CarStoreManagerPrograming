package Vehicle;
import java.util.Scanner;

class product {
    Scanner sc = new Scanner(System.in);
    private String Name;
    private String Date;
    private int price;
    private String id;
    private String hangxe;

    public product() {
        Name = "product";
        price = 0;
        id ="0";
        hangxe="Honda";
        Date="2000";
    }

    public product(String id, String hangxe,String Name,String Date, int price) 
    {
        this.id = id;
        this.hangxe=hangxe;
        this.Name = Name;
        this.price = price;
        this.Date=Date;
    }

    public void outputProduct() {
        System.out.print("ID: ");
        System.out.println(id);
        System.out.print("Brand: ");
        System.out.println(hangxe);
        System.out.print("Name: ");
        System.out.println(Name);
        System.out.print("Date: ");
        System.out.println(Date);
        System.out.print("Price: ");
        System.out.println(price);
    }

    public void inputProduct() {
        System.out.print("ID: ");
        id = sc.nextLine();
        System.out.print("Dong xe: ");
        hangxe = sc.nextLine();
        System.out.print("Ten xe: ");
        Name = sc.nextLine();
        System.out.print("Nam san xuat: ");
        Date = sc.nextLine();
        System.out.print("Gia tien: ");
        price = sc.nextInt();
        
    }
}

class Car extends product{
    String socho;
    public Car(){
        super();
        socho="4 cho";
    }    
    public Car(String id, String hangxe,String Name,String Date, int price,String socho)
    {
        super(id, hangxe,Name,Date,price);
        this.socho=socho;
    }
    public void inputCar(){
        super.inputProduct();
        System.out.print("So cho: ");
        sc.nextLine();
        socho = sc.nextLine();
    }
    public void outputCar(){
        super.outputProduct();
        System.out.print("So cho: ");
        System.out.println(socho);
    }
}

