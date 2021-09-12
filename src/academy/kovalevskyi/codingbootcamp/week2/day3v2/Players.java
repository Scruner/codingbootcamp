package academy.kovalevskyi.codingbootcamp.week2.day3v2;

public class Players extends Main {

    /*Метод, где игрок делает ход. Игрок вводит число типа Integer, присваиваем это число переменной x и y.
     * В цикле while() проверяем не занята ли клетка(ячейка)*/
    public static void movePlayer() {
        int x, y;
        do {
            x = enter.nextInt() - 1;
            y = enter.nextInt() - 1;
        } while (!isCellValid(x, y));
        FIELD[y][x] = PLAYER;
    }

    /*Метод, где ход делает компьютер*/
    public static void movePC() {
        int x, y;
        do {
            x = random.nextInt(FIELD_SIZE);
            y = random.nextInt(FIELD_SIZE);
        } while (!isCellValid(x, y));
        FIELD[y][x] = COMPUTER;
    }
}
