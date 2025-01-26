package characterBuilder;

import org.openpatch.scratch.MouseCode;
import org.openpatch.scratch.Stage;

public class BuilderStage extends Stage {

  private Character character;
  private Button faceNextButton;
  private Button facePrevButton;

  public BuilderStage() {
    character = new Character();
    this.add(character);

    faceNextButton = new Button();
    faceNextButton.changeX(100);
    this.add(faceNextButton);

    facePrevButton = new Button();
    facePrevButton.changeX(-100);
    facePrevButton.switchCostume("right");
    this.add(facePrevButton);
  }

  @Override
  public void whenMouseClicked(MouseCode code) {
    if (code == MouseCode.LEFT && faceNextButton.isTouchingMousePointer()) {
      character.getFace().nextCostume();
    }
    if (code == MouseCode.LEFT && facePrevButton.isTouchingMousePointer()) {
      character.getFace().previousCostume();
    }
    if (code == MouseCode.LEFT && character.getBody().isTouchingMousePointer()) {
      character.getBody().nextCostume();
    }
    if (code == MouseCode.RIGHT && character.getBody().isTouchingMousePointer()) {
      character.getBody().previousCostume();
    }
  }
}
