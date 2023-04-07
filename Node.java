public class Node {
    private Squirrel squirrel;
    private Node next;
    private Node prev;

    public Node(Squirrel squirrel) {
        this.squirrel = squirrel;
        this.next = null;
    }

    public void setSquirrel(Squirrel squirrel) {
        this.squirrel = squirrel;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Squirrel getSquirrel() {
        return squirrel;
    }

    public Node getNext() {
        return next;
    }
}
