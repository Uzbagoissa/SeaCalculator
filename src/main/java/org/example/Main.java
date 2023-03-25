package org.example;

import javax.swing.*;

/**
 * Основной класс приложения, содержащий метод main(). В нем происходит запуск звукового сопровождения и открытие
 * основного окна приложения, графическая оболочка которого определяется в методе setLookAndFeel().
 */
public class Main {

    public static void main(String[] arguments) {
        BackgroundSound backgroundSound = new BackgroundSound();
        backgroundSound.playSound();
        Main.setLookAndFeel();
        MainFrame frame = new MainFrame();
    }

    /**
     * В методе setLookAndFeel() происходит активизация графической оболочки "CrossPlatformLookAndFeel" для настройки
     * внешнего вида интерфейса.
     */
    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.metal.CrossPlatformLookAndFeel"
            );
        } catch (Exception exc) {
        }
    }
}