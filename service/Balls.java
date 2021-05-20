package service;

import src.GameXonix;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Balls {
    private ArrayList<GameXonix.Ball> balls = new ArrayList();

    Balls() {
        this.add();
    }

    void add() {
        this.balls.add(GameXonix.this.new Ball());
    }

    void move() {
        Iterator var1 = this.balls.iterator();

        while(var1.hasNext()) {
            GameXonix.Ball ball = (GameXonix.Ball)var1.next();
            ball.move();
        }

    }

    ArrayList<GameXonix.Ball> getBalls() {
        return this.balls;
    }

    boolean isHitTrackOrXonix() {
        Iterator var1 = this.balls.iterator();

        GameXonix.Ball ball;
        do {
            if (!var1.hasNext()) {
                return false;
            }

            ball = (GameXonix.Ball)var1.next();
        } while(!ball.isHitTrackOrXonix());

        return true;
    }

    void paint(Graphics g) {
        Iterator var2 = this.balls.iterator();

        while(var2.hasNext()) {
            GameXonix.Ball ball = (GameXonix.Ball)var2.next();
            ball.paint(g);
        }

    }
}
