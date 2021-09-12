package academy.kovalevskyi.codingbootcamp.week1.day3;

public class ListNode<T> {
    private ListNode<T> prev;
    private ListNode<T> next;
    private T value;

    public ListNode(ListNode<T> prev, ListNode<T> next, T value) {
        this.prev = prev;
        this.next = next;
        this.value = value;
    }

    public ListNode<T> getPrev() {
        return prev;
    }

    public void setPrev(ListNode<T> prev) {
        this.prev = prev;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        T prevValue = (prev == null) ? null : prev.getValue();
        T nextValue = (next == null) ? null : next.getValue();
        return "ListNode{"
                + "prevValue="
                + prevValue
                + ", nextValue="
                + nextValue
                + ", thisValue="
                + this.value
                + '}';
    }

}
