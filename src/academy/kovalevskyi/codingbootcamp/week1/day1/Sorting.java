package academy.kovalevskyi.codingbootcamp.week1.day1;

import java.util.Comparator;

public class Sorting {

    public static <T> void sort(T[] target, Comparator<T> comparator) {
        checkValid(target, comparator);
        for (int i = target.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (comparator.compare(target[j], target[j + 1]) > 0) {
                    T temp = target[j];
                    target[j] = target[j + 1];
                    target[j + 1] = temp;
                }
            }
        }
    }

    public static <T> void sortReversedOrder(T[] target, Comparator<T> comparator) {
        checkValid(target, comparator);
        sort(target, comparator.reversed());
    }

    private static <T> void checkValid(T[] target, Comparator<T> comparator) {
        if (target == null || comparator == null) {
            throw new NullPointerException("bad");
        }
    }
}
