public class LinkedList<T> {
    private ListNode<T> head;

    LinkedList() {

    }

    void sort() {
        boolean skip = true;
        ListNode<T> curr = head;
        ListNode<T> prev = null;
        while (curr != null) {
            ListNode<T> next = curr.getNext();
            if (skip) {
                if (curr.getNext() != null) {
                    if (curr.getNext().getNext() != null) {
                        curr.setNext(curr.getNext().getNext());
                    }
                }
                else {
                    curr.setNext(prev);
                }
            }
            else {
                curr.setNext(prev);
                prev = curr;
            }
            curr = next;
            skip = !skip;
        }
    }

    void print() {
        ListNode<T> curr = head;
        while (curr != null) {
            System.out.print(curr.getElement() + " -> ");
            curr = curr.getNext();
        }
        System.out.println("null");
    }      

    void add(T element) {
        if (head == null) {
            head = new ListNode<T>(element, null);
        }
        else {
            ListNode<T> curr = head;
            while (curr.getNext() != null) {
                curr = curr.getNext();
            }
            curr.setNext(new ListNode<T>(element, null));
        }
    }
}

class ListNode<T> {
    private T element;
    private ListNode<T> next;

    ListNode(T element, ListNode<T> next) {
        this.element = element;
        this.next = next;
    }

    T getElement() {
        return element;
    }

    ListNode<T> getNext() {
        return next;
    }

    void setNext(ListNode<T> next) {
        this.next = next;
    }
}
