public class GenBinarySearch<T extends Comparable<T>> {

    public int binarySearch(T[] arr, T target) {
        return binarySearch(arr, target, 0, arr.length - 1);
    }

    private int binarySearch(T[] arr, T target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        int cmp = target.compareTo(arr[mid]);

        if (cmp < 0) {
            return binarySearch(arr, target, left, mid - 1);
        } else if (cmp > 0) {
            return binarySearch(arr, target, mid + 1, right);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        Squirrel squirrel1 = new Squirrel(2,"Black","Compton");
        Squirrel squirrel2 = new Squirrel(5,"Brown","Bronx");
        Squirrel squirrel3 = new Squirrel(8,"White","O-Block");
        Squirrel[] squirrels = {squirrel1, squirrel2, squirrel3};
        GenBinarySearch<Squirrel> search = new GenBinarySearch<>();
        int index = search.binarySearch(squirrels, squirrel2);
        if (index != -1) {
            System.out.println("Found at index " + index);
        } else {
            System.out.println("Not found");
        }
    }
}
