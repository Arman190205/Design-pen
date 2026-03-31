class ClickMechanism implements PenMechanism {
    @Override
    public void start() {
        System.out.println("Clicking to start writing...");
    }

    @Override
    public void close() {
        System.out.println("Clicking to close the pen...");
    }
    
}