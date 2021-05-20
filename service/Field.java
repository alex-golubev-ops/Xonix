package service;

import src.GameXonix;

import java.awt.*;
import java.util.Iterator;

public class Field {
    private final int WATER_AREA = 2501;
    private int[][] field = new int[65][45];
    private float currentWaterArea;
    private int countScore = 0;

    Field() {
        this.init();
    }

    void init() {
        for(int y = 0; y < 45; ++y) {
            for(int x = 0; x < 65; ++x) {
                this.field[x][y] = x >= 2 && x <= 62 && y >= 2 && y <= 42 ? 0 : 10053120;
            }
        }

        this.currentWaterArea = 2501.0F;
    }

    int getColor(int x, int y) {
        return x >= 0 && y >= 0 && x <= 64 && y <= 44 ? this.field[x][y] : 0;
    }

    void setColor(int x, int y, int color) {
        this.field[x][y] = color;
    }

    int getCountScore() {
        return this.countScore;
    }

    float getCurrentPercent() {
        return 100.0F - this.currentWaterArea / 2501.0F * 100.0F;
    }

    void clearTrack() {
        for(int y = 0; y < 45; ++y) {
            for(int x = 0; x < 65; ++x) {
                if (this.field[x][y] == 9441936) {
                    this.field[x][y] = 0;
                }
            }
        }

    }

    void fillTemporary(int x, int y) {
        if (this.field[x][y] <= 0) {
            this.field[x][y] = 1;

            for(int dx = -1; dx < 2; ++dx) {
                for(int dy = -1; dy < 2; ++dy) {
                    this.fillTemporary(x + dx, y + dy);
                }
            }

        }
    }

    void tryToFill() {
        this.currentWaterArea = 0.0F;
        Iterator var1 = GameXonix.this.balls.getBalls().iterator();

        while(var1.hasNext()) {
            GameXonix.Ball ball = (GameXonix.Ball)var1.next();
            this.fillTemporary(ball.getX(), ball.getY());
        }

        for(int y = 0; y < 45; ++y) {
            for(int x = 0; x < 65; ++x) {
                if (this.field[x][y] == 9441936 || this.field[x][y] == 0) {
                    this.field[x][y] = 10053120;
                    this.countScore += 10;
                }

                if (this.field[x][y] == 1) {
                    this.field[x][y] = 0;
                    ++this.currentWaterArea;
                }
            }
        }

    }

    void paint(Graphics g) {
        for(int y = 0; y < 45; ++y) {
            for(int x = 0; x < 65; ++x) {
                g.setColor(new Color(this.field[x][y]));
                g.fillRect(x * 10, y * 10, 10, 10);
            }
        }

    }
}
