public class Cash extends Payment{
    public Cash(double amount){
        super(amount);
    }
    public void processPayment(){
        System.out.println("Processing cash payment "+getamount());
    }
}