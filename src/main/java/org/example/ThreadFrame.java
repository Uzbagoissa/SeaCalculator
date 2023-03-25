package org.example;

import javax.swing.*;
import java.awt.*;

/**
 * Класс отвечает за создание окна, выводящего информацию о работающем потоке. Окно появляется после нажатия кнопки
 * "Запуск потока" в основном окне. Класс наследуется от JFrame. За вывод текстовой информации в окне отвечает компонент
 * JLabel numbersLabel. За размещение компонентов отвечает класс GridBagLayout.
 */
public class ThreadFrame extends JFrame {
    JLabel numbersLabel = new JLabel();

    public ThreadFrame() {
        GridBagLayout layout = new GridBagLayout();
        setSize(400, 200);
        setLayout(layout);
        add(numbersLabel);
        setVisible(true);
    }
}
