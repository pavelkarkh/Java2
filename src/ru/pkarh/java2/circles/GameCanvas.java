package ru.pkarh.java2.circles;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {
    private MainWindow mainWindow;
    private long lastFrameTime;
    private Background background;


    public GameCanvas(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        background = new Background();
        lastFrameTime = System.nanoTime();
        setBackground(background.getColor());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        long currentTime = System.nanoTime();
        float dt = (currentTime - lastFrameTime) * 0.000000001f;
        lastFrameTime = currentTime;

        if ((currentTime - background.backgroundTime) * 0.000000001f > background.CHANGE_BACKGROUND_TIME) {
            background.initColor();
            setBackground(background.getColor());
            background.backgroundTime = currentTime;
        }

        mainWindow.onDrawFrame(this, g, dt);
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
