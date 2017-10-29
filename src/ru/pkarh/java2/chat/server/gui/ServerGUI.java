package ru.pkarh.java2.chat.server.gui;

import ru.pkarh.java2.chat.server.core.ChatServer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerGUI extends JFrame implements ActionListener, Thread.UncaughtExceptionHandler {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ServerGUI();
            }
        });
    }

    private static final int POS_X = 1000;
    private static final int POS_Y = 600;
    private static final int WIDTH = 200;
    private static final int HEIGHT = 100;

    private final ChatServer chatServer = new ChatServer();
    private final JButton buttonStart = new JButton("Strat");
    private final JButton buttonStop = new JButton("Stop");

    private ServerGUI() {
        Thread.setDefaultUncaughtExceptionHandler(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);

        setResizable(false);
        setTitle("Chat server");
        setAlwaysOnTop(true);
        setLayout(new GridLayout(1,2));

        buttonStart.addActionListener(this);
        buttonStop.addActionListener(this);

        add(buttonStart);
        add(buttonStop);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == buttonStart) {
            chatServer.start(8189);
            System.out.println("Start");
            throw new RuntimeException("Hahahahaah");
        } else if (src == buttonStop) {
            chatServer.stop();
            System.out.println("Stop");
        } else {
            throw new RuntimeException("Unexpected source: " + src);
        }
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();

        StackTraceElement[] elements = e.getStackTrace();
        String message;
        if (elements.length == 0){
            message = "emtpy stacktrace";
        } else {
            message = e.getClass().getCanonicalName() +
                    ": " + e.getMessage() + "\n" +
                    "\t at " + elements[0];
        }

        JOptionPane.showMessageDialog(this, message, "Exeption", JOptionPane.ERROR_MESSAGE);
        System.exit(1);
    }
}
