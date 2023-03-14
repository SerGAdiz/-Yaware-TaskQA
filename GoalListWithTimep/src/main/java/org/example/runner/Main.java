package org.example.runner;

import org.example.window.MainWindowApp;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static org.example.constant.Name.APP_NAME;

public class Main {
    public static void main(String[] args) {
        final MainWindowApp mainWindowApp = new MainWindowApp();
        final JFrame frame = new JFrame(APP_NAME);
        final Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
        frame.setIconImage(icon);

        frame.setContentPane(mainWindowApp.mainWin);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
