package paintSheep;

import org.openpatch.scratch.Window;

public class Game extends Window {
  public Game() {
    super(true);
    this.setStage(new Level());
  }

  public static void main(String[] args) {
    new Game();
  }
}
