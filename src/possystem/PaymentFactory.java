package possystem;

// مصنع لإنشاء طرق الدفع حسب النوع
public class PaymentFactory {
    public static PaymentMethod createPaymentMethod(String type) {
        switch (type) {
            case "CreditCard":
                // بيرجع طريقة الدفع بالكريدت كارد
                return new CreditCardPayment();
            case "Cash":
                // بيرجع طريقة الدفع بالكاش
                return new CashPayment();
            case "Mobile":
                // بيرجع طريقة الدفع بالموبايل
                return new MobilePayment();
            default:
                // لو النوع مش معروف بنرمي خطأ
                throw new IllegalArgumentException("Unknown payment method type: " + type);
        }
    }
}
