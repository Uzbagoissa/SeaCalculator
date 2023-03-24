package org.example;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

public class RunButtonUI extends BasicButtonUI {
    public static final int BUTTON_WIDTH = 120;
    public static final int BUTTON_HEIGHT = 48;
    private static final Border BUTTON_BORDER = BorderFactory.createLineBorder(Color.GREEN);

    @Override
    public void paint(Graphics g, JComponent c) {
        AbstractButton button = (AbstractButton) c;
        Graphics2D g2d = (Graphics2D) g;

        if (button.isOpaque()) {
            button.setRolloverEnabled(true);
            button.setForeground(Color.GREEN);
            button.setBorder(BUTTON_BORDER);

            final int buttonWidth = button.getWidth();
            if (button.getModel().isRollover()) {
                RadialGradientPaint gp = new RadialGradientPaint(new Point(buttonWidth / 2, BUTTON_HEIGHT / 2),
                        buttonWidth,
                        new float[]{0.2f, 0.8f},
                        new Color[]{Color.BLUE, Color.DARK_GRAY});
                g2d.setPaint(gp);
            } else if (button.isEnabled()) {
                GradientPaint gp = new GradientPaint(
                        0, 0, Color.GRAY,
                        0, BUTTON_HEIGHT * 0.6f, Color.DARK_GRAY, true);
                g2d.setPaint(gp);
            } else {
                GradientPaint gp = new GradientPaint(
                        0, 0, Color.LIGHT_GRAY,
                        0, BUTTON_HEIGHT * 0.6f, Color.GRAY, true);
                g2d.setPaint(gp);
            }
            g2d.fillRect(0, 0, buttonWidth, BUTTON_HEIGHT);
        }
        super.paint(g, button);
    }

    @Override
    public Dimension getPreferredSize(JComponent c) {
        AbstractButton button = (AbstractButton) c;
        int width = Math.max(button.getWidth(), BUTTON_WIDTH);
        int height = Math.max(button.getHeight(), BUTTON_HEIGHT);
        return new Dimension(width, height);
    }
}
