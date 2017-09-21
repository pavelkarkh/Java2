package ru.pkarh.java2.circles;

import java.awt.*;

public class Background {
    private Color color;
    long backgroundTime;

    public static final float CHANGE_BACKGROUND_TIME = 1.0f;

    public Background() {
        initColor();
        backgroundTime = System.nanoTime();
    }

    public Color getColor() {
        return color;
    }

    public void initColor() {
        color = new Color(
                (int)(Math.random() * 256f),
                (int)(Math.random() * 256f),
                (int)(Math.random() * 256f)
        );
    }
}
