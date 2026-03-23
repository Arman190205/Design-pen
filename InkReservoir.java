public interface InkReservoir {
    int getInkLevel();
    int getMaxInk();
    void consume(int amount) throws InkEmptyException;
    void refill();
    void refill(int amount);
    double getInkPercentage();
}
