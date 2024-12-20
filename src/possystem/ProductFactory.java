package possystem;

// مصنع لإنشاء المنتجات حسب الفئة
public class ProductFactory {
    public static Product createProduct(String category, String name, double price) {
        switch (category) {
            case "Electronics" -> {
                // بيرجع منتج من نوع إلكترونيات
                return new Electronics(name, price);
            }
            case "Apparel" -> {
                // بيرجع منتج من نوع ملابس
                return new Apparel(name, price);
            }
            default -> 
                // لو الفئة مش معروفة بنرمي خطأ
                throw new IllegalArgumentException("Unknown category: " + category);
        }
    }
}
