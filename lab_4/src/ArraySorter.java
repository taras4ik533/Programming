public class ArraySorter {
    public SortStrategy strategy;
    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }
    public void executeSort(double[] array) {
        strategy.sort(array);
    }
}
