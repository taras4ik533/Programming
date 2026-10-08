import java.util.Arrays;
public class Task2 {

    public static void main(String[] args) {
        int[] validArray1 = {12, -3, 20, -8, 4, -15, 4, 42, -4};
        int[] validArray2 = {1, 2, 3, -4, 8, -4, 4, 8, 12};
        int[] noValidArray = {0, 2, 3, 4, -4, 64, 32, 12, -8};
        int[] emptyArray = {};
        int[] nullArray = null;
        printResults(validArray1);
        printResults(validArray2);

        printResults(emptyArray);
        printResults(nullArray);
    }

    public static int indexMultipleOfFourMoreZero(int[] array) {
        if (array == null || array.length == 0)
            throw new IllegalArgumentException("Масив пустий");
        int count = 0;
        for(int i = 0; i < array.length; i++) {
            if (i % 4 == 0 && array[i] > 0)
                count += 1;
        }
        return count;
    }

    public static void printResults(int[] array) {
        System.out.print("Масив: " + Arrays.toString(array) + " | Результат: ");
        try {
            System.out.println(indexMultipleOfFourMoreZero(array));
        } catch (IllegalArgumentException e) {
            System.out.println("ПОМИЛКА! " + e.getMessage());
        }
    }

}
