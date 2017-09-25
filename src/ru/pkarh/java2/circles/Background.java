package ru.pkarh.java2.circles;

import java.awt.*;

public class Background {
    private Color color;
    float backgroundTime;

    public static final float CHANGE_BACKGROUND_TIME = 1.0f;

    public Background() {
        initColor();
        backgroundTime = 0;
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

    void update(GameCanvas gameCanvas, float dt) {

        backgroundTime += dt;
        if (backgroundTime > CHANGE_BACKGROUND_TIME) {
            initColor();
            gameCanvas.setBackground(color);
            backgroundTime = 0;
        }
    }

//    void render(GameCanvas gameCanvas, Graphics graphics) {
//        gameCanvas.setBackground(color);
//    }
}
