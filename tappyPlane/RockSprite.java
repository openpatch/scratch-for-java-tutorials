package tappyPlane;

import org.openpatch.scratch.Sprite;

public class RockSprite extends Sprite {

    private PlayStage playStage;

    public RockSprite(PlayStage playStage) {
        this.addCostume("grass", "tappyPlane/assets/rockGrass.png");
        this.playStage = playStage;
        this.setHitbox(0, 240, 66, 0, 108, 240);
    }

    public void run() {
        if (this.getX() < -playStage.getWidth()) {
            playStage.appendRock();
            this.remove();
        }
        this.changeX(-playStage.getSpeed());
    }
}
