package mypackage;
import java.lang.reflect.Method;

public class ClassAnalyzer {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java mypackage.ClassAnalyzer <fully-qualified-class-name>");
            return;
        }

        String className = args[0];

        try {
            // umplem clasa
            Class<?> clazz = Class.forName(className);

            System.out.println("Class: " + clazz.getName());

            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println("Method: " + method);

                // testam @Test
                if (method.isAnnotationPresent(Test.class)) {
                    System.out.println("Found @Test annotation on method: " + method.getName());

                    // metoda statica si fara parameteri
                    if (java.lang.reflect.Modifier.isStatic(method.getModifiers()) && method.getParameterCount() == 0) {
                        System.out.println("Invoking static test method: " + method.getName());
                        try {
                            method.invoke(null);
                        } catch (Exception e) {
                            System.out.println("Failed to invoke method: " + method.getName());
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("Skipping method: " + method.getName() + " (not static or has parameters)");
                    }
                }
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + className);
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("An error occurred while analyzing the class.");
            e.printStackTrace();
        }
    }
}