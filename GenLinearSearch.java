import java.util.ArrayList;
import java.util.List;

class LinearSearch<T> {

    private List<T> list;

    public LinearSearch(List<T> list) {
        this.list = list;
    }

    public int search(T key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(key)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
