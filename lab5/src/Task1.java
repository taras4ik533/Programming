public class Task1 {

    public static void main(String[] args) {

        int number1 = 1231;
        int number2 = 7;
        int number3 = 4214;
        int number4 = -1464;
        int number5 = 0;

        printResult(number1);
        printResult(number2);
        printResult(number3);
        printResult(number4);
        printResult(number5);
    }


    public static String toOctal(int number) {
        if (number < 0)
            throw new IllegalArgumentException("Число має бути невід'ємне!");
        if (number == 0)
            return "0";
        StringBuilder result = new StringBuilder();
        while (number > 0) {
            int element = number %8;
            number /= 8;
            result.append(element);
        }
        return result.reverse().toString();
    }


    public static void printResult(int number) {
        System.out.println("\nПочаткове число: " + number);
        try {
            System.out.println("Переведене число: " + toOctal(number));
            System.out.println("Тип даних: " + toOctal(number).getClass().getSimpleName());
        } catch (IllegalArgumentException e) {
            System.out.println("ПОМИЛКА!!! " + e.getMessage());
        }
    }
}
