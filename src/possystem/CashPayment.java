package possystem;

// كلاس للدفع الكاش
public class CashPayment extends PaymentMethod implements PaymentStrategy {
    
    @Override
    public void processPayment(double amount) {
        // هنا بننفذ عملية الدفع الكاش وبنظهر رسالة توضح المبلغ المدفوع
        System.out.println("Processing cash payment of: $" + amount);
    }

    @Override
    public void pay(double amount) {
        // تنفيذ الدفع كجزء من PaymentStrategy
        System.out.println("دفعت " + amount + " كاش.");
    }
}
