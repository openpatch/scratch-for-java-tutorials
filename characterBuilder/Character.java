package characterBuilder;

import org.openpatch.scratch.Sprite;
import org.openpatch.scratch.Stage;

public class Character extends Sprite {

  private Face face;
  private Body body;

  public Character() {
  }

  public void whenAddedToStage(Stage stage) {
    body = new Body();
    stage.add(body);
    face = new Face();
    stage.add(face);
  }

  public Face getFace() {
    return face;
  }

  public Body getBody() {
    return body;
  }

  public void run() {
    body.setPosition(this.getPosition());
    face.setPosition(this.getPosition());
  }
}
