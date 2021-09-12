package academy.kovalevskyi.codingbootcamp.week1.day2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class StdString1 implements Iterable<Character> {
    private final char[] base;

    public StdString1(char[] base) {
        this.base = base.clone();
    }

    public StdString1() {
        base = new char[0];
    }

    public StdString1(StdString1 stdString1) {
        base = stdString1.toCharArray().clone();
    }

    public int length() {
        return base.length;
    }

    public StdString1 append(StdString1 that) {
        if (that == null) {
            throw new NullPointerException("Null is evil");
        }
        char[] stdArr = new char[length() + that.length()];
        for (int i = 0; i < stdArr.length; i++) {
            if (i < base.length) {
                stdArr[i] = base[i];
            } else {
                stdArr[i] = that.base[i - base.length];
            }
        }
        return new StdString1(stdArr);
    }

    public char[] toCharArray() {
        return base;
    }

    public char charAt(int index) {
        if (index > length()) {
            throw new IndexOutOfBoundsException("No");
        }
        return base[index];
    }

    public int indexOf(char target) {
        for (int i = 0; i < length(); i++) {
            if (base[i] == target) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean equals(final Object otherObj) {
        if (this == otherObj) {
            return true;
        }
        if (otherObj == null || getClass() != otherObj.getClass()) {
            return false;
        }
        StdString1 stdStr = (StdString1) otherObj;
        if (base.length != stdStr.toCharArray().length) {
            return false;
        }
        for (int i = 0; i < length(); i++) {
            if (base[i] != stdStr.toCharArray()[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for (int i = 0; i < length(); i++) {
            hash = hash + base[i];
        }
        return hash;
    }

    @Override
    public String toString() {
        return new String(base);
    }

    @Override
    public Iterator<Character> iterator() {
        return new Iterator<>() {
            int position = 0;

            @Override
            public boolean hasNext() {
                return position + 1 <= length() - 1;
            }

            @Override
            public Character next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No");
                }
                return base[position++];
            }
        };
    }

    @Override
    public void forEach(Consumer<? super Character> action) {
        for (Character t : base) {
            action.accept(t);
        }
    }
}
