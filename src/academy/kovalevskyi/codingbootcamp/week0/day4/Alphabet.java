package academy.kovalevskyi.codingbootcamp.week0.day4;

public class Alphabet {

    public static char[] generateAlphabet() {
        char[] alpha = new char[26];
        for (int i = 0; i < alpha.length; i++) {
            alpha[i] = (char) ('a' + i);
        }
        return alpha;
    }

    public static char[] generateReversedAlphabet() {
        char[] alpha = new char[26];
        for (int i = alpha.length - 1; i >= 0; i--) {
            alpha[i] = (char) ('z' - i);
        }
        return alpha;
    }
}
