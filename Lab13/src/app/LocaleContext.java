package app;

import java.text.DateFormatSymbols;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleContext {
    private static final String baseName = "res.Messages";
    private static Locale locale;
    private static ResourceBundle resourceBundle;

    public static void setLocale(String languageTag) {
        LocaleContext.locale = Locale.forLanguageTag(languageTag);
        LocaleContext.resourceBundle = ResourceBundle.getBundle(baseName, locale);
        System.out.println(LocaleContext.message("locale.set", languageTag));
    }

    public static String message(String key, String... arguments) {
        String pattern = resourceBundle.getString(key);
        return MessageFormat.format(pattern, (Object[]) arguments);
    }

    public static Locale getLocale() {
        return LocaleContext.locale;
    }
}