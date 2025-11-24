package tappyPlane;

import org.openpatch.scratch.Window;
import org.openpatch.scratch.extensions.text.Text;

public class Game extends Window {

    public Game() {
        super(800, 480);
        this.setStage(new WelcomeStage());
    }

    public static void main(String[] args) {
        Text.DEFAULT_FONT = "tappyPlane/assets/kenvector_future.ttf";
        new Game();
    }

}
