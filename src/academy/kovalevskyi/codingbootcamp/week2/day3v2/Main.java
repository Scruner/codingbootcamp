package academy.kovalevskyi.codingbootcamp.week2.day3v2;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static final int FIELD_SIZE = 3;
    static final char PLAYER = '0';
    static final char COMPUTER = 'X';
    static final char NULL = '!';
    static Scanner enter = new Scanner(System.in);
    static Random random = new Random();
    static final char[][] FIELD = new char[FIELD_SIZE][FIELD_SIZE];

    /*Метод инициализирует поле, заполняет его NULLами. То есть изначально поле будет заполнено восклицательными знаками*/
    public static void initField() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                FIELD[i][j] = NULL;
            }
        }
    }

    /*Метод выводит информацию на поле, выводит само поле на экран. Для пробелов между символами используем "\t"*/
    public static void printField() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                System.out.print(FIELD[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /*Проверка на отсутствие символа в ячейке*/
    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= FIELD_SIZE || y < 0 || y >= FIELD_SIZE) {
            return false;
        } else if (FIELD[y][x] == NULL) {
            return true;
        }
        return false;
    }

    /*Метод поиска свободного места. В ситуации, когда ряда символов нет и пустых ячеек тоже нет - ничья*/
    public static boolean isFreeSpace() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (FIELD[i][j] == NULL) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        initField();
        printField();
        while (true) {
            Players.movePlayer();
            printField();
            if (Referee.checkWin(PLAYER)) {
                System.out.println("You WIN!");
                break;
            } else if (isFreeSpace()) {
                System.out.println("Draw");
                break;
            }
            Players.movePC();
            System.out.println();
            printField();
            if (Referee.checkWin(COMPUTER)) {
                System.out.println("You LOST");
            } else if (isFreeSpace()) {
                System.out.println("Draw");
                break;
            }
        }
    }
}
