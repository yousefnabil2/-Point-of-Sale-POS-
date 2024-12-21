package possystem;

import javax.swing.*;

// الكلاس الأساسي اللي فيه واجهة البرنامج
public class Main {
    public static void main(String[] args) {
        // بنجيب نسخة واحدة من مدير المخزون باستخدام Singleton
        InventoryManager inventoryManager = InventoryManager.getInstance();
        // بنجيب نسخة واحدة من مدير المبيعات بنفس الطريقة
        SalesTransactionManager salesManager = SalesTransactionManager.getInstance();
        // هنا النظام اللي بيعمل تنبيه لو المخزون قرب يخلص
        StockAlertSystem stockAlert = new StockAlertSystem();

        // تهيئة المنتجات الأولية في المخزون
        ProductInitializer.initializeProducts(inventoryManager);

        // تشغيل الواجهة الرسومية باستخدام Swing
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Point of Sale System"); // إنشاء نافذة البرنامج
            frame.setSize(600, 400); // تحديد حجم النافذة
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // البرنامج يقفل لما النافذة تتقفل

            JPanel panel = new JPanel(); // بانل عشان نحط فيه المكونات
            frame.add(panel); // إضافة البانل للنافذة
            placeComponents(panel, inventoryManager, salesManager, stockAlert); // ترتيب المكونات جوه البانل

            frame.setVisible(true); // عرض النافذة
        });
    }

    private static void placeComponents(JPanel panel, InventoryManager inventoryManager, SalesTransactionManager salesManager, StockObserver stockAlert) {
        panel.setLayout(null); // استخدام Layout يدوي

        // ليبل عشان اسم المنتج
        JLabel productLabel = new JLabel("Product Name:");
        productLabel.setBounds(10, 20, 80, 25); // تحديد مكانه
        panel.add(productLabel); // إضافته للبانل

        // تكست فيلد لكتابة اسم المنتج
        JTextField productText = new JTextField(20);
        productText.setBounds(150, 20, 165, 25); // تحديد مكانه
        panel.add(productText); // إضافته للبانل

        // ليبل للكمية
        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setBounds(10, 50, 80, 25);
        panel.add(quantityLabel);

        // تكست فيلد لكتابة الكمية
        JTextField quantityText = new JTextField(20);
        quantityText.setBounds(150, 50, 165, 25);
        panel.add(quantityText);

        // ليبل لطريقة الدفع
        JLabel paymentLabel = new JLabel("Payment Type:");
        paymentLabel.setBounds(10, 80, 100, 25);
        panel.add(paymentLabel);

        // كومبو بوكس لاختيار طريقة الدفع (إضافة Bank Transfer كخيار جديد)
        JComboBox<String> paymentCombo = new JComboBox<>(new String[]{
            "CreditCard", "Cash", "Mobile", "Bank Transfer"
        });
        paymentCombo.setBounds(150, 80, 165, 25);
        panel.add(paymentCombo);

        // زرار لمعالجة الصفقة
        JButton transactionButton = new JButton("Process Transaction");
        transactionButton.setBounds(10, 110, 180, 25);
        panel.add(transactionButton);

        // الحدث اللي بيحصل لما المستخدم يضغط على الزرار
        transactionButton.addActionListener(e -> {
            String productName = productText.getText(); // اسم المنتج
            int quantity = Integer.parseInt(quantityText.getText()); // الكمية
            String paymentType = (String) paymentCombo.getSelectedItem(); // طريقة الدفع

            int stock = inventoryManager.checkStock(productName); // التشييك على الكمية في المخزون

            if (stock >= quantity) {
                // جلب سعر المنتج وحساب الإجمالي
                double pricePerUnit = inventoryManager.getPrice(productName); 
                double totalPrice = pricePerUnit * quantity; 

                // تحديث المخزون وتسجيل الصفقة
                inventoryManager.removeProduct(productName, quantity);
                salesManager.recordTransaction(productName, quantity, totalPrice, paymentType);
                stockAlert.update(productName, inventoryManager.checkStock(productName));
            } else {
                // لو المخزون مش كفاية، تظهر رسالة
                JOptionPane.showMessageDialog(panel, "out of stock for: " + productName);
            }
        });
    }
}
