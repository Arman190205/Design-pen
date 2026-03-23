public class Main {
    public static void main(String[] args) {
        Pen pen = PenFactory.createBallpoint("blue");
        System.out.println(pen);

        pen.uncap();
        try {
            pen.write("Hello World");
            System.out.println("Wrote text.");
        } catch (InkEmptyException | IllegalStateException e) {
            System.out.println("Write error: " + e.getMessage());
        }

        System.out.println("Ink left: " + pen.getInkLevel() + " (" + pen.getInkPercentage() + "% )");

        pen.cap();
        try {
            pen.write("Should fail");
        } catch (Exception e) {
            System.out.println("Expected capped error: " + e.getMessage());
        }

        pen.uncap();
        try {
            pen.write("A quick brown fox jumps over the lazy dog");
        } catch (InkEmptyException e) {
            System.out.println("Ink empty during writing: " + e.getMessage());
        }

        System.out.println(pen);
        pen.refill();
        System.out.println("After refill: " + pen);
    }
}
