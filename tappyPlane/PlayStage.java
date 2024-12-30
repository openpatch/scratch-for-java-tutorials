package tappyPlane;

import org.openpatch.scratch.Operators;
import org.openpatch.scratch.Stage;
import org.openpatch.scratch.Window;
import org.openpatch.scratch.extensions.math.Random;
import org.openpatch.scratch.extensions.text.Text;
import org.openpatch.scratch.extensions.text.TextAlign;

enum PlayState {
    PLAYING,
    GAME_OVER
}

public class PlayStage extends Stage {
    private PlaneSprite plane;
    private final double startSpeed = 2;
    private double speed = startSpeed;
    private GroundSprite lastGround;
    private RockSprite lastRock;
    private PlayState state = PlayState.PLAYING;
    private Text scoreText;
    private int score = 0;

    public PlayStage() {
        this.addBackdrop("clouds", "tappyPlane/assets/background.png", true);
        plane = new PlaneSprite();
        this.add(plane);
        plane.setIsFlying(true);
        plane.setX(-200);

        scoreText = new Text();
        this.add(scoreText);
        scoreText.setPosition(-this.getWidth() / 2 + 20, this.getHeight() / 2 - 20);
        scoreText.setAlign(TextAlign.LEFT);

        this.appendGround();
        this.appendGround();

        this.appendRock();
    }

    public double getSpeed() {
        return speed;
    }

    public void appendGround() {
        var ground = new GroundSprite(this);
        var offsetX = 0.0;
        if (lastGround != null) {
            offsetX = lastGround.getX() + lastGround.getWidth() - speed;    
        }
        ground.setPosition(offsetX, -this.getHeight() / 2 + ground.getHeight() / 2);
        this.add(ground);
        lastGround = ground;
    }

    public void appendRock() {
        var rock = new RockSprite(this);
        var offsetX = 2000.0;
        if (lastRock != null) {
            offsetX += lastRock.getX() + lastRock.getWidth() + 200;
        }
        rock.setX(offsetX);

        if (Random.randomInt(1) == 0) {
            rock.setY(-this.getHeight() / 2 + rock.getHeight() / 2);
        } else {
            rock.setY(this.getHeight() / 2 - rock.getHeight() / 2);
            rock.turnLeft(180);
        }
        this.add(rock);
        lastRock = rock;
    }

    public void runPlaying() {
        this.speed += 0.005;
        this.score = Operators.round((this.speed - this.startSpeed) * 10);
        if (plane.getY() + 100 < -this.getHeight() / 2 ||
        plane.getY() - 50 > this.getHeight() / 2) {
            this.state = PlayState.GAME_OVER;
        }

        if (plane.isTouchingSprite(RockSprite.class)) {
            this.state = PlayState.GAME_OVER;
        }
    }

    public void runGameOver() {
        this.speed = 0;
        plane.setIsFlying(false);
        if (this.getTimer().afterMillis(1000)) {
            Window.getInstance().setStage(new GameOverStage(score));
        }
    }

    public void run() {
        scoreText.showText("Score: " + score);
        switch(state) {
            case PLAYING:
                this.runPlaying();
                break;
            case GAME_OVER:
                this.runGameOver();
                break;
        }

    }
}
