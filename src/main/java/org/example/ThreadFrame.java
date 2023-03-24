package org.example;

import javax.swing.*;
import java.awt.*;

public class ThreadFrame extends JFrame {
    JFrame frame = new JFrame();
    JPanel row = new JPanel();
    JLabel numbersLabel = new JLabel();

    public ThreadFrame() {
        GridBagLayout layout = new GridBagLayout();
        frame.setSize(400, 200);
        row.setLayout(layout);
        row.add(numbersLabel);
        frame.add(row);
        frame.setVisible(true);
    }
}
