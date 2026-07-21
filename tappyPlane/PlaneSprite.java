package tappyPlane;

import org.openpatch.scratch.KeyCode;
import org.openpatch.scratch.MouseCode;
import org.openpatch.scratch.Sprite;

public class PlaneSprite extends Sprite {

    private boolean isFlying = false;
    private double gravity = 0.5;
    private double velocity = 0;

    public PlaneSprite() {
        this.addCostume("red1", "tappyPlane/assets/planeRed1.png");
        this.addCostume("red2", "tappyPlane/assets/planeRed2.png");
        this.addCostume("red3", "tappyPlane/assets/planeRed3.png");

        this.setHitbox(26, 54, 2, 15, 30, 17,74, 21, 73, 62);
    }

    public void setIsFlying(boolean isFlying) {
        this.isFlying = isFlying;
    }

    public void whenMouseClicked(MouseCode mouseCode) {
        if (mouseCode == MouseCode.LEFT) {
            this.velocity = 10;
        }
    }

    public void whenKeyPressed(KeyCode keyCode) {
        if (keyCode == KeyCode.SPACE) {
            this.velocity = 10;
        }   
    }

    public void run() {
        if (isFlying && this.getTimer().everyMillis(100)) {
            this.nextCostume();
        }

        if (isFlying) {
            this.velocity -= gravity;
            this.changeY(velocity);
        }
    }

}
