package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Класс отвечает за создание потока выполнения обратного отсчета. Класс наследует интерфейс ActionListener и
 * переопределяет метод actionPerformed(), в котором обрабатывается нажатие кнопки "Запуск потока" и запускается поток.
 */
public class ThreadCalculator implements ActionListener {
    private final MainFrame mainFrame;

    /**
     * В конструктор класса передается экземпляр класса MainFrame, отвечающего за создание основного окна, в которое
     * передается информация о состоянии потока.
     */
    public ThreadCalculator(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    /**
     * Метод actionPerformed() реагирует на нажатие кнопки "Запуск потока" в основном окне приложения и запускает поток
     * обратного отсчета с помощью метода runThread().
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        if (command.equals("Запуск потока")) {
            runThread(event);
        }
    }

    /**
     * Метод runThread() создает поток Thread, в котором идет обратный отсчет. Информация о состоянии потока отправляется
     * в текстовое поле got5 основного окна. Метод делает кнопку "Запуск потока" неактивной после нажатия и активной после
     * завершения работы потока.
     */
    private void runThread(ActionEvent event) {
        Thread thread = new Thread(() -> {
            mainFrame.got5.setText(" ");
            JButton button = (JButton) event.getSource();
            ThreadFrame frame = new ThreadFrame();
            /**
             * кнопка "Запуск потока" становится неактивной
             */
            button.setEnabled(false);
            mainFrame.got5.setText("Обратный отсчет запущен");
            int number = 500;
            for (int i = 0; i < 500; i++) {
                frame.numbersLabel.setText("До завершения осталось: " + number);
                number--;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            mainFrame.got5.setText("Выполнение завершено");
            /**
             * кнопка "Запуск потока" снова активна для нажатия
             */
            button.setEnabled(true);
        });
        thread.start();
    }
}
