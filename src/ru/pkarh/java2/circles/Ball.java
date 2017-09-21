package ru.pkarh.java2.circles;

import java.awt.*;

public class Ball extends Sprite {

    private float vx = 150 + (float)(Math.random() * 200f);
    private float vy = 150 + (float)(Math.random() * 200f);

    private final Color color = new Color(
            (int)(Math.random() * 256f),
            (int)(Math.random() * 256f),
            (int)(Math.random() * 256f)
    );

    public Ball() {
        halfHeight = 20 + (float)(Math.random() * 50f);
        halfWidth = halfHeight;
    }

    @Override
    void update(GameCanvas gameCanvas, float dt) {
        x += vx * dt;
        y += vy * dt;

        if (getLeft() < gameCanvas.getLeft()) {
            setLeft(gameCanvas.getLeft());
            vx = -vx;
        }

        if (getRight() > gameCanvas.getRight()) {
            setRight(gameCanvas.getRight());
            vx = -vx;
        }

        if (getTop() < gameCanvas.getTop()) {
            setTop(gameCanvas.getTop());
            vy = -vy;
        }

        if (getBottom() > gameCanvas.getBottom()) {
            setBottom(gameCanvas.getBottom());
            vy = -vy;
        }
    }

    @Override
    void render(GameCanvas gameCanvas, Graphics graphics) {
        graphics.setColor(color);
        graphics.fillOval((int)getLeft(), (int)getTop(), (int)getWidth(), (int)getHeight());
    }
}
