package possystem;

// واجهة للتنبيه بالمخزون
public interface StockObserver {
    void update(String product, int quantity); // دالة لازم تتنفذ في كل كلاس يطبق الواجهة دي
}
