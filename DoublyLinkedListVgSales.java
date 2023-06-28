public class DoublyLinkedListVgSales<T extends Comparable<T>> {
    private Node<T> head;
    private Node<T> tail;

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

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
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.setNext(head);
            head.setPrev(node);
            head = node;
        }
    }

    public void addEnd(T data) {
        Node<T> node = new Node<>(data);
        if (head == null) {
            head = node;
        } else {
            tail.setNext(node);
            node.setPrev(tail);
        }
        tail = node;
    }

    public void remove(T data) {
        Node<T> current = head;
        while (current != null) { //while there is a node to work with
            if (current.getData().equals(data)) {
                if (current.getPrev() == null) {
                    head = current.getNext();
                } else {
                    current.getPrev().setNext(current.getNext());
                }
                if (current.getNext() == null) {
                    tail = current.getPrev();
                } else {
                    current.getNext().setPrev(current.getPrev());
                }
                return;
            }
            current = current.getNext();
        }
    }

    private void swapNodes(Node<T> node1, Node<T> node2) {
        T tempData = node1.getData();
        node1.setData(node2.getData());
        node2.setData(tempData);
    }

    public void bubbleSort() {
        if (head == null || head.getNext() == null) {
            return; //can't be sorted
        }
        boolean hasSwapped;
        Node<T> current;
        Node<T> tail = null;

        do {
            hasSwapped = false;
            current = head;
            while (current.getNext() != tail) {
                if (current.getData().compareTo(current.getNext().getData()) > 0) {
                    swapNodes(current, current.getNext());
                    hasSwapped = true;
                }
                current = current.getNext();
            }
            tail = current;
        } while (hasSwapped);
    }

    private Node<T> getInsertionPosition(Node<T> node) {
        Node<T> insertionPosition = head;
        while (insertionPosition != null && node.getData().compareTo(insertionPosition.getData()) >= 0) {
            insertionPosition = insertionPosition.getNext();
        }
        return insertionPosition != null ? insertionPosition.getPrev() : tail;
    }

    private void moveNodeToPosition(Node<T> node, Node<T> position) {
        if (node == position) {
            return;
        }
        if (node == head) {
            head = head.getNext();
        } else {
            node.getPrev().setNext(node.getNext());
        }
        if (node == tail) {
            tail = tail.getPrev();
        } else {
            node.getNext().setPrev(node.getPrev());
        }
        if (position == null) {
            tail.setNext(node);
            node.setPrev(tail);
            node.setNext(null);
            tail = node;
        } else {
            node.setPrev(position.getPrev());
            node.setNext(position);
            if (position.getPrev() != null) {
                position.getPrev().setNext(node);
            } else {
                head = node;
            }
            position.setPrev(node);
        }
    }

    public void insertionSort() {
        if (head == null || head.getNext() == null) {
            return;
        }
        Node<T> newTail = head;
        Node<T> current = head.getNext();

        while (current != null) {
            Node<T> insertionPosition = getInsertionPosition(current);
            if (insertionPosition != current) {
                Node<T> temp = current;
                current = current.getNext();
                moveNodeToPosition(temp, insertionPosition);
            } else {
                current = current.getNext();
                newTail = newTail.getNext();
            }
        }
    }

    public Node<T> linearSearch(T data) {
        if (head == null) {
            return null;
        }
        if (data == null) {
            return null;
        }
        Node<T> current = head;
        while (current != null) {
            if (current.getData().equals(data)) {
                return current;
            } else {
                current = current.getNext();
            }
        }
        return null;
    }

    public static <T> String rLinearSearch(Node<T> start, T target) {   //Recursive linear search
        if (start == null) {
            return null;
        }
        if (target == start.data)
            return start.toString();
        return rLinearSearch(start.next, target);
    }

    protected static <T> Node<T> findMidDoubleNodeBinary(Node<T> start, Node<T> last) {
        if (start.data == null) {
            return null;
        }
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

    public <T extends Comparable<T>> String rBinarySearch(Node<T> start, T target, int left, int right) {

        /*Sorry my lord, I have forsaken you. My methods are cruel and savage however this (getTail()) would not function
         * without my interference into the matter. I have tried searching the 7 realms for why this had to happen... I am yet to find that out.
         * My guess is that the tail has had an identity crisis midway and couldn't figure itself out.*/

        Node<T> middleNode = findMidDoubleNodeBinary(start, (Node<T>) getTail());

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
