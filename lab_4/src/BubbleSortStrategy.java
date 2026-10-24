public class BubbleSortStrategy implements SortStrategy {
    @Override
    public void sort(double[] array) {
        boolean fullSorted = true;
        while (fullSorted) {
            fullSorted = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i+1] < array[i]) {
                    double temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                    fullSorted = true;
                }
            }
        }

    }
}