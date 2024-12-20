package possystem;

// كلاس للدفع بالموبايل
public class MobilePayment extends PaymentMethod {
    @Override
    public void processPayment(double amount) {
        // هنا بنعرض رسالة بتوضح المبلغ المدفوع عن طريق الموبايل
        System.out.println("Processing mobile payment of: $" + amount);
    }
}
