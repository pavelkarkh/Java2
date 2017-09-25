package ru.pkarh.java2.circles;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {
    private MainWindow mainWindow;
    private long lastFrameTime;



    public GameCanvas(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        lastFrameTime = System.nanoTime();

    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        long currentTime = System.nanoTime();
        float dt = (currentTime - lastFrameTime) * 0.000000001f;
        lastFrameTime = currentTime;

        mainWindow.onDrawFrame(this, graphics, dt);
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    int getLeft() {
        return 0;
    }

    int getRight() {
        return getWidth() - 1;
    }

    int getTop() {
        return 0;
    }

    int getBottom() {
        return getHeight() - 1;
    }

}
