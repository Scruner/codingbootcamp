package academy.kovalevskyi.codingbootcamp.week2.day3v2;

public class Referee extends Main {

    /*Метод проверки победителя. Кто победил. Метод должен возвращать 1 в случае победы, 0 в случае поражения. sum - это
     * количество элементов, которые нам надо собрать в ряд*/
    public static boolean checkWin(char sum) {
        /*Здесь мы проверяем есть то необходимое количество символов в ряд*/
        for (int i = 0; i < FIELD_SIZE; i++) {
            int result = 0;
            for (int j = 0; j < FIELD_SIZE; j++) {
                /*Проверяем по индексам строки - столбцы. Проверка соответствует ли количество выставленных символов
                 * сумме всех выставленных чисел*/
                if (FIELD[i][j] == sum) {
                    result++;
                }
            }
            /*Проверяем, совпадает ли переменная result с нашим размером поля. Если да - значит игрок выиграл*/
            if (result == FIELD_SIZE) {
                return true;
            }
        }
        for (int i = 0; i < FIELD_SIZE; i++) {
            int result = 0;
            for (int j = 0; j < FIELD_SIZE; j++) {
                /*Проверяем по индексам столбцы - строки*/
                if (FIELD[j][i] == sum) {
                    result++;
                }
            }
            if (result == FIELD_SIZE) {
                return true;
            }
        }
        int first = 0;
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                /*Проверка на пересечение элементов*/
                if (j == i && FIELD[i][j] == sum) {
                    first++;
                }
            }
        }
        /*Если переменная first равна размеру поля, то игрок выиграл*/
        if (first == FIELD_SIZE) {
            return true;
        }
        int second = 0;
        for (int i = 0, j = FIELD_SIZE - 1; i < FIELD_SIZE && j >= 0; i++, j--) {
            if (FIELD[i][j] == sum) {
                second++;
            }
        }
        if (second == FIELD_SIZE) {
            return true;
        }
        return false;
    }

}
