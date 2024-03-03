import java.util.Scanner;

public class Lab1 {
    public static int computeSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public static boolean isKReductible(int n, int k) {
        while (true) {
            n = computeSum(n);
            if (n == k || n == 1) {
                return true;
            }
            if (n < k || n == 89) { // Optimization to avoid infinite loops for non-reductible numbers
                return false;
            }
        }
    }

    public static void main(String[] args) {
        // Valid arg
        if (args.length != 3) {
            System.out.println("Usage: java Lab1 a b k");
            return;
        }

        // Parse arg
        int a, b, k;
        try {
            a = Integer.parseInt(args[0]);
            b = Integer.parseInt(args[1]);
            k = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.out.println(" a, b, k invalid");
            return;
        }

        if (a > b) {
            System.out.println("'a' > 'b' error");
            return;
        }

        StringBuilder result = new StringBuilder();
        long startTime = System.nanoTime();

        for (int i = a; i <= b; i++) {
            if (isKReductible(i, k)) {
                result.append(i).append(" ");
            }
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000; // Duration in milliseconds

        //result and running time
        System.out.println("K-reductible numbers in the interval [" + a + ", " + b + "] with k = " + k + ":");
        System.out.println(result);
        System.out.println("Running time: " + duration + " milliseconds");
    }

    public class WheelGraph {
        public static int[][] createAdjacencyMatrix(int n) {
            int[][] adjacencyMatrix = new int[n][n];
            // TO DO 
            return adjacencyMatrix;
        }
    }
}
