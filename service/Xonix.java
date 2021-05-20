package service;

import src.GameXonix;

import java.awt.*;

public class Xonix {
    private int x;
    private int y;
    private int direction;
    private int countLives = 10;
    private boolean isWater;
    private boolean isSelfCross;

    Xonix() {
        this.init();
    }

    void init() {
        this.y = 0;
        this.x = 32;
        this.direction = 0;
        this.isWater = false;
    }

    int getX() {
        return this.x;
    }

    int getY() {
        return this.y;
    }

    int getCountLives() {
        return this.countLives;
    }

    void decreaseCountLives() {
        --this.countLives;
    }

    void setDirection(int direction) {
        this.direction = direction;
    }

    void move() {
        if (this.direction == 37) {
            --this.x;
        }

        if (this.direction == 39) {
            ++this.x;
        }

        if (this.direction == 38) {
            --this.y;
        }

        if (this.direction == 40) {
            ++this.y;
        }

        if (this.x < 0) {
            this.x = 0;
        }

        if (this.y < 0) {
            this.y = 0;
        }

        if (this.y > 44) {
            this.y = 44;
        }

        if (this.x > 64) {
            this.x = 64;
        }

        this.isSelfCross = GameXonix.this.field.getColor(this.x, this.y) == 9441936;
        if (GameXonix.this.field.getColor(this.x, this.y) == 10053120 && this.isWater) {
            this.direction = 0;
            this.isWater = false;
            GameXonix.this.field.tryToFill();
        }

        if (GameXonix.this.field.getColor(this.x, this.y) == 0) {
            this.isWater = true;
            GameXonix.this.field.setColor(this.x, this.y, 9441936);
        }

    }

    boolean isSelfCrosed() {
        return this.isSelfCross;
    }

    void paint(Graphics g) {
        g.setColor(GameXonix.this.field.getColor(this.x, this.y) == 10053120 ? new Color(8062306) : Color.white);
        g.fillRect(this.x * 10, this.y * 10, 10, 10);
        g.setColor(GameXonix.this.field.getColor(this.x, this.y) == 10053120 ? Color.white : new Color(16100379));
        g.fillRect(this.x * 10 + 3, this.y * 10 + 3, 4, 4);
    }
}
