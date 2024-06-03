package app;

import java.text.DateFormatSymbols;
import java.text.MessageFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Currency;
import java.util.Locale;

public class Info {
    public static void execute() {
        Locale locale = LocaleContext.getLocale();
        System.out.println(LocaleContext.message("info", locale.toString())); // Modificarea cheii "info" pentru a primi parametrul corect
        Currency currency = Currency.getInstance(locale);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM dd, yyyy", locale);
        LocalDateTime now = LocalDateTime.now();
        DateFormatSymbols dfs = new DateFormatSymbols(locale);
        System.out.println("Country: " + locale.getDisplayCountry() + " (" + locale.getCountry() + ")");
        System.out.println("Language: " + locale.getDisplayLanguage() + " (" + locale.getLanguage() + ")");
        System.out.println("Currency: " + currency.getCurrencyCode() + " (" + currency.getDisplayName() + ")");
        System.out.println("Week Days: " + String.join(", ", dfs.getWeekdays()));
        System.out.println("Months: " + String.join(", ", dfs.getMonths()));
        System.out.println("Today: " + dtf.format(now));
    }
}