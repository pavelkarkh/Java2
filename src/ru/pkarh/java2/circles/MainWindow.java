package ru.pkarh.java2.circles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow extends JFrame {
    public static final int POS_X = 600;
    public static final int POS_Y = 200;
    public static final int WINWOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;

    Sprite[] sprites = new Sprite[100];

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
        });
    }

    public MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(POS_X, POS_Y);
        setSize(WINWOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        setTitle("Circles");

        GameCanvas gameCanvas = new GameCanvas(this);
        add(gameCanvas);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == e.BUTTON3) {
                    removeSprite();
                } else {
                    addSprite();
                }
            }
        });

        initSprites();

        setVisible(true);
    }

    private void addSprite() {
        int counter = 0;
        for (int i = 0; i < sprites.length; i++) {
            if (sprites[i] instanceof Ball){
               counter++;
            }
        }
        System.out.println("Left button clicked, counter = " + counter);
        if (counter < sprites.length){
            sprites[counter] = new Ball();
        }
    }

    private void removeSprite() {
        int counter = 0;
        for (int i = 0; i < sprites.length; i++) {
            if (sprites[i] instanceof Ball){
                counter++;
            }
        }
        System.out.println("Right button clicked, counter = " + counter);
        if (counter > 1){
            sprites[counter - 1] = null;
        }
    }

    private void initSprites() {
        for (int i = 0; i < 10; i++) {
            sprites[i] = new Ball();
        }
    }

    void onDrawFrame(GameCanvas gameCanvas, Graphics graphics, float dt) {
        update(gameCanvas, dt);
        render(gameCanvas, graphics);
    }

    private void update(GameCanvas gameCanvas, float dt){
        for (int i = 0; i < sprites.length; i++) {
            if (sprites[i] instanceof Ball) {
                sprites[i].update(gameCanvas, dt);
            }
        }
    }

    private void render(GameCanvas gameCanvas, Graphics graphics) {
        for (int i = 0; i < sprites.length; i++) {
            if (sprites[i] instanceof Ball) {
                sprites[i].render(gameCanvas, graphics);
            }
        }
    }
}
