public class HelloWorld {

    public static void main(String[] args) {


        final long startTime = System.nanoTime();
        System.out.println("Hello World");
        System.out.println();

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        for (int i = 0; i < languages.length; i++) {
            System.out.print(languages[i] + " ");
        }

        System.out.println();

        int n = (int) (Math.random() * 1_000_000);

        n = n * 3;
        n = n + 0b10101;
        n = n + 0xFF;
        n = n * 6;

        int result = 0;
        int ok = 0;

        while ((n / 10) > 0) {
            int sum = 0;
            while (n != 0) {
                sum = n % 10;
                n = n / 10;
            }
            result = sum;
        }
        System.out.println(result);
        System.out.println("Willy-nilly, this semester i will learn " + languages[result] + ".");
        System.out.println();
    }
}