package app;
import java.util.Scanner;

public class LocaleExplorer {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(LocaleContext.message("prompt"));
            String command = scanner.nextLine();
            if (command.equals("exit")) break;
            String[] params = command.trim().split("\\s+");
            try {
                switch (params[0]) {
                    case "locales": {
                        DisplayLocales.execute();
                        break;
                    }
                    case "set": {
                        if (params.length < 2) {
                            System.out.println(LocaleContext.message("invalid"));
                            break;
                        }
                        SetLocale.execute(params[1]);
                        break;
                    }
                    case "info": {
                        Info.execute();
                        break;
                    }
                    default:
                        System.out.println(LocaleContext.message("invalid"));
                }
            } catch (Exception e) {
                System.err.println("Error executing command: " + e.getMessage());
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        LocaleContext.setLocale("en-US");
        new LocaleExplorer().run();
    }
}