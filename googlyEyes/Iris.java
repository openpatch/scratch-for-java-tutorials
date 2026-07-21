package googlyEyes;

import org.openpatch.scratch.Sprite;
import org.openpatch.scratch.Random;

public class Iris extends Sprite {

    private IrisShadow irisShadow;
    private Eye eye;

    public Iris(Eye eye) {
        super();
        this.eye = eye;
        this.addCostume("iris", "googlyEyes/assets/1.png");
        irisShadow = new IrisShadow(this);

        this.setTint(Random.randomInt(255));
    }

    public void setSize(double size) {
        super.setSize(size);
        irisShadow.setSize(size);
    }

    public void whenAddedToStage() {
        this.getStage().add(irisShadow);
    }

    public void whenRemovedFromStage() {
        irisShadow.remove();
    }

    public void run() {
        this.setPosition(
                this.getMouse()
                        .sub(eye.getPosition())
                        .unitVector()
                        .multiply((eye.getWidth() - this.getWidth()) / 2.0 - 50 * eye.getSize() / 100)
                        .add(eye.getPosition()));
        this.pointTowardsMousePointer();
    }
}
