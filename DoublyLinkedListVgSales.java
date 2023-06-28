public class DoublyLinkedListVgSales<T> {
    private Node<T> head;
    private Node<T> tail;
    static class Node<T> {
        public T data;
        private Node<T> prev;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
    public DoublyLinkedListVgSales() {
        this.head = null;
        this.tail = null;
    }
    public void addFront(T data) {
        Node<T> node = new Node<>(data);
        if(head == null) {
            head = node;
            tail = node;
        }
        else {
            node.setNext(head);
            head.setPrev(node);
            head = node;
        }
    }

    public void addEnd(T data) {
        Node<T> node = new Node<>(data);
        if(head == null) {
            head = node;
        }
        else {
            tail.setNext(node);
            node.setPrev(tail);
        }
        tail = node;
    }

    public void remove(T data) {
        Node<T> current = head;
        while (current != null) { //while there is a node to work with
            if (current.getData().equals(data)) {
                if(current.getPrev() == null) {
                    head = current.getNext();
                }
                else {
                    current.getPrev().setNext(current.getNext());
                }
                if(current.getNext() == null) {
                    tail = current.getPrev();
                }
                else {
                    current.getNext().setPrev(current.getPrev());
                }
                return;
            }
            current = current.getNext();
        }
    }
}
