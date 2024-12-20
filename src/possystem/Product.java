package possystem;

// كلاس مجرد لكل أنواع المنتجات
public abstract class Product {
    String name; // اسم المنتج
    double price; // سعر المنتج

    public Product(String name, double price) {
        // كونسركتور لتحديد الاسم والسعر
        this.name = name;
        this.price = price;
    }

    public abstract String getDetails(); // دالة عشان تعرض تفاصيل المنتج
}
