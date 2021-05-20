package service;

import src.GameXonix;

import java.awt.*;

public class Cube {
    private int x;
    private int y;
    private int dx;
    private int dy;

    Cube() {
        this.init();
    }

    void init() {
        this.x = this.dx = this.dy = 1;
    }

    void updateDXandDY() {
        if (GameXonix.this.field.getColor(this.x + this.dx, this.y) == 0) {
            this.dx = -this.dx;
        }

        if (GameXonix.this.field.getColor(this.x, this.y + this.dy) == 0) {
            this.dy = -this.dy;
        }

    }

    void move() {
        this.updateDXandDY();
        this.x += this.dx;
        this.y += this.dy;
    }

    boolean isHitXonix() {
        this.updateDXandDY();
        return this.x + this.dx == GameXonix.this.xonix.getX() && this.y + this.dy == GameXonix.this.xonix.getY();
    }

    void paint(Graphics g) {
        g.setColor(new Color(-12123646, true));
        g.fillRect(this.x * 10, this.y * 10, 10, 10);
        g.setColor(new Color(10053120));
        g.fillRect(this.x * 10 + 2, this.y * 10 + 2, 6, 6);
    }
}
