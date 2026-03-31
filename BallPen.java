public class BallPen implements IPen {
    String color;
    PenMechanism mechanism;
    boolean isOpened = false;
    public BallPen(String color, PenMechanism mechanism) {
        this.color = color;
        this.mechanism = mechanism;
    }
    @Override
    public void write(String text) {
        if(!isOpened) {
            System.out.println("Please start the pen before writing.");
            return;
        }
        System.out.println("Writing with BallPen: " + text);
    }

    @Override
    public void refill(String color) {
        this.color = color;
        System.out.println("Refilling BallPen with color: " + color);
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
