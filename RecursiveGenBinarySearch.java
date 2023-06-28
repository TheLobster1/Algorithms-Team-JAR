public class RecursiveGenBinarySearch<T extends Comparable<? super T>> {
    //The lower bound is T and the ? super tells it to otherwise use a superclass

    private int lowerB;
    private int upperB;
    private int middleOfBounds;
    private T target;

    public RecursiveGenBinarySearch(T target) {
        this.lowerB = 0;
        this.upperB = 0;
        this.middleOfBounds = 0;
        this.target = target;
    }

    public <T extends iPoliceCollection> void genBinarySearch(T collection, T target) {
        this.upperB = collection.size() - 1;

        binarySearch(collection, target, this.lowerB, this.upperB);

    }

    private <T extends iPoliceCollection> int binarySearch(T collection, T target, int lowerB, int upperB) {
        this.middleOfBounds = Math.round((this.lowerB / 2) + (this.upperB / 2));  //Index of centre

        if (this.lowerB < this.upperB) {
            int comp = collection.fetchAtIndex(this.middleOfBounds).compareTo(this.target);
            //If middle is the target
            if (collection.fetchAtIndex(this.middleOfBounds) == this.target) {
                return this.middleOfBounds;
            } else if (comp > 0) {  //If the target is higher than the middle
                return binarySearch(collection, target, this.middleOfBounds + 1, this.upperB);
            } else if (comp < 0) {
                return binarySearch(collection, target, this.lowerB, this.middleOfBounds - 1);
            }


        }
        //Number not in the collection
        return -1;
    }
}
