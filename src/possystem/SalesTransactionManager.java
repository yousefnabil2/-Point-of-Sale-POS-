package possystem;

// مدير المبيعات اللي بيسجل كل العمليات
public class SalesTransactionManager {
    private static SalesTransactionManager instance = null; // النسخة الوحيدة من الكلاس
    private Logger logger; // لوجر عشان تسجيل العمليات

    private SalesTransactionManager() {
        // إنشاء اللوجر
        logger = Logger.getInstance();
    }

    public static SalesTransactionManager getInstance() {
        // Singleton عشان نضمن إن الكلاس يتعمل منه نسخة واحدة بس
        if (instance == null) {
            instance = new SalesTransactionManager();
        }
        return instance;
    }

    public void recordTransaction(String productName, int quantity, double totalPrice, String paymentType) {
        // طباعة القيمة للتحقق
        System.out.println("Recording Transaction - Total Price: " + totalPrice);
        // تسجيل العملية في اللوجر
        logger.log("Transaction Recorded: Product: " + productName + ", Quantity: " + quantity + ", Total Price: $" + totalPrice + ", Payment: " + paymentType);
    }
}
