package googlyEyes;

import org.openpatch.scratch.Sprite;

public class Eye extends Sprite {

    private Iris iris;

    public Eye() {
        super();
        this.addCostume("eye", "googlyEyes/assets/0.png");
        iris = new Iris(this);
    }

    public void setSize(double size) {
        super.setSize(size);
        iris.setSize(size);
    }

    public void whenAddedToStage() {
        this.getStage().add(iris);
    }

    public void whenRemovedFromStage() {
        iris.remove();
    }
}
