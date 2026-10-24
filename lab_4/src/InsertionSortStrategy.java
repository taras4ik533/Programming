public class InsertionSortStrategy implements SortStrategy {
    @Override
    public void sort(double[] array) {
        for(int i = 1; i < array.length; i++) {
            double currentVal = array[i];
            int j = i - 1;
            while(j >= 0 && array[j] > currentVal) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = currentVal;
        }
    }
}
