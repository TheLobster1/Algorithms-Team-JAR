public interface iPoliceCollection<T extends Comparable<T>> {
    int size();

    T fetchAtIndex(int index);

    void swapEl(int indexOne, int indexTwo);
}
