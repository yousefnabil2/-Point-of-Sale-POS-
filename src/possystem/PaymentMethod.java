package possystem;

// كلاس مجرد لكل طرق الدفع
public abstract class PaymentMethod {
    public abstract void processPayment(double amount); // دالة لازم كل نوع دفع يحققها
}
