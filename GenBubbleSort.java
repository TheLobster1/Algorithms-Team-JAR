public class GenBubbleSort<T extends Comparable<? super T>> {
    private int i;
    private int n;
    private int j;
    private boolean swapped;

    public GenBubbleSort() {
        this.n = 0;
        this.i = 0;
        this.j = 0;
        this.swapped = false;
    }

    //Given a collection it returns said collection sorted
    public <T extends iPoliceCollection> T bubbleSort(T collection) {
        int size = collection.size();

        //Runs till the 2nd last element because the last element should be sorted
        for (i = 0; i < n - 1; i++) {
            //Goes from the first element to the last unsorted
            for (j = 0; j < n - i - 1; j++) {
                if (collection.fetchAtIndex(j).compareTo(collection.fetchAtIndex(j + 1)) > 0) {
                    //Swaps the values
                    collection.swapEl(j, j + 1);
                    this.swapped = true;
                }

            }
            if (this.swapped == false) {
                //Assumes all elements are in order, prevents wasted Process time
                break;
            }
        }
        //returns the sorted collection in theory
        return collection;
    }
}
