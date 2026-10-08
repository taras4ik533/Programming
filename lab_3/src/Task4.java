import java.util.Arrays;

public class Task4 {

    public static void main(String[] args) {
        int[][] matrix1 = {
                {-5,  9,  4,  2},
                { 3,  1, -5,  9},
                { 0,  8,  7, -1}
        };
        int[][] matrix2 = {
                { 1,  50,  3},
                { 4, -10,  6},
                { 7,   0,  8}
        };
        int[][] emptyMatrix = {};
        int[][] nullMatrix = null;
        int[][] badMatrix = {
                {1, 2, 3},
                {4, 5}
        };

        printResults(matrix1);
        printResults(matrix2);
        printResults(emptyMatrix);
        printResults(nullMatrix);
        printResults(badMatrix);
    }

    public static void swapColumns(int[][] matrix) {
        if (matrix == null) {
            throw new NullPointerException("Матриця не може бути null");
        }
        if (matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            throw new IllegalArgumentException("Матриця не може бути порожньою");
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int r = 1; r < rows; r++) {
            if (matrix[r] == null || matrix[r].length != cols) {
                throw new IllegalArgumentException("Матриця повинна бути прямокутною");
            }
        }

        int minVal = matrix[0][0];
        int maxVal = matrix[0][0];
        int minCol = 0;
        int maxCol = 0;

        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < rows; r++) {
                int current = matrix[r][c];
                if (current < minVal) {
                    minVal = current;
                    minCol = c;
                }
                if (current >= maxVal) {
                    maxVal = current;
                    maxCol = c;
                }
            }
        }

        if (minCol != maxCol) {
            for (int r = 0; r < rows; r++) {
                int temp = matrix[r][minCol];
                matrix[r][minCol] = matrix[r][maxCol];
                matrix[r][maxCol] = temp;
            }
        }
    }

    public static void printResults(int[][] matrix) {
        System.out.println("Матриця: " + Arrays.deepToString(matrix));
        System.out.println("Результат: ");
        try {
            swapColumns(matrix);
            for (int[] row : matrix)
                System.out.println(Arrays.toString(row));
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println("ПОМИЛКА! " + e.getMessage());
        }
    }
}