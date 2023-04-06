public class GenBinarySearch<T extends Comparable<? super T>> {
    //The lower bound is T and the ? super tells it to otherwise use a superclass

    private int lowerB;
    private int upperB;
    private int middleOfBounds;
    private T target;

    public GenBinarySearch(T target) {
        this.lowerB = 0;
        this.upperB = 0;
        this.middleOfBounds = 0;
        this.target = target;
    }

    public void genBinarySearch(T[] sortedArr, int target) {
        this.upperB = sortedArr.length - 1;
        binarySearch(sortedArr, this.target, this.lowerB, this.upperB);
    }

    private T binarySearch(T[] sortedArr, T target, int lowerB, int upperB) {
        if() {
            this.middleOfBounds = (Math.round((this.upperB - this.lowerB) / 2));
            if (this.target == sortedArr[middleOfBounds]) {
                return sortedArr[middleOfBounds];
            }
        }
    }
}
