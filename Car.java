public class Car extends Product {
    private byte seat;

    public Car() {
        super();
        seat = 4;
    }

    public Car(String ID, String brand, String name, String date, int price, String color, int quantity, byte seat) {
        super(ID,brand,name,date, price,color,quantity);
        this.seat = seat;
    }

    public void inputCar() {
        super.input();
        System.out.print("Số chỗ: ");
        seat = sc.nextByte();
    }

    public void display() {
        super.display();
        System.out.println("Số chỗ: " + seat);
    }
    
    public byte getSeat(){
        return seat;
    }
    
    public void setSeat(byte seat){
        this.seat=seat;
    }
}