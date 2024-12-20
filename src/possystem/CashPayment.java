package possystem;

// كلاس للدفع الكاش
public class CashPayment extends PaymentMethod {
    @Override
    public void processPayment(double amount) {
        // هنا بننفذ عملية الدفع الكاش وبنظهر رسالة توضح المبلغ المدفوع
        System.out.println("Processing cash payment of: $" + amount);
    }
}
