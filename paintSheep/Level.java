package paintSheep;

import org.openpatch.scratch.KeyCode;
import org.openpatch.scratch.Operators;
import org.openpatch.scratch.Stage;
import org.openpatch.scratch.extensions.color.HtmlColor;

public class Level extends Stage {

    private Sheep player1;
    private Sheep player2;

    public Level() {
        this.addBackdrop("gras", "paintSheep/assets/gras.png");
        this.enableYSort();

        this.player1 = new Sheep(HtmlColor.BLUE);
        this.player2 = new Sheep(HtmlColor.FUCHSIA);

        this.player1.setPosition(-this.getWidth() / 2 + 80, 0);
        this.player2.setPosition(+this.getWidth() / 2 - 80, 0);

        this.add(player1);
        this.add(player2);
    }

    public double[] getScore() {
        double[] score = {0, 0};
        var pixels = this.getBackgroundPixels();

        for (int pixel : pixels) {
            if (pixel == 0) continue;
            if (pixel == this.player1.getTint().get()) {
                score[0]++;
            } else if (pixel == this.player2.getTint().get()) {
                score[1]++;
            }
        }

        score[0] = score[0] / pixels.length * 100;
        score[1] = score[1] / pixels.length * 100;

        return score;
    }

    public void run() {
        if (this.isKeyPressed(KeyCode.VK_A)) {
            this.player1.turnLeft();
        } else if (this.isKeyPressed(KeyCode.VK_D)) {
            this.player1.turnRight();
        } 

        if (this.isKeyPressed(KeyCode.VK_LEFT)) {
            this.player2.turnLeft();
        } else if (this.isKeyPressed(KeyCode.VK_RIGHT)) {
            this.player2.turnRight();
        }

        var score = this.getScore();
        this.display("Player 1: " + Operators.round(score[0], 2) + " Player 2: " + Operators.round(score[1], 2));
    }
}
