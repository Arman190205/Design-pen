public interface WriteStrategy {
    /**
     * Consume ink and return the written string representation.
     * @param text text to write
     * @param reservoir ink reservoir to drain
     * @return written text
     * @throws InkEmptyException if ink is insufficient
     */
    String write(String text, InkReservoir reservoir) throws InkEmptyException;
}
