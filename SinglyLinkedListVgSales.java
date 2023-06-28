import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Comparator;

class VgSalesLinkedList<T extends Comparable<T>>{

    private Node<T> head;
    private Node<T> tail;

    static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    public VgSalesLinkedList(){
        this.head = null;
        this.tail = null;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            // The list is empty, so both head and tail will point to the new node
            head = newNode;
            tail = newNode;
        } else {
            // New node will be added at the end, so update the next reference of the current tail
            tail.setNext(newNode);
            tail = newNode; // Update the tail to the new node
        }
    }

    public void remove(T data) {
        if (head == null) {
            return;
        }

        if (head.getData().equals(data)) {
            // If the element to remove is the head, update the head
            head = head.getNext();

            if (head == null) {
                // If the list becomes empty, update the tail as well
                tail = null;
            }
            return;
        }

        Node<T> prev = head;
        Node<T> current = head.getNext();

        while (current != null) {
            if (current.getData().equals(data)) {
                // Found the element to remove, update the next reference of the previous node
                prev.setNext(current.getNext());

                if (current == tail) {
                    // If the element to remove is the tail, update the tail reference
                    tail = prev;
                }
                return;
            }

            prev = current;
            current = current.getNext();
        }
    }

    public static void main(String[] args) {
        String csvFile = "vgsales.csv"; // path to your dataset
        String line;
        Node<VgSales> head = null; // Head of the linked list
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Skip the header(Rank, Name, Year) line
            br.readLine();
            // Process the remaining lines
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(","); // Split the lines into columns with ','
                int rank = Integer.parseInt(columns[0]);
                String name = columns[1];
                String year = columns[3]; // Reasoning for this is because the dataset has N/A as some years
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

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    protected static <T> Node<T> insert(Node<T> head, T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        return newNode;
    }

    protected static <T> void bubbleSort(Node<T> head, Comparator<T> comparator) {
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

    protected static <T> Node<T> insertionSort(Node<T> head, Comparator<T> comparator) {
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

    protected static <T> Node<T> sortedInsert(Node<T> head, Node<T> newNode, Comparator<T> comparator) {
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

    protected static <T> void swapNodes(Node<T> node1, Node<T> node2) {
        T temp = node1.data;
        node1.data = node2.data;
        node2.data = temp;
    }

    protected static void printList(Node<VgSales> head) {
        if (head == null)
            return;

        printList(head.next);
        System.out.println(head.data);
    }


    private static <T> String rLinearSearch(Node<T> start, T target) {   //Recursive linear search
        if (start == null) {
            return null;
        }
        if (target == start.data)
            return start.toString();
        return rLinearSearch(start.next, target);
    }

    protected static <T> Node findMiddleNodeBinary(Node<T> start, Node<T> last) {
        if (start.data == null)
            return null;
        Node<T> slowSearch = start;         //Searches 1 node ahead
        Node<T> fastSearch = start.next;    //Searches 2 nodes ahead

        while (fastSearch != last) {
            fastSearch = fastSearch.next;
            if (fastSearch != last) {
                slowSearch = slowSearch.next;
                fastSearch = fastSearch.next;
            }
        }
        return slowSearch;
    }

    public static <T extends Comparable<T>> String rBinarySearch(Node<T> start, T target, int left, int right) {
        Node<T> middleNode = findMiddleNodeBinary(start, null);

        int middle = left + (right - left) / 2;

        if (middleNode.data.compareTo(target) == 0) {
            return middleNode.toString();   //Returns the entire node as string
        } else if (middleNode.data.compareTo(target) > 0) {
            return rBinarySearch(start, target, left, middle - 1);
        } else {
            return rBinarySearch(start, target, middle + 1, right);
        }

    }
}

