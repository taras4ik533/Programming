import java.util.Arrays;

public class Task5 {

    public static void main(String[] args) {
        int[][] tournament1 = {
                {0, 2, 1},
                {0, 0, 2},
                {1, 1, 0}
        };
        int[][] tournament2 = {
                {0, 0, 2},
                {2, 0, 0},
                {0, 2, 0}
        };
        int[][] nonSquare = {
                {0, 2, 1},
                {1, 0, 2}
        };
        int[][] nullTournament = null;
        printResults(tournament1);
        printResults(tournament2);
        printResults(nonSquare);
        printResults(nullTournament);

    }

    public static int[] getFlawless(int[][] results) {
        if (results == null)
            throw new NullPointerException("Турнірна таблиця не може бути null!");
        if (results.length == 0 || results[0] == null || results[0].length == 0)
            throw new IllegalArgumentException("Турнірна таблиця не може бути порожньою!");

        for (int i = 0; i < results.length; i++) {
            if (results[i] == null)
                throw new IllegalArgumentException("Дані про матчі команди не можуть бути null!");
            if (results[i].length != results.length)
                throw new IllegalArgumentException("Турнірна таблиця має бути квадратною");
        }
        int count = 0;
        for (int i = 0; i < results.length; i++) {
            boolean hasLoss = false;
            for (int j = 0; j < results[i].length; j++) {
                if (i != j && results[i][j] == 0) {
                    hasLoss = true;
                    break;
                }
            }
            if (!hasLoss)
                count++;
        }
        int[] flawless = new int[count];
        int index = 0;
        for (int i = 0; i < results.length; i++) {
            boolean hasLoss = false;
            for (int j = 0; j < results[i].length; j++) {
                if (i != j && results[i][j] == 0) {
                    hasLoss = true;
                    break;
                }
            }
            if (!hasLoss) {
                flawless[index] = i + 1;
                index++;
            }
        }
        return flawless;
    }

    public static void printResults(int[][] result) {
        System.out.println("Таблиця турніру: " + Arrays.deepToString(result));
        System.out.println("Команди без поразок: ");
        try {
            System.out.println(Arrays.toString(getFlawless(result)));
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println("ПОМИЛКА! " + e.getMessage());
        }
    }
}
