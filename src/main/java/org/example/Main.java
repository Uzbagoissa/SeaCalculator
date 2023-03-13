package org.example;

import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {
    Calculator nc = new Calculator(this);

    JPanel row1 = new JPanel();
    JLabel numbersLabel1 = new JLabel("скорость судна: ", JLabel.RIGHT);
    JTextField numbers1 = new JTextField();
    JLabel numbersLabel1_1 = new JLabel("м/с", JLabel.LEFT);
    JLabel numbersLabel2 = new JLabel("курс судна: ", JLabel.RIGHT);
    JTextField numbers2 = new JTextField();
    JLabel numbersLabel2_1 = new JLabel("градусов", JLabel.LEFT);
    JLabel numbersLabel3 = new JLabel("скорость ветра с альтиметра: ", JLabel.RIGHT);
    JTextField numbers3 = new JTextField();
    JLabel numbersLabel3_1 = new JLabel("м/с", JLabel.LEFT);
    JLabel numbersLabel4 = new JLabel("направление ветра с альтиметра: ", JLabel.RIGHT);
    JTextField numbers4 = new JTextField();
    JLabel numbersLabel4_1 = new JLabel("градусов", JLabel.LEFT);

    JPanel row2 = new JPanel();
    JButton Calc = new JButton("Расчитать");
    JButton Reset = new JButton("Reset");

    JPanel row3 = new JPanel();
    JLabel got3Label = new JLabel("Истинная скорость ветра - ", JLabel.CENTER);
    JTextField got3 = new JTextField();
    JLabel got3Label_1 = new JLabel("Истинное направление ветра - ", JLabel.CENTER);
    JTextField got3_1 = new JTextField();

    JPanel row4 = new JPanel();
    JLabel got4Label = new JLabel("Итог: ", JLabel.CENTER);
    JTextArea got4 = new JTextArea();
    JScrollPane scroll = new JScrollPane(got4);

    public Main() {
        super("Sea Calculator");

        setSize(650, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout layout = new GridLayout(4, 1, 5, 5);
        setLayout(layout);

        Calc.addActionListener(nc);
        Reset.addActionListener(nc);

        GridLayout layout1 = new GridLayout(4, 3, 10, 10);
        row1.setLayout(layout1);
        row1.add(numbersLabel1);
        row1.add(numbers1);
        row1.add(numbersLabel1_1);
        row1.add(numbersLabel2);
        row1.add(numbers2);
        row1.add(numbersLabel2_1);
        row1.add(numbersLabel3);
        row1.add(numbers3);
        row1.add(numbersLabel3_1);
        row1.add(numbersLabel4);
        row1.add(numbers4);
        row1.add(numbersLabel4_1);
        add(row1);

        FlowLayout layout2 = new FlowLayout(FlowLayout.CENTER, 10, 10);
        row2.add(Calc);
        row2.add(Reset);
        add(row2);

        GridLayout layout3 = new GridLayout(4, 2, 10, 10);
        row3.setLayout(layout3);
        row3.add(got3Label);
        got3.setEditable(false);
        row3.add(got3);
        row3.add(got3Label_1);
        got3_1.setEditable(false);
        row3.add(got3_1);
        add(row3);

        GridLayout layout4 = new GridLayout(1, 2, 10, 10);
        row4.setLayout(layout4);
        row4.add(got4Label);
        got4.setLineWrap(true);
        got4.setWrapStyleWord(true);
        got4.setEditable(false);
        row4.add(scroll);
        add(row4);

        setVisible(true);
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
        }
    }

    public static void main(String[] arguments) {
        Main.setLookAndFeel();
        Main frame = new Main();
    }
}