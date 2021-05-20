package service;

import src.GameXonix;
import java.awt.*;

public class Ball {
    private int x;
    private int y;
    private int dx;
    private int dy;

    Ball() {
        do {
            this.x = GameXonix.this.random.nextInt(65);
            this.y = GameXonix.this.random.nextInt(45);
        } while(GameXonix.this.field.getColor(this.x, this.y) > 0);

        this.dx = GameXonix.this.random.nextBoolean() ? 1 : -1;
        this.dy = GameXonix.this.random.nextBoolean() ? 1 : -1;
    }

    void updateDXandDY() {
        if (GameXonix.this.field.getColor(this.x + this.dx, this.y) == 10053120) {
            this.dx = -this.dx;
        }

        if (GameXonix.this.field.getColor(this.x, this.y + this.dy) == 10053120) {
            this.dy = -this.dy;
        }

    }

    void move() {
        this.updateDXandDY();
        this.x += this.dx;
        this.y += this.dy;
    }

    int getX() {
        return this.x;
    }

    int getY() {
        return this.y;
    }

    boolean isHitTrackOrXonix() {
        this.updateDXandDY();
        if (GameXonix.this.field.getColor(this.x + this.dx, this.y + this.dy) == 9441936) {
            return true;
        } else {
            return this.x + this.dx == GameXonix.this.xonix.getX() && this.y + this.dy == GameXonix.this.xonix.getY();
        }
    }

    void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillOval(this.x * 10, this.y * 10, 10, 10);
        g.setColor(new Color(950813));
        g.fillOval(this.x * 10 + 2, this.y * 10 + 2, 6, 6);
    }
}
