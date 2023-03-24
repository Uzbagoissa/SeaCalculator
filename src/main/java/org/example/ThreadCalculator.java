package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThreadCalculator implements ActionListener {
    private final MainFrame mainFrame;

    public ThreadCalculator(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        if (command.equals("Запуск потока")) {
            runThread(event);
        }
    }

    private void runThread(ActionEvent event) {
        Thread thread = new Thread(() -> {
            mainFrame.got5.setText(" ");
            JButton button = (JButton) event.getSource();
            ThreadFrame frame = new ThreadFrame();
            button.setEnabled(false);
            int number = 0;
            for (int i = 0; i < 500; i++) {
                frame.numbersLabel.setText(String.valueOf(number));
                number++;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            mainFrame.got5.setText("Поток завершился");
            button.setEnabled(true);
        });
        thread.start();
    }
}
