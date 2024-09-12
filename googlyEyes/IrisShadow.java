package googlyEyes;

import org.openpatch.scratch.Sprite;

public class IrisShadow extends Sprite {
    private Iris iris;
    public IrisShadow(Iris iris) {
        super();
        this.iris = iris;
        this.addCostume("shadow", "googlyEyes/assets/2.png");
    }

    public void run() {
        this.setPosition(iris.getPosition());
        this.setDirection(iris.getDirection());
    }
}
