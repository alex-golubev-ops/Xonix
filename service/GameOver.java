package service;



import java.awt.*;

public class GameOver {
    private final String GAME_OVER_MSG = "Game Over";
    private boolean gameOver;

    GameOver() {
    }

    boolean isGameOver() {
        return this.gameOver;
    }

    void paint(Graphics g) {
        if ( GameXonix.this.xonix.getCountLives() == 0) {
            this.gameOver = true;
            g.setColor(Color.white);
            g.setFont(new Font("", 1, 60));
            FontMetrics fm = g.getFontMetrics();
            g.drawString("Game Over", (656 - fm.stringWidth("Game Over")) / 2, 225);
        }

    }
}
