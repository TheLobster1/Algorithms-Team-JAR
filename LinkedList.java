public class LinkedList implements iPoliceCollection {
    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }
    public void addNode(Node node) {
        if(head == null) {
            head = node;
        }
        else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(node);
        }
        size++;
    }

    public void removeNode(Node node) {
        if(head != null) {
            Node currentNode = head;
            Node previousNode = null;
            if(head == node && head.getNext() != null) {
                head = head.getNext();
            }
            else if(head.getNext() == null) {
                head = null;
            }
            while (currentNode.getNext() != null) {
                previousNode = currentNode;
                currentNode = currentNode.getNext();
                if(currentNode == node) {
                    previousNode.setNext(currentNode.getNext());
                    return;
                }
            }
            //does not exist
        }

    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Comparable findIndex(int index) {
        return null;
    }

    @Override
    public void swapEl(int indexOne, int indexTwo) {

    }
}
