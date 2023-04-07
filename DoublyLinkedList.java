public class DoublyLinkedList implements iPoliceCollection {
    private Node head;
    private Node tail;
    private int size;


    public DoublyLinkedList() {
        this.head = null;
        this.size = 0;
        this.tail = null;
    }

    public void addNode(Node node) {
        if (head == null) {
            head = node;
            tail = node;
            head.setPrev(null);
            tail.setNext(null);
        } else {
            //Attaches a tail
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
            tail.setNext(null);
        }
        size++;
    }


    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Comparable fetchAtIndex(int index) {

        return null;
    }

    @Override
    public void swapEl(int indexOne, int indexTwo) {

    }
}
