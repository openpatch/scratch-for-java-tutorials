package tappyPlane;

import org.openpatch.scratch.Window;

public class Game extends Window {

    public Game() {
        super(800, 480);
        this.setStage(new WelcomeStage());
        this.setDefaultFont("tappyPlane/assets/kenvector_future.ttf");
    }

    public static void main(String[] args) {
        new Game();
    }

}
