package academy.kovalevskyi.codingbootcamp.week2.day0;

import academy.kovalevskyi.codingbootcamp.week0.day4.Numbers1;
import academy.kovalevskyi.codingbootcamp.week1.day0.NumberUtils;
import academy.kovalevskyi.codingbootcamp.week1.day2.StringUtils;


public class Numbers2 extends Numbers1 {

    public static char[][] generateTriplets() {
        int possNumbers = 10;
        int combNumbers = 3;
        int index = 0;
        int amountOfNumbers = NumberUtils.factorialRecursive(possNumbers) / (
                NumberUtils.factorialRecursive(possNumbers - combNumbers) * NumberUtils.factorialRecursive(combNumbers));
        char[][] arr = new char[amountOfNumbers][combNumbers];
        for (int j = 0; j < 10; j++) {
            for (int k = 0; k < 10; k++) {
                for (int l = 0; l < 10; l++) {
                    if (j < k && k < l) {
                        char[] chArr = {(char) (j + 48), (char) (k + 48), (char) (l + 48)};
                        arr[index++] = chArr;
                    }
                }
            }
        }
        return arr;
    }

    public static char[][] generateTuples() {
        int possNumbers = 10;
        int combNumbers = 4;
        char[][] arrWithoutSpace = generateTuples(combNumbers);
        char[][] rsl = new char[arrWithoutSpace.length][combNumbers + 1];
        int amountOfNumbers = NumberUtils.powerRecursive(possNumbers, combNumbers - 1);
        for (int i = 0; i < arrWithoutSpace.length; i++) {
            for (int j = 0; j < combNumbers + 1; j++) {
                if (j < 2) {
                    rsl[i][j] = arrWithoutSpace[i][j];
                } else if (j == 2) {
                    rsl[i][j] = ' ';
                } else if (j > 2) {
                    rsl[i][j] = arrWithoutSpace[i][j - 1];
                }
            }
        }
        return rsl;
    }

    public static char[][] generateTuples(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("generateTuples(<0)");
        }
        if (amount == 0) {
            return new char[0][0];
        }
        char[][] res = new char[razmesheniya(10, amount)][amount];
        // previousArr заполняем первый элемент руками нулями
        char[] previousArr = new char[amount];
        for (int i = 0; i < amount; i++) {
            previousArr[i] = '0';
        }
        res[0] = previousArr;
        for (int i = 1; i < razmesheniya(10, amount); i++) {
            res[i] = getNextArr(previousArr);
            previousArr = res[i];
        }
        return res;
    }

    public static char[] appendChar(char[] arr, char ch) {
        char[] res = new char[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        res[res.length - 1] = ch;
        return res;
    }

    public static char[] getNextArr(char[] arr) {
        int prevInt = StringUtils.toInt(arr);
        int resInt = prevInt + 1;
        char[] res = new char[0];
        //countFirstZero - колличество нулей вначале массива, если resInt<100
        int countFirstZero = arr.length - convertToCharArray(resInt).length;
        for (int i = 0; i < countFirstZero; i++) {
            char zero = '0';
            res = appendChar(res, zero);
        }
        for (char ch : convertToCharArray(resInt)) {
            res = appendChar(res, ch);
        }
        //System.out.printf("getNextArr| res:%s%n", Arrays.toString(res));
        return res;
    }

    public static int razmesheniya(int n, int m) {
        return (int) NumberUtils.power(n, m);
    }
}
