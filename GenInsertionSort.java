public class GenInsertionSort<T extends Comparable<? super T>> {

    private int j;

    public GenInsertionSort() {
        j = 0;
    }

    public <T extends iPoliceCollection> void genInsertionSort(T collection, int size) {

        if (size <= 1) {
            return;
        }
        genInsertionSort(collection, size - 1);

        int last = (int) collection.findIndex(size - 1);
        j = size - 2;

        while (j >= 0 && (int) collection.findIndex(j) > last) {
            collection.swapEl(j + 1, j);
            j--;
        }
        collection.swapEl(j + 1, last);
    }
}
