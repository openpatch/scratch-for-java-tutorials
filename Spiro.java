import org.openpatch.scratch.*;

class Hole extends Pen {
  double offsetX;

  public Hole() {
    this.setSize(10);
    this.changeColor(Random.randomInt(20, 200));
  }
}

class Gear extends Sprite {
  double R, r; // ring radius, gear radius
  double theta = 0;
  double speed = 0.02;
  Hole[] holes;
  int ringRatio, gearRatio;
  boolean inside;

  private static final double[] SIZES = { 80, 120, 160 };

  public Gear(int sizeIndex, int ringRatio, int gearRatio, boolean inside) {
    this.ringRatio = ringRatio;
    this.gearRatio = gearRatio;
    this.inside = inside;
    this.hide();

    this.setSize(SIZES[sizeIndex % 3]);

    this.holes = new Hole[Random.randomInt(1, 4)];
  }

  @Override
  public void whenAddedToStage() {
    var stage = this.getStage();
    r = 200;
    R = r * ringRatio / gearRatio;

    // Calculate max pattern radius and scale to fit window
    double maxHoleDistance = inside ? (R - r) : r;
    double maxPatternRadius = inside ? (R - r) + maxHoleDistance : R + r + maxHoleDistance;
    double availableRadius = stage.getWidth() / 2 - 50;

    if (maxPatternRadius > availableRadius) {
      double scale = availableRadius / maxPatternRadius;
      R *= scale;
      r *= scale;
      maxHoleDistance *= scale;
    }

    // Create holes at different distances
    for (int i = 0; i < holes.length; i++) {
      holes[i] = new Hole();
      double fraction = 0.3 + (0.7 * (i + 1) / holes.length);
      holes[i].offsetX = maxHoleDistance * fraction;
      stage.add(holes[i]);
    }
  }

  @Override
  public void run() {
    theta += speed;

    double x, y, gearRotation;
    if (inside) {
      x = (R - r) * Math.cos(theta);
      y = (R - r) * Math.sin(theta);
      gearRotation = -theta * (R / r);
    } else {
      x = R * Math.cos(theta);
      y = R * Math.sin(theta);
      gearRotation = theta * (R / r);
    }

    this.setPosition(x, y);
    this.setDirection(-Math.toDegrees(gearRotation));

    for (int i = 0; i < holes.length; i++) {
      double holeX = x + holes[i].offsetX * Math.cos(gearRotation);
      double holeY = y + holes[i].offsetX * Math.sin(gearRotation);
      holes[i].setPosition(holeX, holeY);
      holes[i].down();
    }
  }
}

Gear randomGear() {
  return new Gear(
      Random.randomInt(0, 2),
      Random.randomInt(5, 20),
      Random.randomInt(1, 10),
      Random.randomInt(1) == 1);
}

class SpiroStage extends Stage {
  @Override
  public void run() {
    if (this.getTimer().everyMillis(30000)) {
      this.eraseAll();
      this.removeAll();
      this.add(randomGear());
    }
  }
}

void main() {
  var window = new Window(1080, 1080);
  var stage = new SpiroStage();

  stage.add(randomGear());

  window.setStage(stage);
}
