package tappyPlane;

import org.openpatch.scratch.Stage;
import org.openpatch.scratch.Window;
import org.openpatch.scratch.HtmlColor;
import org.openpatch.scratch.Text;

public class GameOverStage extends Stage {

    public GameOverStage(int score) {
        this.addBackdrop("clouds", "tappyPlane/assets/background.png", true);

        this.add(new TextGameOverSprite());

        var text = new Text();
        text.showText("Score: " + score);
        text.setPosition(0, -100);
        text.setTextColor(HtmlColor.DARK_CYAN);
        text.setTextSize(32);
        this.add(text);
    }

    public void run() {
        if (this.isMouseDown()) {
            Window.getInstance().setStage(new WelcomeStage());
        }
    }

}
