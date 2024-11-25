public class Motorbike extends Product{
    private short CC;
    public Motorbike(){
        super();
        CC = 100;
    }    

    public Motorbike(String ID, String brand, String name, String date, long price, String color, int quantity,short CC){
        super(ID,brand,name,date, price,color,quantity);
        this.CC=CC;
    }

    public void input() {
        super.input();
        System.out.print("Phân khối: ");
        CC = sc.nextByte();
    }

    public void display() {
        super.display();
        System.out.println("Phân khối: " + CC);
    }

    public short getCC(){
        return CC;
    }

    public void setCC(short CC){
        this.CC=CC;
    }
}
