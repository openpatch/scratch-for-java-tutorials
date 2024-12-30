package tappyPlane;

import org.openpatch.scratch.Sprite;

public class GroundSprite extends Sprite {

    private PlayStage playStage;

    public GroundSprite(PlayStage playStage) {
        this.playStage = playStage;
        this.addCostume("ground", "tappyPlane/assets/groundGrass.png");
    }

    public void run() {
        if (this.getX() < -playStage.getWidth()) {
            playStage.appendGround();
            this.remove();
        }
        this.changeX(-playStage.getSpeed());
    }
}
