package googlyEyes;

import org.openpatch.scratch.Stage;
import org.openpatch.scratch.Random;

public class MyStage extends Stage {
    public MyStage() {
        super(480, 360, "googlyEyes/assets");
        this.setColor(100, 100, 100);
        this.addSound("music", "googlyEyes/assets/summer.wav");

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
        this.display("Framerate: " + this.getFrameRate());
        this.playSound("music");
    }

    public static void main(String[] args) {
        new MyStage();
    }
}
