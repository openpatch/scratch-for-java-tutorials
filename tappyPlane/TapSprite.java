package tappyPlane;

import org.openpatch.scratch.Sprite;

public class TapSprite extends Sprite {
    public TapSprite() {
        this.addCostume("tap", "tappyPlane/assets/tap.png");
        this.addCostume("tapTick", "tappyPlane/assets/tapTick.png");
    }

    public void run() {
        if (this.getTimer().everyMillis(400)) {
            this.nextCostume();
        }
    }

}
