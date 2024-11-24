public class CreditCard extends Payment{
    private String CardNumber;
    public CreditCard(String CardNumber, double amount){
        super(amount);
        this.CardNumber=CardNumber;
    }

    public void processPayment(){
        System.out.println("Processing card payment"+getamount());
    
    }
    
    public String getCardNumber(){
        return CardNumber;

    }
}