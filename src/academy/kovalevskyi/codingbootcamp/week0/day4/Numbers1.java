package academy.kovalevskyi.codingbootcamp.week0.day4;

public class Numbers1 {

    public static int[] generateNumbers() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        return array;
    }

    public static int findBiggest(int left, int right) {
        if (left > right) {
            return left;
        } else if (left < right) {
            return right;
        } else {
            return left;
        }
    }

    public static int findBiggest(int left, int mid, int right) {
        return findBiggest(findBiggest(left, right), mid);
    }

    public static int findBiggest(int[] numbers) {
        int max = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (max < numbers[i]) {
                max = numbers[i];
            }
        }
        return max;
    }

    public static int findIndexOfBiggestNumber(int[] numbers) {
        int maxIndex = 0;
        int maxValue = numbers[maxIndex];
        for (int i = 0; i < numbers.length; i++) {
            if (maxValue < numbers[i]) {
                maxValue = numbers[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static boolean isNegative(int number) {
        return number < 0;
    }

    public static char[] convertToCharArray(int number) {
        int count = 0;
        int posit = 0;
        int dublicate = number;
        boolean isNegatNum = isNegative(number);
        if (number == 0) {
            return new char[]{'0'};
        }
        if (isNegatNum) {
            count++;
            number = -number;
        }
        while (dublicate != 0) {
            dublicate /= 10;
            count++;
        }
        char[] arrChar = new char[count];
        for (int i = 0; i < arrChar.length; i++) {
            posit = number % 10;
            number /= 10;
            arrChar[count - 1 - i] = (char) (posit + 48);
        }
        if (isNegatNum) {
            arrChar[0] = '-';
        }
        return arrChar;
    }
}
