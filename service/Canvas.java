package service;

import javax.swing.*;
import java.awt.*;

class Canvas extends JPanel {
    private Canvas field;
    private Canvas xonix;
    private Canvas balls;
    private Canvas cube;
    private Canvas gameover;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        field.paint(g);
        xonix.paint(g);
        balls.paint(g);
        cube.paint(g);
        gameover.paint(g);
    }
}

