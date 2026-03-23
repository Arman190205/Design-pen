public final class PenFactory {
    private PenFactory() { }

    public static Pen createBallpoint(String color) {
        return new Pen.PenBuilder()
                .color(color)
                .tipSize(0.7)
                .maxInk(100)
                .writeStrategy(new NonWhitespaceWriteStrategy())
                .capBehavior(new SimpleCapBehavior())
                .build();
    }

    public static Pen createGel(String color) {
        return new Pen.PenBuilder()
                .color(color)
                .tipSize(0.5)
                .maxInk(120)
                .writeStrategy(new NonWhitespaceWriteStrategy())
                .capBehavior(new SimpleCapBehavior())
                .build();
    }
}
