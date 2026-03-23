public class NonWhitespaceWriteStrategy implements WriteStrategy {
    @Override
    public String write(String text, InkReservoir reservoir) throws InkEmptyException {
        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }

        int consume = 0;
        for (char c : text.toCharArray()) {
            if (!Character.isWhitespace(c)) {
                consume++;
            }
        }

        reservoir.consume(consume);
        return text;
    }
}
