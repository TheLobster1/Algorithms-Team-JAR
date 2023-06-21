import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Comparator;

class VgSalesLinkedList {
    static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        String csvFile = "vgsales.csv"; // path to your dataset
        String line;
        Node<VgSales> head = null; // Head of the linked list

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(","); // Split the lines into columns with ,
                String rank = columns[0];
                String name = columns[1];
                String year = columns[3];
                VgSales vgSales = new VgSales(rank, name, year);
                head = insert(head, vgSales);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Original List:\n");
        printList(head);

        System.out.println("\n\nBubble Sort by Rank:\n");
        bubbleSort(head, Comparator.comparing(VgSales::getRank));
        printList(head);

        System.out.println("\n\nBubble Sort by Name:\n");
        bubbleSort(head, Comparator.comparing(VgSales::getName));
        printList(head);

        System.out.println("\n\nBubble Sort by Year:\n");
        bubbleSort(head, Comparator.comparing(VgSales::getYear));
        printList(head);

        System.out.println("\n\nInsertion Sort by Rank:\n");
        head = insertionSort(head, Comparator.comparing(VgSales::getRank));
        printList(head);

        System.out.println("\n\nInsertion Sort by Name:\n");
        head = insertionSort(head, Comparator.comparing(VgSales::getName));
        printList(head);

        System.out.println("\n\nInsertion Sort by Year:\n");
        head = insertionSort(head, Comparator.comparing(VgSales::getYear));
        printList(head);
    }

    public static <T> Node<T> insert(Node<T> head, T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        return newNode;
    }

    public static <T> void bubbleSort(Node<T> head, Comparator<T> comparator) {
        if (head == null || head.next == null)
            return;

        boolean swapped;
        Node<T> current;
        Node<T> last = null;

        do {
            swapped = false;
            current = head;

            while (current.next != last) {
                if (comparator.compare(current.data, current.next.data) > 0) {
                    swapNodes(current, current.next);
                    swapped = true;
                }
                current = current.next;
            }
            last = current;
        } while (swapped);
    }

    public static <T> Node<T> insertionSort(Node<T> head, Comparator<T> comparator) {
        if (head == null || head.next == null)
            return head;

        Node<T> sorted = null;
        Node<T> current = head;

        while (current != null) {
            Node<T> next = current.next;
            sorted = sortedInsert(sorted, current, comparator);
            current = next;
        }

        return sorted;
    }

    public static <T> Node<T> sortedInsert(Node<T> head, Node<T> newNode, Comparator<T> comparator) {
        if (head == null || comparator.compare(newNode.data, head.data) < 0) {
            newNode.next = head;
            return newNode;
        }

        Node<T> current = head;

        while (current.next != null && comparator.compare(current.next.data, newNode.data) < 0) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;

        return head;
    }

    public static <T> void swapNodes(Node<T> node1, Node<T> node2) {
        T temp = node1.data;
        node1.data = node2.data;
        node2.data = temp;
    }

    public static void printList(Node<VgSales> head) {
        if (head == null)
            return;

        printList(head.next);
        System.out.println(head.data);
    }


    public static <T> String RLinearSearch(Node<T> start, T target) {
        try {
            if (start == null) {
                throw new NullPointerException();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (target == start.data)
            return start.toString();
        return RLinearSearch(start.next, target);
    }

}