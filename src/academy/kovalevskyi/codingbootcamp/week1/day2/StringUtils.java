package academy.kovalevskyi.codingbootcamp.week1.day2;

public class StringUtils {

    private static void checkExc(char ch) {
        if (ch > 255) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean isAsciiUppercase(char ch) {
        checkExc(ch);
        return ch >= 'A' && ch <= 'Z';
    }

    public static boolean isAsciiLowercase(char ch) {
        checkExc(ch);
        return ch >= 'a' && ch <= 'z';
    }

    public static boolean isAsciiNumeric(char ch) {
        checkExc(ch);
        return ch >= '0' && ch <= '9';
    }

    public static boolean isAsciiAlphabetic(char ch) {
        return isAsciiUppercase(ch) || isAsciiLowercase(ch);
    }

    public static char toAsciiUppercase(char ch) {
        if (isAsciiLowercase(ch)) {
            ch -= 32;
        }
        return ch;
    }

    public static char toAsciiLowercase(char ch) {
        if (isAsciiUppercase(ch)) {
            ch += 32;
        }
        return ch;
    }

    public static StringBuilder makeUppercase(char[] input) {
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            stb.append(toAsciiUppercase(input[i]));
        }
        return stb;
    }

    public static StringBuilder makeLowercase(char[] input) {
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            stb.append(toAsciiLowercase(input[i]));
        }
        return stb;
    }

    public static StringBuilder makeCamel(char[] input) {
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            if (i % 2 == 0) {
                stb.append(toAsciiLowercase(input[i]));
            } else {
                stb.append(toAsciiUppercase(input[i]));
            }
        }
        return stb;
    }

    public static boolean isStringAlphaNumerical(char[] input) {
        for (int i = 0; i < input.length; i++) {
            if (!(isAsciiAlphabetic(input[i])
                    | (isAsciiNumeric(input[i]))
                    | (input[i] == ' '))) {
                return false;
            }
        }
        return true;
    }

    public static char[] concatStrings(char[][] input) {
        if (input.length == 0) {
            return new char[]{};
        }
        int counter = 0;
        char[] stuArr = new char[input.length * input[0].length];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                stuArr[counter++] = input[i][j];
            }
        }
        return stuArr;
    }

    public static int toInt(char[] input) {
        if (input.length == 0) {
            throw new IllegalArgumentException();
        }
        boolean negative = false;
        if (input[0] == '-') {
            input[0] = '0';
            negative = true;
        }
        int ch = 0;
        for (int i = 0; i < input.length; i++) {
            if (isAsciiNumeric(input[i])) {
                ch = ch * 10 + Character.digit(input[i], 10);
            } else {
                throw new NumberFormatException();
            }
        }
        return negative ? - ch : ch;
    }
}
