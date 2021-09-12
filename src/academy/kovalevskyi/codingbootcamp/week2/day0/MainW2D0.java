package academy.kovalevskyi.codingbootcamp.week2.day0;

import academy.kovalevskyi.codingbootcamp.week0.day4.Numbers1;
import academy.kovalevskyi.codingbootcamp.week1.day0.NumberUtils;
import academy.kovalevskyi.codingbootcamp.week1.day2.StringUtils;
import java.util.Arrays;


public class MainW2D0 {

    public static void main(String[] args) {
        int n = 10;
        int m = 3;
        //int soch = Numbers2.getChars(n, m);
        //char[][] res = new char[soch][m];
        //res = Numbers2.generateTriplets();
        //System.out.println("MAIN| generateTriplets():" + print(res));

        char[][] res1 = Numbers2.generateTuples();
        System.out.println("MAIN| generateTuples()" + print(res1));

        char[][] res2 = Numbers2.generateTuples(4);
        System.out.println("MAIN| generateTuples(4)" + print(res2));
    }

    public static String print(char[][] arr) {
        StringBuilder sb = new StringBuilder("\n");
        int count = 0;
        for (char[] a : arr) {
            sb.append(Arrays.toString(a)).append(",");
            if (++count > 9) {
                sb.append("\n");
                count = 0;
            }
        }
        return sb.toString();
    }
}
