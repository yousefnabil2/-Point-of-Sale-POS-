package possystem;

// كلاس لتنبيه المخزون لما يقل عن الحد
public class StockAlertSystem implements StockObserver {
    @Override
    public void update(String product, int quantity) {
        if (quantity <= 5) {
            // لو المخزون أقل من 5، نطبع تنبيه
            System.out.println("ALERT: Low stock for product: " + product + " (Quantity: " + quantity + ")");
        }
    }
}
