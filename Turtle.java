import org.openpatch.scratch.*;

void main() {
    var window = new Window(800, 800);
    var stage = new Stage();
    var turtle = new Sprite();

    stage.add(turtle);
    window.setStage(stage);

    turtle.setX(-250);
    turtle.getPen().down();
    turtle.getPen().setSize(10);
    for (int i = 0; i < 36; i++) {
        turtle.move(500);
        turtle.turnLeft(170);
        turtle.getPen().changeColor(10);
    }
}