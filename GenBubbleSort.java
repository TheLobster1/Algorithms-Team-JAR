public class GenBubbleSort<T extends Comparable<? super T>> {
    private int i;
    private int n;
    private int j;
    private boolean swapped;

    public GenBubbleSort() {
        n = 0;
        i = 0;
        j = 0;
        swapped = false;
    }

    public void bubbleSort(T[] array) {
        n = array.length;

        //Runs till the 2nd last element because the last element should be sorted
        for (i = 0; i < n - 1; i++) {
            //Goes from the first element to the last unsorted
            for (j = 0; j < n - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    //Swaps the values
                    T temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    swapped = true;
                }

            }
            if (swapped == false) {
                //Assumes all elements are in order
                break;
            }
        }
    }
}
