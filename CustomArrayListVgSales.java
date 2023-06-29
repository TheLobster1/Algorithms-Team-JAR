import java.util.Comparator;

public class CustomArrayListVgSales<T> {
    private static final int initalCap = 10;
    private Object[] elements;
    private int size;

    public CustomArrayListVgSales() {
        this.elements = new Object[initalCap];
        this.size = 0;
    }

    protected T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) elements[index];
    }

    protected void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        elements[index] = element;
    }

    protected void add(T element) {
        if (size == elements.length) {
            increaseCapacity();
        }
        elements[size++] = element;
    }

    protected void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.elements[--size] = null;
    }

    protected int size() {
        return size;
    }

    protected void increaseCapacity() {
        int newCapacity = elements.length * 2;
        Object[] newElements = new Object[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }


    public <T> void bubbleSort(CustomArrayListVgSales<T> list, Comparator<T> comparator) {
        int len = list.size();
        while (len > 1) {
            boolean swapped = false;
            for (int x = 0; x < len - 1; x++) {
                if (comparator.compare(list.get(x), list.get(x + 1)) > 0) {
                    T bubbleSortKey = list.get(x);
                    list.set(x, list.get(x + 1));
                    list.set(x + 1, bubbleSortKey);
                    swapped = true;
                }
            }
            if (!swapped) {
                break; // Optimization: If no swaps occurred in the inner loop, the list is already sorted
            }
            len--;
        }
    }

    public static <T> void insertionSort(CustomArrayListVgSales<T> list, Comparator<T> comparator) {
        int len = list.size();
        for (int x = 1; x < len; x++) {
            T insertionSortKey = list.get(x);
            int y = x - 1;
            while (y >= 0 && comparator.compare(list.get(y), insertionSortKey) > 0) {
                list.set(y + 1, list.get(y));
                y--;
            }
            list.set(y + 1, insertionSortKey);
        }
    }

    public static <T> String rLinearSearch(int size, CustomArrayListVgSales<T> list, T target) {
        if (list.size() == 0) {
            return null;
        }
        if (list.get(size - 1) == target) {
            return list.get(size - 1).toString();
        }
        return rLinearSearch(size - 1, list, target);
    }

    public static <T extends Comparable> String rBinarySearch(CustomArrayListVgSales<T> list, int initial, int end, T target) {
        if (initial > end) {
            return null;
        }
        int middle = (initial + end) / 2;
        T centre = list.get(middle);
        if (centre.compareTo(target) == 0) {
            return centre.toString();
        } else if (centre.compareTo(target) > 0) {
            return rBinarySearch(list, initial, middle - 1, target);
        }
        return null;
    }

    public Object[] getElements() {
        return elements;
    }

    public int getSize() {
        return size;
    }
}