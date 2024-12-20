package possystem;

// كلاس بيعمل تهيئة للمنتجات في المخزون
public class ProductInitializer {
    public static void initializeProducts(InventoryManager inventoryManager) {
        // إضافة منتجات للمخزون مع الأسعار والكميات
        inventoryManager.addProduct("phone", 20, 100.0); // Phone بسعر 100 لكل وحدة
        inventoryManager.addProduct("laptop", 15, 500.0); // Laptop بسعر 500 لكل وحدة
        inventoryManager.addProduct("tablet", 10, 300.0); // Tablet بسعر 300 لكل وحدة
        inventoryManager.addProduct("fish", 30, 50.0); // Fish بسعر 50 لكل وحدة
        inventoryManager.addProduct("vegetables", 50, 20.0); // Vegetables بسعر 20 لكل وحدة
        inventoryManager.addProduct("meat", 25, 150.0); // Meat بسعر 150 لكل وحدة
        inventoryManager.addProduct("bread", 40, 10.0); // Bread بسعر 10 لكل وحدة
        inventoryManager.addProduct("milk", 20, 15.0); // Milk بسعر 15 لكل وحدة
    }
}
