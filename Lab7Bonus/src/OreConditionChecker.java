import java.util.Arrays;

public class OreConditionChecker {
    public static boolean satisfiesOreCondition(int[][] adjacencyMatrix) {
        int n = adjacencyMatrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (adjacencyMatrix[i][j] == 0 && (degree(adjacencyMatrix, i) + degree(adjacencyMatrix, j)) < n) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int degree(int[][] adjacencyMatrix, int vertex) {
        int degree = 0;
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[vertex][i] == 1) {
                degree++;
            }
        }
        return degree;
    }

    public static boolean hasHamiltonianCycle(int[][] adjacencyMatrix) {
        int n = adjacencyMatrix.length;
        int[] path = new int[n];
        Arrays.fill(path, -1);
        path[0] = 0;
        return hamiltonianCycleUtil(adjacencyMatrix, path, 1);
    }

    private static boolean hamiltonianCycleUtil(int[][] adjacencyMatrix, int[] path, int pos) {
        if (pos == adjacencyMatrix.length) {
            return adjacencyMatrix[path[pos - 1]][path[0]] == 1;
        }
        for (int v = 1; v < adjacencyMatrix.length; v++) {
            if (isSafe(v, adjacencyMatrix, path, pos)) {
                path[pos] = v;
                if (hamiltonianCycleUtil(adjacencyMatrix, path, pos + 1)) {
                    return true;
                }
                path[pos] = -1;
            }
        }
        return false;
    }

    private static boolean isSafe(int v, int[][] adjacencyMatrix, int[] path, int pos) {
        if (adjacencyMatrix[path[pos - 1]][v] == 0) {
            return false;
        }
        for (int i = 0; i < pos; i++) {
            if (path[i] == v) {
                return false;
            }
        }
        return true;
    }
}