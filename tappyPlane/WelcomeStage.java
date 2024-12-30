package tappyPlane;

import org.openpatch.scratch.Stage;
import org.openpatch.scratch.Window;

public class WelcomeStage extends Stage {
    public WelcomeStage() {
        this.addBackdrop("clouds", "tappyPlane/assets/background.png", true);
        var tap = new TapSprite();
        this.add(tap);
        var tapSign = new TapSignSprite();
        this.add(tapSign);
        tapSign.setPosition(-100, +40);
        tapSign.turnRight(20);
        var getReady = new TextGetReadySprite();
        this.add(getReady);
        getReady.setPosition(0, -80);

        var plane = new PlaneSprite();
        this.add(plane);
        plane.goToBackLayer();
    }

    public void run() {
        if (this.isMouseDown()) {
            Window.getInstance().setStage(new PlayStage());
        }
    }
}
