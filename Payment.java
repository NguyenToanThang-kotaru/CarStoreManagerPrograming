public  abstract class Payment {
    private double amount;
    public abstract  void processPayment();
    public Payment(double amount){
        this.amount=amount;

    }
    public void setamount(double amount){
        this.amount=amount;

    }
    public double getamount(){
        return amount;
    }
    public String getPaymentDetail(){
        return "Amount: "+amount;
    }

}


// public class Main {
//     public static void main(String[] args) {
//         // Create a CreditCard payment
//         CreditCard creditCard = new CreditCard("1234-5678-9876-5432", 100.50);
//         creditCard.processPayment();
//         System.out.println(creditCard.getPaymentDetail());

//         // Create a Cash payment
//         Cash cashPayment = new Cash(50.00);
//         cashPayment.processPayment();
//         System.out.println(cashPayment.getPaymentDetail());
//     }
// }
