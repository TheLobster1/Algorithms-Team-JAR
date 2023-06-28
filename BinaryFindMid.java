public class BinaryFindMid {
    protected static <T> VgSalesLinkedList.Node findMiddleNodeBinary(VgSalesLinkedList.Node<T> start, VgSalesLinkedList.Node<T> last) {
        if (start.data == null)
            return null;
        VgSalesLinkedList.Node<T> slowSearch = start;         //Searches 1 node ahead
        VgSalesLinkedList.Node<T> fastSearch = start.next;    //Searches 2 nodes ahead

        while (fastSearch != last) {
            fastSearch = fastSearch.next;
            if (fastSearch != last) {
                slowSearch = slowSearch.next;
                fastSearch = fastSearch.next;
            }
        }
        return slowSearch;
    }
}
