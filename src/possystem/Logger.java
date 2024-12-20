package possystem;

// كلاس اللوجر Singleton عشان يسجل كل العمليات
public class Logger {
    private static Logger instance = null; // النسخة الوحيدة من الكلاس

    private Logger() {
        // كونسركتور خاص عشان يمنع إنشاء نسخ جديدة
    }

    public static Logger getInstance() {
        // لو النسخة مش موجودة بنعمل واحدة جديدة
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        // بيطبع الرسالة مع كلمة LOG عشان التنظيم
        System.out.println("[LOG]: " + message);
    }
}
