package app;
import java.util.Locale;
public class DisplayLocales {
    public static void execute() {
        Locale[] locales = Locale.getAvailableLocales();
        System.out.println(LocaleContext.message("locales"));
        for (Locale locale : locales) {
            System.out.println(locale.toString());
        }
    }
}