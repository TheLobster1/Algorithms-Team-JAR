import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Comparator;

public class ArrayListVgSales {

    public static void main(String[] args) {

        String csvFile = "vgsales.csv"; // path to your dataset
        String line;
        CustomArrayListVgSales<VgSales> vgsales = new CustomArrayListVgSales<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Skip the header(Rank, Name, Year) line
            br.readLine();
            // Process the remaining lines
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(","); // Split the lines into columns with ','
                int rank = Integer.parseInt(columns[0]);
                String name = columns[1];
                String year = columns[3];
                VgSales vgsale = new VgSales(rank, name, year);
                vgsales.add(vgsale);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Original List:\n");
        for (int i = 0; i < vgsales.size(); i++) {
            VgSales vgsale = vgsales.get(i);
            System.out.println(vgsale.getRank() + "\t\t " + vgsale.getName() + "\t\t " + vgsale.getYear());
        }

        System.out.println("\n\nBubble Sort by Rank:\n");
        bubbleSort(vgsales, Comparator.comparing(VgSales::getRank));
        for (int i = 0; i < vgsales.size(); i++) {
            VgSales vgsale = vgsales.get(i);
            System.out.println(vgsale.getRank() + "\t\t " + vgsale.getName() + "\t\t " + vgsale.getYear());
        }

        System.out.println("\n\nBubble Sort by Name:\n");
        bubbleSort(vgsales, Comparator.comparing(VgSales::getName));
        for (int i = 0; i < vgsales.size(); i++) {
            VgSales vgsale = vgsales.get(i);
            System.out.println(vgsale.getRank() + "\t\t " + vgsale.getName() + "\t\t " + vgsale.getYear());
        }

        System.out.println("\n\nBubble Sort by Year:\n");
        bubbleSort(vgsales, Comparator.comparing(VgSales::getYear));
        for (int i = 0; i < vgsales.size(); i++) {
            VgSales vgsale = vgsales.get(i);
            System.out.println(vgsale.getRank() + "\t\t " + vgsale.getName() + "\t\t " + vgsale.getYear());
        }

        System.out.println("\n\nInsertion Sort by Rank:\n");
        insertionSort(vgsales, Comparator.comparing(VgSales::getRank));
        for (int i = 0; i < vgsales.size(); i++) {
            VgSales vgsale = vgsales.get(i);
            System.out.println(vgsale.getRank() + "\t\t " + vgsale.getName() + "\t\t " + vgsale.getYear());
        }

        System.out.println("\n\nInsertion Sort by Name:\n");
        insertionSort(vgsales, Comparator.comparing(VgSales::getName));
        for (int i = 0; i < vgsales.size(); i++) {
            VgSales vgsale = vgsales.get(i);
            System.out.println(vgsale.getRank() + "\t\t " + vgsale.getName() + "\t\t " + vgsale.getYear());
        }

        System.out.println("\n\nInsertion Sort by Year:\n");
        insertionSort(vgsales, Comparator.comparing(VgSales::getYear));
        for (int i = 0; i < vgsales.size(); i++) {
            VgSales vgsale = vgsales.get(i);
            System.out.println(vgsale.getRank() + "\t\t " + vgsale.getName() + "\t\t " + vgsale.getYear());
        }
    }

    public static <T> void bubbleSort(CustomArrayListVgSales<T> list, Comparator<T> comparator) {
        bubbleSortRecursive(list, list.size(), comparator);
    }

    private static <T> void bubbleSortRecursive(CustomArrayListVgSales<T> list, int len, Comparator<T> comparator) {
        if (len == 1) {
            return;
        }

        for (int x = 0; x < len - 1; x++) {
            if (comparator.compare(list.get(x), list.get(x + 1)) > 0) {
                T bubbleSortKey = list.get(x);
                list.set(x, list.get(x + 1));
                list.set(x + 1, bubbleSortKey);
            }
        }

        bubbleSortRecursive(list, len - 1, comparator);
    }

    //Unable to make it recursive because for some reason it just crashes and gives StackOverflowError
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

}
