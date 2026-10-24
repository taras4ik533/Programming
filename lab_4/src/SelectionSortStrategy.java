public class SelectionSortStrategy implements SortStrategy {
    @Override
    public void sort(double[] array) {
        int length = array.length;
        for(int i = 0; i < length - 1; i++) {
            double min = array[i];
            int indexOfMin = i;
            for(int j = i + 1; j < length; j++){
                if (array[j] < min){
                    min = array[j];
                    indexOfMin = j;
                }
            }
            double temp = array[i];
            array[i] = array[indexOfMin];
            array[indexOfMin] = temp;
        }
    }
}
