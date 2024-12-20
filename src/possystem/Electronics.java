package possystem;

// كلاس للإلكترونيات بيورث من المنتج الأساسي
// الإلكترونيات دي نوع تاني من أنواع المنتجات
public class Electronics extends Product {
    public Electronics(String name, double price) {
        // بنادي على الكونسركتور بتاع الكلاس الأب (Product)
        super(name, price);
    }

    @Override
    public String getDetails() {
        // هنا بنعرض تفاصيل المنتج زي الاسم والسعر
        return "Electronics: " + name + ", Price: $" + price;
    }
}
