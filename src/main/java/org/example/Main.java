package org.example;

import javax.swing.*;

public class Main {

    public static void main(String[] arguments) {
        Main.setLookAndFeel();
        MainFrame frame = new MainFrame();
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.metal.CrossPlatformLookAndFeel"
            );
        } catch (Exception exc) {
        }
    }
}