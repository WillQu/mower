package willmann.mower;

/**
 * This class represents the lawn on which the mowers move.
 *
 * This class is immutable.
 */
public final class Lawn {

    private final int length;
    private final int width;
    private final Mower currentMower;

    /**
     * Creates a new lawn with the specified dimensions and containing the specified mower.
     */
    public Lawn(final int length, final int width, final Mower currentMower) {
        this.length = length;
        this.width = width;
        this.currentMower = currentMower;
    }

    /**
     * @return the mower on the lawn
     */
    public Mower getCurrentMower() {
        return this.currentMower;
    }

    /**
     * Make the mower move forward, unless it would go off the lawn.
     * @return the new state of the lawn.
     */
    public Lawn moveMowerForward() {
        final Mower newMower = getCurrentMower().moveForward();
        if(
            newMower.getX() < 0 ||
            newMower.getX() > this.width ||
            newMower.getY() < 0 ||
            newMower.getY() > this.length) {
            return this;
        }
        return new Lawn(this.length, this.width, newMower);
    }

    /**
     * Turn the mower left
     * @return the new state of the lawn
     */
    public Lawn turnMowerLeft() {
        return new Lawn(this.length, this.width, getCurrentMower().turnLeft());
    }

    /**
     * Turn the mower right
     * @return the new state of the lawn
     */
    public Lawn turnMowerRight() {
        return new Lawn(this.length, this.width, getCurrentMower().turnRight());
    }
}
