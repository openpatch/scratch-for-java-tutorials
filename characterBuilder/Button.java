package characterBuilder;

import org.openpatch.scratch.Sprite;

public class Button extends Sprite {
  public Button() {
    this.addCostume("left", "characterBuilder/assets/tile_ramp_left.png");
    this.addCostume("right", "characterBuilder/assets/tile_ramp_right.png");
    this.setSize(30);
  }

  public void run() {
    if (this.getCurrentCostumeName().equals("left")) {
      this.setDirection(90 - 45);
    } else {
      this.setDirection(90 + 45);
    }
  }
}
