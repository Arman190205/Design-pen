class PenFactory {

    public static IPen getPen(String type, String color, String mechanismType) {

        PenMechanism mechanism;

        if (mechanismType.equals("with-cap")) {
            mechanism = new CapMechanism();
        } else {
            mechanism = new ClickMechanism();
        }

        if (type.equals("ball-pen")) {
            return new BallPen(color, mechanism);
        } else if (type.equals("ink-pen")) {
            return new FountainPen(color, mechanism);
        }

        throw new IllegalArgumentException("Invalid pen type");
    }
}