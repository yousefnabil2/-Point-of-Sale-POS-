package possystem;

// كلاس للدفع بالكريدت كارد
public class CreditCardPayment extends PaymentMethod implements PaymentStrategy {
    
    @Override
    public void processPayment(double amount) {
        // هنا بننفذ عملية الدفع بالكريدت وبنظهر رسالة توضح المبلغ المدفوع
        System.out.println("Processing credit card payment of: $" + amount);
    }

    @Override
    public void pay(double amount) {
        // تنفيذ الدفع كجزء من PaymentStrategy
        System.out.println("دفعت " + amount + " ببطاقة الائتمان.");
    }
}
