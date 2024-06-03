package app;

public class SetLocale {
    public static void execute(String languageTag) {
        LocaleContext.setLocale(languageTag);
    }
}