package possystem;

// كلاس للملابس بيورث من المنتج الأساسي
// الملابس دي نوع من أنواع المنتجات
public class Apparel extends Product {
    public Apparel(String name, double price) {
        // بنادي على الكونسركتور بتاع الكلاس الأب (Product)
        super(name, price);
    }

    @Override
    public String getDetails() {
        // هنا بنعرض تفاصيل المنتج زي الاسم والسعر
        return "Apparel: " + name + ", Price: $" + price;
    }
}
