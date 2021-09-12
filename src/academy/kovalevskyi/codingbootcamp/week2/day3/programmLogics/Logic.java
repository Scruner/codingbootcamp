package academy.kovalevskyi.codingbootcamp.week2.day3.programmLogics;

//этот класс простой, он будет расположен на вершине всей логики
public class Logic {
    //для того чтобы поле(массив) было расширяемым, вводим переменные side, length
    public int side = 3;
    public int length = side * side;
    //Создаём ссылку на класс Result. В параметры пишем ширину, высоту и количество символов подряд, необходимых для победы
    Result result = new Result(side, side, 3);
    //Создаём ссылку на класс Counter
    Counter counter = new Counter(result);

    /*После вывода результата в окне, поле должно очиститься. Для этого создадим метод startPosition(). И вызовем его
    * в классе Button*/
    public void startPosition() {
        array = new String[length];
        /*Для того чтобы компьютер не ходил всегда с левого верхнего угла, первый ход мы ему назначим в рандомном
        * порядке*/
        int index = (int) (Math.random() * length);
        array[index] = "X";
    }

    /*Создаём метод, который сообщит результат игры. Кто выиграл. В методе result() мы вызываем метода process(),
     * который оценивает наш массив. Кто выиграл, кто проиграл или там вообще ничья, возвращает соответствующий результат,
     * а мы этот результат возвращаем дальше*/
    public String result() {
        return result.process(array);
    }

    //массив - это игровое поле
    public String[] array = new String[length];

    /*Создаём метод, который вызывает методы, написанные ниже (positionUser, positionPC). Метод принимает index, т.е.
    куда(в какое игровое поле) мы записываем index. И вторым параметром, что мы записываем (Х или 0).
    В методе делаем проверку, является ли игровое поле пустым, если ДА, тогда он совершает запись и возвращает true,
    значит запись успешно совершена, если нет - возвращает false. Эта проверка нужна для того, чтобы в случае нажатия
    на одно и то же поле уже написанный символ нельзя было заменить на другой (то есть поставленный Х не заменить на 0)*/
    public boolean write(int index, String symbol) {
        if (array[index] == null) {
            array[index] = symbol;
        } else {
            return false;
        }
        return true;
    }

    /*Данный метод вызывается из кнопки, в него кнопка отправляет свой индекс. То есть например, если мы нажали на
    кнопку 8, она вызывает этот метод и говорит логике о том, что юзер пошёл на 8е поле*/
    public boolean positionUser(int index) {
        //пользователь будет играть 0, поэтому отправляем в параметр вызванного метода write индекс (это указатель места
        //куда мы пошли, а второй параметр указывает что ходим мы ноликом
        return write(index, "0");
    }

    /*Метод не принимает никаких параметров. Он также вызывается в кнопке. После хода юзера, ход переходит к компьютеру.
     Вызывается этот метод и ходит компьютер и вносит свою позицию в массив. Это созданный в этом классе массив array -
     он является общим игровым полем для юзера и компьютера.*/
    public boolean positionPC() {
        /*Метод process() возвращает тот индекс (это тот ход, который должен сделать компьютер). Этот индекс мы и будем
        * посылать в метод write()*/
        return write(counter.process(array), "X");
    }
}