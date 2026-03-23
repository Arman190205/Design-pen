public class Pen implements Capable, Refillable {
    private final String color;
    private final double tipSize;
    private final InkReservoir inkReservoir;
    private final WriteStrategy writeStrategy;
    private final Capable capBehavior;

    private Pen(PenBuilder builder) {
        this.color = builder.color;
        this.tipSize = builder.tipSize;
        this.inkReservoir = builder.inkReservoir;
        this.writeStrategy = builder.writeStrategy;
        this.capBehavior = builder.capBehavior;
    }

    public String getColor() {
        return color;
    }

    public double getTipSize() {
        return tipSize;
    }

    public int getInkLevel() {
        return inkReservoir.getInkLevel();
    }

    public int getMaxInk() {
        return inkReservoir.getMaxInk();
    }

    public double getInkPercentage() {
        return inkReservoir.getInkPercentage();
    }

    @Override
    public boolean isCapped() {
        return capBehavior.isCapped();
    }

    @Override
    public void cap() {
        capBehavior.cap();
    }

    @Override
    public void uncap() {
        capBehavior.uncap();
    }

    public String write(String text) throws InkEmptyException {
        if (isCapped()) {
            throw new IllegalStateException("Cannot write while pen is capped");
        }
        return writeStrategy.write(text, inkReservoir);
    }

    @Override
    public void refill() {
        inkReservoir.refill();
    }

    @Override
    public void refill(int amount) {
        inkReservoir.refill(amount);
    }

    @Override
    public String toString() {
        return String.format("Pen(color=%s, tipSize=%.2f, ink=%d/%d (%.1f%%), %s)",
                color, tipSize, getInkLevel(), getMaxInk(), getInkPercentage(), isCapped() ? "capped" : "uncapped");
    }

    public static class PenBuilder {
        private String color = "black";
        private double tipSize = 0.7;
        private InkReservoir inkReservoir = new BasicInkReservoir(100);
        private WriteStrategy writeStrategy = new NonWhitespaceWriteStrategy();
        private Capable capBehavior = new SimpleCapBehavior();

        public PenBuilder color(String color) {
            this.color = color;
            return this;
        }

        public PenBuilder tipSize(double tipSize) {
            this.tipSize = tipSize;
            return this;
        }

        public PenBuilder maxInk(int maxInk) {
            this.inkReservoir = new BasicInkReservoir(maxInk);
            return this;
        }

        public PenBuilder inkReservoir(InkReservoir inkReservoir) {
            this.inkReservoir = inkReservoir;
            return this;
        }

        public PenBuilder writeStrategy(WriteStrategy writeStrategy) {
            this.writeStrategy = writeStrategy;
            return this;
        }

        public PenBuilder capBehavior(Capable capBehavior) {
            this.capBehavior = capBehavior;
            return this;
        }

        public Pen build() {
            return new Pen(this);
        }
    }
}

