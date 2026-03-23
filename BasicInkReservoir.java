public class BasicInkReservoir implements InkReservoir {
    private final int maxInk;
    private int ink;

    public BasicInkReservoir(int maxInk) {
        if (maxInk <= 0) {
            throw new IllegalArgumentException("maxInk must be positive");
        }
        this.maxInk = maxInk;
        this.ink = maxInk;
    }

    @Override
    public int getInkLevel() {
        return ink;
    }

    @Override
    public int getMaxInk() {
        return maxInk;
    }

    @Override
    public void consume(int amount) throws InkEmptyException {
        if (amount < 0) {
            throw new IllegalArgumentException("consume amount cannot be negative");
        }
        if (ink <= 0) {
            throw new InkEmptyException("Ink is already empty");
        }
        if (amount > ink) {
            int available = ink;
            ink = 0;
            throw new InkEmptyException("Ink emptied after consuming " + available + " units");
        }
        ink -= amount;
    }

    @Override
    public void refill() {
        ink = maxInk;
    }

    @Override
    public void refill(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("refill amount cannot be negative");
        }
        ink = Math.min(maxInk, ink + amount);
    }

    @Override
    public double getInkPercentage() {
        return Math.round((ink / (double) maxInk) * 1000.0) / 10.0;
    }
}
