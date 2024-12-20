package possystem;

// كلاس للدفع بالكريدت كارد
public class CreditCardPayment extends PaymentMethod {
    @Override
    public void processPayment(double amount) {
        // هنا بننفذ عملية الدفع بالكريدت وبنظهر رسالة توضح المبلغ المدفوع
        System.out.println("Processing credit card payment of: $" + amount);
    }
}
