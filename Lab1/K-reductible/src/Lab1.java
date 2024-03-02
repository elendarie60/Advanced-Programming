public class Lab1 {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("java Lab1 <a> <b> <k>");
            return;
        }
        int a, b, k;
        try {
            a = Integer.parseInt(args[0]);
            b = Integer.parseInt(args[1]);
            k = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid a sau b sau k");
            return;
        }
        if (a > b) {
            System.out.println("a trebuie sa fie mai mic sau egal cu b");
            return;
        }
        StringBuilder result = new StringBuilder();
        long startTime = System.nanoTime();
        for (int num = a; num <= b; num++) {
            if (isKReductible(num, k)) {
                result.append(num).append(" ");
            }
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Numerele kreductibile din interval [" + a + "," + b + "]" + result);

        System.out.println("Timpul:" + duration + "nanosecunde");
    }

    private static boolean isKReductible(int num, int k) {
        while (num != k && num != 1) {
            int sum = 0;
            String digits = String.valueOf(num);
            for (char digit : digits.toCharArray()) {
                int d = Character.getNumericValue(digit);
                sum += d * d;
            }
            num = sum;
        }
        return num == k;
    }

}