public class Task2 {

    public static void main(String[] args) {

        String testSentence = "The user with the nickname Koala757677" +
                " this month wrote 3 times more comments than the user" +
                " with the nickname CROco181dile920 4 months ago";
        String testSentence2 = null;
        String testSentence3 = "    ";
        String testSentence4 = "   HELLO WORLD";
        String testSentence5 = "123 ABC456 Word";


        printResult(testSentence);
        printResult(testSentence2);
        printResult(testSentence3);
        printResult(testSentence4);
        printResult(testSentence5);

    }
    public static String lowLettersSentence(String str) {
        if ( str == null)
            throw new NullPointerException("Речення не може бути null");
        if ( str.isBlank())
            throw new IllegalArgumentException("Речення не може бути пустим");
        String[] splitstr = str.split(" ");

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < splitstr.length; i++) {
            boolean cleanWord = true;

            for (char c : splitstr[i].toCharArray()) {
                if (!Character.isLetter(c)) {
                    cleanWord = false;
                    break;
                }
            }

            if (!cleanWord)
                result.append(splitstr[i]).append(" ");
            else result.append(splitstr[i].toLowerCase()).append(" ");
        }
        return result.toString().strip();
    }

    public static void printResult (String str) {
        System.out.println("\nРечення до: ");
        System.out.println(str);
        System.out.println("Речення після:");
        try {
            System.out.println(lowLettersSentence(str));
        } catch (IllegalArgumentException e) {
            System.out.println("ПОМИЛКА!!! " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("ПОМИЛКА!!! " + e.getMessage());
        }
    }
}
