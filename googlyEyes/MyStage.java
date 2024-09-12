package googlyEyes;

import org.openpatch.scratch.Stage;
import org.openpatch.scratch.extensions.math.Random;

public class MyStage extends Stage {
    public MyStage() {
        super(true, "googly-eyes/assets");

        this.setColor(100, 100, 100);

        for (int i = 0; i < 50; i++) {
            var eye = new Eye();
            eye.setSize(Random.randomInt(10, 30));
            this.add(eye);
            do {
                eye.setX(Random.random(-this.getWidth() / 2.0, this.getWidth() / 2.0));
                eye.setY(Random.random(-this.getHeight() / 2.0, this.getHeight() / 2.0));
            } while (eye.isTouchingSprite(Eye.class));
        }
    }

    public static void main(String[] args) {
        new MyStage();
    }
}