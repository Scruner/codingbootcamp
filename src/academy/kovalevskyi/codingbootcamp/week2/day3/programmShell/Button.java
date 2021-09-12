package academy.kovalevskyi.codingbootcamp.week2.day3.programmShell;

import academy.kovalevskyi.codingbootcamp.week2.day3.programmLogics.Logic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends JButton {
    private int index;
    //Создаём ссылку на класс Логика
    private Logic logic = new Logic();
    //Создаём ссылку на класс MyFrame
    private MyFrame myFrame;

    /* У каждой кнопки будет свой индекс, при помощи которого она будет общаться с логикой программы. То есть в поле 3Х3
     у нас будет 9 кнопок, они пронумерованы от 0 до 8. Кнопка, при помощи своего индекса, сообщает логике, что юзер
     нажал на кнопку 0*/
    public Button(int index, int x, int y, Logic logic, MyFrame myFrame) {
        this.index = index;
        this.logic = logic;
        this.myFrame = myFrame;

        /*Размер кнопок 100х100. Расположены на координатах (0, 0)(0,100)(0,200) и т.д.
        у каждой кнопки будет свой слушатель(addActionListener), которому будет доступно поле index, так как оно
        описано внутри кнопки(класса Button)*/
        this.setBounds(x * 100, y * 100, 100, 100);
        this.addActionListener(new MyKeyAdapter());
    }

    public void action(String text) {
        /*Метод выводит окно с сообщением, в зависимости от результата*/
        JOptionPane.showMessageDialog(null, text);
        /*После вывода результата в окне, поле должно очиститься. Для этого создадим метод startPosition() в классе
        Logic. И вызовем его здесь, в методе action()*/
        logic.startPosition();
        /*Так как на поле по-прежнему нарисованы крестики и нолики, мы должны обновить поле*/
        myFrame.update();
    }

    /*На результат игры мы как-то должны отреагировать. Для этого создаём метод result() внутри кнопки. В котором
     * мы объявляем (показываем) кто выиграл или случилась ничья*/
    public boolean result(String symbol) {
        /*При достижении какого-либо окончательного результата в игре, вызываем метод action() и возвращаем true*/
        if (symbol == "X") {
            action("YOU LOST");
            return true;
        }
        if (symbol == "0") {
            action("YOU WON");
            return true;
        }
        if (symbol == "deadlock") {
            action("DRAW");
            return true;
        }
        /*Если же тупик, то метод result() вернёт false*/
        return false;
    }

    private class MyKeyAdapter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           /* После того как мы нажимаем на кнопку, срабатывает слушатель. В этом слушателе, вызываем метода
            positionUser() и отправляем в его параметр индекс нашей кнопки. Допустим нажали на кнопку под номером 7,
            вызывается метод positionUser() и в 7й элемент массива array будет записан 0. Данные внесены, после этого
            на кнопке должны появиться данные, которые мы ввели (это 0)*/
            logic.positionUser(index);
            myFrame.update();
            /*Чтобы узнать результат позиции (возможно уже выиграли, проиграли либо ничья), мы вызываем метод result().
             * Заворачиваем это в условие, что если результат положительный, то мы должны выйти отсюда, чтобы игра дальше
             * не продолжалась*/
            if (result(logic.result())) {
                return;
            }
            ;

            /*После нашего хода, ходит компьютер. Но после хода компьютера, мы не знаем на какой индекс он поставил свой
            символ. Поэтому в классе MyFrame нужно написать метод, который будет обновлять все кнопки. Он будет
            обращаться к массиву array, пробегаться по всем его элементам. Смотреть, где находятся Х и 0 и будет
            указывать кнопке, какой элемент находится на ней*/
            logic.positionPC();
            myFrame.update();
            if (result(logic.result())) {
                return;
            }
            ;
        }
    }
}
