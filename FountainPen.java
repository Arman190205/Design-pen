public class FountainPen implements IPen {
    String color;
    PenMechanism mechanism;
    boolean isOpened = false;
    
    public FountainPen(String color, PenMechanism mechanism) {
        this.color = color;
        this.mechanism = mechanism;
    }
    @Override
    public void write(String text) {
        System.out.println("Writing with FountainPen: " + text);
    }

    @Override
    public void refill(String color) {
        this.color = color;
        System.out.println("Refilling FountainPen with color: " + color);
    }

    @Override
    public void start() {
        isOpened = true;
        mechanism.start();
    }

    @Override
    public void close() {
        isOpened = false;
        mechanism.close();
    }
}
