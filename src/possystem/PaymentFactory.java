package possystem;

// مصنع لإنشاء طرق الدفع حسب النوع
public class PaymentFactory {
    public static PaymentStrategy createPaymentMethod(String type) {
        switch (type.toLowerCase()) {
            case "creditcard":
                // بيرجع طريقة الدفع بالكريدت كارد
                return new CreditCardPayment();
            case "cash":
                // بيرجع طريقة الدفع بالكاش
                return new CashPayment();
            case "mobile":
                // بيرجع طريقة الدفع بالموبايل
                return new MobilePayment();
            case "banktransfer":
                // بيرجع طريقة الدفع بالتحويل البنكي
                return new BankTransferPayment();
            default:
                // لو النوع مش معروف بنرمي خطأ
                throw new IllegalArgumentException("طريقة الدفع غير معروفة: " + type);
        }
    }
}
