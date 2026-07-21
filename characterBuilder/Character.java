package characterBuilder;

import org.openpatch.scratch.Sprite;

public class Character extends Sprite {

  private Face face;
  private Body body;

  public Character() {
    body = new Body();
    face = new Face();
  }

  public void whenAddedToStage() {
    this.getStage().add(body);
    this.getStage().add(face);
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
