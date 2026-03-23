public class SimpleCapBehavior implements Capable {
    private boolean capped = true;

    @Override
    public void cap() {
        capped = true;
    }

    @Override
    public void uncap() {
        capped = false;
    }

    @Override
    public boolean isCapped() {
        return capped;
    }
}
