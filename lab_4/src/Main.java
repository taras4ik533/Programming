import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        Random random = new Random();
        double[] myArray1 = new double[5];
        for (int i = 0; i < myArray1.length; i++) {
            myArray1[i] = random.nextDouble(10000);
        }
        System.out.println("||| Сортування даних |||");
        System.out.println("До: " + (Arrays.toString(myArray1)));
//Стратегія 1
        ArraySorter sorter = new ArraySorter();
        sorter.setStrategy(new BubbleSortStrategy());
        sorter.executeSort(myArray1);

        System.out.println("Після: " + (Arrays.toString(myArray1)));
    }

}