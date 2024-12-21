package possystem;

// كلاس للدفع بالموبايل
public class MobilePayment extends PaymentMethod implements PaymentStrategy {
    
    @Override
    public void processPayment(double amount) {
        // هنا بنعرض رسالة بتوضح المبلغ المدفوع عن طريق الموبايل
        System.out.println("Processing mobile payment of: $" + amount);
    }

    @Override
    public void pay(double amount) {
        // تنفيذ الدفع كجزء من PaymentStrategy
        System.out.println("دفعت " + amount + " عن طريق الموبايل.");
    }
}
