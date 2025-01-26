package characterBuilder;

import org.openpatch.scratch.Window;

public class Game extends Window {
  public Game() {
    super(800, 600);
    this.setStage(new BuilderStage());
  }

  public static void main(String[] args) {
    new Game();
  }
}
