public class Task1 {

    public static void main(String[] args) {
        int[] validArray = {10, 3, 25, 7, 0, -15};
        int[] noMultiplesArray = {1, 2, 3, 4, 7};
        int[] emptyArray = {};
        int[] nullArray = null;
        printResults(validArray);
        printResults(noMultiplesArray);
        printResults(emptyArray);
        printResults(nullArray);
    }

    public static int countMultipleOfFive(int[] array) {
        if (array == null || array.length == 0)
                throw new IllegalArgumentException("Масив пустий");
        int count = 0;
        for(int i: array) {
            if (i % 5 == 0)
                count += 1;
        }
        return count;
    }

    public static void printResults(int[] array) {
        System.out.print("Масив: " + java.util.Arrays.toString(array) + " | Результат: ");
        try {
            System.out.println(countMultipleOfFive(array));
        } catch (IllegalArgumentException e) {
            System.out.println("ПОМИЛКА! " + e.getMessage());
        }
    }

}
