// BankTransferPayment.java
// كلاس الدفع عن طريق التحويل البنكي
public class BankTransferPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("دفعت " + amount + " عن طريق تحويل بنكي.");
    }
}
