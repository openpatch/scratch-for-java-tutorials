package paintSheep;

import org.openpatch.scratch.RotationStyle;
import org.openpatch.scratch.extensions.animation.AnimatedSprite;
import org.openpatch.scratch.extensions.color.Color;
import org.openpatch.scratch.extensions.shape.Ellipse;

public class Sheep extends AnimatedSprite {

    private double speed = 5;
    private double mobility = 4;

    public Sheep(Color color) {
        this.addAnimation("down", "paintSheep/assets/sheep.png", 4, 32, 32, 0);
        this.addAnimation("left", "paintSheep/assets/sheep.png", 4, 32, 32, 1);
        this.addAnimation("up", "paintSheep/assets/sheep.png", 4, 32, 32, 2);
        this.setHitbox(new Ellipse(4, 4, 24, 24));
        this.setSize(250);
        this.setTint(color);
        this.getPen().setColor(color);
        this.getPen().setSize(32);
        this.setRotationStyle(RotationStyle.LEFT_RIGHT);
        this.setOnEdgeBounce(true);
    }

    public void turnLeft() {
        super.turnLeft(mobility);
    }

    public void turnRight() {
        super.turnRight(mobility);
    }

    public void run() {
        this.getPen().down();

        if (this.isTouchingSprite(Sheep.class)) {
            this.turnLeft(180);
        }
        this.move(speed);
        if (this.getDirection() >= 315 || this.getDirection() <= 45) {
            this.playAnimation("up");
        } else if (this.getDirection() > 45 && this.getDirection() < 135) {
            this.playAnimation("left");
        } else if (this.getDirection() >= 135 && this.getDirection() <= 225) {
            this.playAnimation("down");
        } else {
            this.playAnimation("left");
        }
    }
}
