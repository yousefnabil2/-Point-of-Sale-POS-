package possystem;

import java.util.HashMap;
import java.util.Map;

// مدير المخزون
public class InventoryManager {
    private static InventoryManager instance = null; // دي النسخة الوحيدة من الكلاس
    private Map<String, Integer> inventory; // خريطة بتشيل الكميات بتاعة المنتجات
    private Map<String, Double> prices;     // خريطة بتشيل الأسعار بتاعة المنتجات
    private Logger logger; // لوجر عشان يسجل كل العمليات

    private InventoryManager() {
        // هنا بنعمل تهيئة للمخزون والأسعار
        inventory = new HashMap<>();
        prices = new HashMap<>();
        logger = Logger.getInstance();
    }

    public static InventoryManager getInstance() {
        // Singleton عشان نضمن إن الكلاس يتعمل منه نسخة واحدة بس
        if (instance == null) {
            instance = new InventoryManager();
        }
        return instance;
    }

    // إضافة منتج جديد للمخزون
    public void addProduct(String name, int quantity, double price) {
        // بنضيف الكمية للمخزون
        inventory.put(name, inventory.getOrDefault(name, 0) + quantity);
        // بنضيف السعر للمنتج
        prices.put(name, price);
        // تسجيل العملية في اللوج
        logger.log("Added product: " + name + " | Quantity: " + quantity + " | Price: $" + price);
    }

    // بيع منتج (إزالة الكمية)
    public void removeProduct(String name, int quantity) {
        if (inventory.containsKey(name) && inventory.get(name) >= quantity) {
            // بنخصم الكمية اللي تم بيعها
            inventory.put(name, inventory.get(name) - quantity);
            // بنجيب سعر الوحدة
            double pricePerUnit = prices.getOrDefault(name, 0.0);
            // بنحسب الإجمالي
            double totalPrice = pricePerUnit * quantity;

            System.out.println("Total Price Calculated for " + name + ": " + totalPrice);

            // تسجيل عملية البيع
            logger.log("Sold product: " + name + " | Quantity: " + quantity);
            SalesTransactionManager.getInstance().recordTransaction(name, quantity, totalPrice, "Cash");
        } else {
            // لو الكمية مش كفاية بنسجل فشل العملية
            logger.log("Failed to remove product: " + name + " | Insufficient stock");
        }
    }

    // دالة ترجع سعر المنتج
    public double getPrice(String name) {
        return prices.getOrDefault(name, 0.0);
    }

    // دالة بتشيك كمية المنتج
    public int checkStock(String name) {
        return inventory.getOrDefault(name, 0);
    }
}
