package mypackage;

public class ExampleTest {

    @Test
    public static void testMethod1() {
        System.out.println("testMethod1 executed");
    }

    @Test
    public static void testMethod2() {
        System.out.println("testMethod2 executed");
    }

    public static void anotherStaticMethod() {
        System.out.println("anotherStaticMethod executed");
    }

    public void nonTestMethod() {
        System.out.println("This is not a test method");
    }
}