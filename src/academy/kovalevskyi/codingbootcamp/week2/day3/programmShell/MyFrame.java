package academy.kovalevskyi.codingbootcamp.week2.day3.programmShell;

import academy.kovalevskyi.codingbootcamp.week2.day3.programmLogics.Logic;

import javax.swing.*;

public class MyFrame extends JFrame {
    //Создаём ссылку на класс Logic
    public Logic logic = new Logic();
    //Создаём массив для кнопок
    public Button[] buttons = new Button[logic.length];

    public MyFrame() {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        //Создали конструктор и добавили панельку (panel) на окно. На этой панели у нас будут располагаться кнопки
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);

      /*  Теперь создадим девять кнопок и расположим их на этой панели. Для этого необходимо написать цикл for, в
        котором будут определяться координаты x и y, а затем они отправляются в конструктор кнопки. Переменная index
        определяет порядковый номер для каждой кнопки*/
        int index = 0;
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                //Каждый элемент массива будет ссылаться на кнопку. Заполняем массив кнопок
                panel.add(buttons[index] = new Button(index, x, y, logic, this));
                //индекс увеличивается в цикле, за счёт этого кнопки будут пронумерованы от 0 до 8
                index++;
            }
        }
        logic.startPosition();
        update();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyFrame();
            }
        });
    }

    //будем вызывать массив из кнопок
    public void update() {
        for (int i = 0; i < buttons.length; i++) {
            /*array массив типа String, на начальной стадии многие его элементы равны null. А когда мы отправляем
            setText(null) на кнопке ничего нет (то есть ничего не появляется). Когда же попадаем на Х или 0, то на
            кнопке появится Х или 0*/
            buttons[i].setText(logic.array[i]);
        }
    }
}
