package academy.kovalevskyi.codingbootcamp.week1.day0;

public class NumberUtils {

    public static int getFactorial(final int number) {
        if (number < 0) {
            throw new IllegalArgumentException("bad");
        }
        if (number == 0 || number == 1) {
            return 1;
        }
        int factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }

    public static int factorialRecursive(int number) {
        if (number == 1 || number == 0) {
            return 1;
        } else if (number < 0) {
            throw new IllegalArgumentException("bad");
        }
        return number * factorialRecursive(number - 1);
    }

    public static long power(int base, int power) {
        if (power < 0) {
            throw new IllegalArgumentException("bad");
        }
        long rsl = 1;
        for (int i = 1; i <= power; i++) {
            rsl = (long) (rsl * base);
        }
        return rsl;
    }

    public static int powerRecursive(int base, int power) {
        if (power < 0) {
            throw new IllegalArgumentException("bad");
        }
        if (power == 0) {
            return 1;
        }
        return base * powerRecursive(base, power - 1);
    }

    public static int fibRecursive(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("bad job, boy");
        } else if (index <= 1) {
            return index;
        }
        return fibRecursive(index - 1) + fibRecursive(index - 2);
    }

    public static int[] fibSequence(int length) {
        if (length < 0) {
            throw new IllegalArgumentException("bad");
        }
        int[] arr = new int[length];
        while (length > 0) {
            arr[length - 1] = fibRecursive(length--);
        }
        return arr;
    }

    public static int sqrt(int target) {
        if (target < 0) {
            throw new IllegalArgumentException("bad");
        }
        int leftBoard = 0;
        int rightBoard = target;
        int auxVerib = target;
        int midlElem = (leftBoard + rightBoard) / 2;
        for (;;) {
            midlElem = (leftBoard + rightBoard) / 2;
            if (midlElem * midlElem == target || midlElem == auxVerib) {
                break;
            } else if (midlElem * midlElem < target) {
                leftBoard = midlElem;
            } else if (midlElem * midlElem > target) {
                rightBoard = midlElem;
            }
            auxVerib = midlElem;
        }
        if (target != midlElem * midlElem) {
            return -1;
        }
        return midlElem;
    }

    public static boolean isPrime(int target) {
        if (target < 0) {
            throw new IllegalArgumentException("bad");
        } else if (target == 0 || target == 1) {
            return false;
        }
        boolean prime = true;
        for (int i = 2; i <= target / 2; i++) {
            if (target % i == 0) {
                return false;
            }
        }
        if (prime) {
            return true;
        } else {
            return false;
        }
    }

    public static int findNextPrime(int target) {
        if (target < 0) {
            throw new IllegalArgumentException("bad");
        }
        for (int i = target;; i++) {
            if (isPrime(i)) {
                return i;
            }
        }
    }

    public static void sort(int[] target) {
        if (target == null) {
            return;
        }
        for (int i = target.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (target[j] > target[j + 1]) {
                    int temp = target[j];
                    target[j] = target[j + 1];
                    target[j + 1] = temp;
                }
            }
        }
    }
}
