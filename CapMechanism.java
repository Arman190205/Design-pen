public class CapMechanism implements PenMechanism {
    @Override
    public void start() {
        System.out.println("Removing cap to start writing...");
    }

    @Override
    public void close() {
        System.out.println("Putting cap back to close the pen...");
    }
    
}
