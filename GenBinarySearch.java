import java.util.ArrayList;

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
        ArrayList<Squirrel> squirrelData = new ArrayList<>();
        for(Squirrel squirrel: squirrelData) {
            Squirrel squirrels = squirrel;
            GenBinarySearch<Squirrel> search = new GenBinarySearch<>();
            int index = search.binarySearch(squirrels,squirrelData[1]);
            if (index != -1) {
                System.out.println("Found at index " + index);
            } else {
                System.out.println("Not found");
            }
        }
    }
}
