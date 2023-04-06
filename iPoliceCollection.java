public interface iPoliceCollection<T extends Comparable<T>> {
    int size();

    T findIndex(int index);

    void swapEl(int indexOne, int indexTwo);
}
