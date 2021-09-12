package academy.kovalevskyi.codingbootcamp.week1.day3;

import java.util.function.Function;

public class ListHelper {

    public static <T> int length(ListNode<T> someNode) {
        if (someNode == null) {
            throw new NullPointerException();
        }
        ListNode<T> newNode = someNode;
        int count = -1;
        while (newNode != null) {
            count++;
            newNode = newNode.getNext();
        }
        newNode = someNode;
        while (newNode != null) {
            count++;
            newNode = newNode.getPrev();
        }
        return count;
    }

    public static <T> ListNode<T> addToEnd(ListNode<T> someNode, T newValue) {
        ListNode<T> endNode = new ListNode<>(runnerEnd(someNode), null, newValue);
        someNode.setNext(endNode);
        return endNode;
    }

    public static <T> ListNode<T> addToStart(ListNode<T> someNode, T newValue) {
        ListNode<T> startNode = new ListNode<>(null, runnerStart(someNode), newValue);
        someNode.setPrev(startNode);
        return startNode;
    }

    public static <T> boolean contains(ListNode<T> someNode, T value) {
        if (someNode == null) {
            throw new NullPointerException();
        }
        ListNode<T> newNode = someNode;
        while (newNode != null) {
            if (value.equals(newNode.getValue())) {
                return true;
            }
            newNode = newNode.getPrev();
        }
        newNode = someNode.getNext();
        while (newNode != null) {
            if (value.equals(newNode.getValue())) {
                return true;
            }
            newNode = newNode.getNext();
        }
        return false;
    }

    public static <T, R> ListNode<R> map(ListNode<T> someNode, Function<T, R> mapFunction) {
        ListNode<T> startNode = runnerStart(someNode);
        ListNode<R> newNode = new ListNode<>(null, null, mapFunction.apply(startNode.getValue()));
        while (startNode.getNext() != null) {
            newNode = addToEnd(newNode, mapFunction.apply(startNode.getValue()));
            startNode = startNode.getNext();
        }
        return newNode;
    }

    public static <T> ListNode<T> runnerStart(ListNode<T> someNode) {
        ListNode<T> rsl = someNode;
        while (rsl.getPrev() != null) {
            rsl = rsl.getPrev();
        }
        return rsl;
    }

    public static <T> ListNode<T> runnerEnd(ListNode<T> someNode) {
        ListNode<T> rsl = someNode;
        while (rsl.getNext() != null) {
            rsl = rsl.getNext();
        }
        return rsl;
    }


    public static <T> ListNode<T> insertAfter(ListNode<T> prev, T newValue) {
        ListNode<T> newNode = new ListNode<T>(prev, prev.getNext(), newValue);
        prev.setNext(newNode);
        if (prev.getNext() != null) {
            prev.getNext().setPrev(newNode);
        }
        return newNode;
    }

    public static <T> void insertAfter(ListNode<T> prev, T[] newValues) {
        for (T t : newValues) {
            prev = insertAfter(prev, t);
        }
    }

    public static <T> T delete(ListNode<T> current) {
        final T value = current.getValue();
        ListNode<T> delStartNode = current.getPrev();
        ListNode<T> delEndNode = current.getNext();
        current.setPrev(null);
        current.setNext(null);
        if (delStartNode != null) {
            delStartNode.setNext(delEndNode);
        }
        if (delEndNode != null) {
            delEndNode.setPrev(delStartNode);
        }
        return value;
    }
}
