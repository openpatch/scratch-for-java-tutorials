package googlyEyes;

import org.openpatch.scratch.Stage;
import org.openpatch.scratch.extensions.math.Random;
import org.openpatch.scratch.internal.Applet;

public class MyStage extends Stage {
    public MyStage() {
        super(true, "googlyEyes/assets");

        this.setColor(100, 100, 100);

        for (int i = 0; i < 1200; i++) {
            var eye = new Eye();
            eye.setSize(Random.randomInt(10, 50));
            this.add(eye);
            int attempts = 0;
            do {
                eye.goToRandomPosition();
                attempts++;
                if (attempts == 10) {
                    this.remove(eye);
                    break;
                }
            } while (eye.isTouchingSprite(Eye.class));
        }
    }

    public void run() {
        this.display("Framerate: " + Applet.getInstance().frameRate);
    }

    public static void main(String[] args) {
        new MyStage();
    }
}