public class Car extends Product {
    private String socho;

    public Car() {
        super();
        socho = "4 chỗ";
    }

    public Car(String id, String hangxe, String Name, String Date, int price, String socho) {
        super(id, hangxe, Name, Date, price);
        this.socho = socho;
    }

    public String getIDCar() {
        return super.getID();
    }

    public void inputCar() {
        super.inputProduct();
        System.out.print("Số chỗ: ");
        socho = sc.nextLine();
    }

    public void outputCar() {
        super.outputProduct();
        System.out.println("Số chỗ: " + socho);
    }
}