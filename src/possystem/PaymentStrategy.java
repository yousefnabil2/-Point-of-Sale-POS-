package possystem;

// الواجهة اللي بنحدد بيها كل طرق الدفع
public interface PaymentStrategy {
    // دالة الدفع اللي لازم كل كلاس يطبقها
    void pay(double amount);
}
