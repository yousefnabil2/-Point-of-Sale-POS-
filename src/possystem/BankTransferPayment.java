package possystem;

// كلاس الدفع عن طريق التحويل البنكي
public class BankTransferPayment extends PaymentMethod implements PaymentStrategy {
    
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing bank transfer payment of: $" + amount);
    }

    @Override
    public void pay(double amount) {
        System.out.println("دفعت " + amount + " عن طريق تحويل بنكي.");
    }
}
