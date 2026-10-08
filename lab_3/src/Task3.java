import java.util.Arrays;
public class Task3 {

    public static void main(String[] args) {
        int[] a1 = { 3, -4,  5, 0};
        int[] b1 = { 7, -2, -1, 9};

        int[] a2 = { 1, -2, 0};
        int[] b2 = {-1,  2, 0};

        int[] aMismatch = {1, 2, 3};
        int[] bMismatch = {1, 2};

        int[] aEmpty = {};
        int[] bEmpty = {};

        int[] aNull = null;
        int[] bNull = {1, 2, 3};

        printResults(a1, b1);
        printResults(a2, b2);
        printResults(aMismatch, bMismatch);
        printResults(aEmpty, bEmpty);
        printResults(aNull, bNull);
    }

    public static int[] formArrayC(int[] a, int[] b) {
        if (a == null || b == null)
            throw new NullPointerException("Масиви не можуть бути null");
        if (a.length == 0 || b.length == 0)
            throw new IllegalArgumentException("Масиви не повинні бути пусті!");
        if (a.length != b.length)
            throw new IllegalArgumentException("Масиви повинні бути однакової довжини!");

        int[] c = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0 && b[i] > 0)
                c[i] = a[i] + b[i];
            else if (a[i] < 0 && b[i] < 0)
                c[i] = a[i] * b[i];
            else
                c[i] = 0;
        }

        return c;
    }

    public static void printResults(int[] a, int[] b) {
        System.out.println("Масив А: " + Arrays.toString(a));
        System.out.print("Масив В: " + Arrays.toString(b) + " | Результат: ");
        try {
            System.out.println(Arrays.toString(formArrayC(a, b)));
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println("ПОМИЛКА! " + e.getMessage());
        }
    }

}
