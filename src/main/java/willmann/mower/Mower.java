package willmann.mower;

/**
 * This class represents a Mower, with its position and orientation.
 *
 * This class is immutable.
 */
public final class Mower {
    private final int x;
    private final int y;
    private final Orientation orientation;

    /**
     * Create a new Mower with the specified x, y and orientation.
     */
    public Mower(final int x, final int y, final Orientation orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    /**
     * @return the x position of this mower
     */
    public int getX() {
        return this.x;
    }

    /**
     * @return the y position of this mower
     */
    public int getY() {
        return this.y;
    }

    /**
     * @return the direction this mower faces.
     */
    public Orientation getOrientation() {
        return this.orientation;
    }

    /**
     * Makes the mower move forward. A new mower is returned, this mower stay unchanged. The new mower will have the same orientation as the original.
     * @return a new Mower moved one square from the original mower, in the direction corresponding to the orientation.
     */
    public Mower moveForward() {
        int newX = this.getX(), newY = this.getY();
        switch(this.orientation) {
            case NORTH:
                newY++;
                break;
            case SOUTH:
                newY--;
                break;
            case EAST:
                newX++;
                break;
            case WEST:
                newX--;
                break;
        }
        return new Mower(newX, newY, getOrientation());
    }
    
    /**
     * Makes the mower turn left.
     * @return a new mower with the same position, turned left.
     */
    public Mower turnLeft() {
        return new Mower(getX(), getY(), getOrientation().left);
    }

    /**
     * Makes the mower turn right.
     * @return a new mower with the same position, turned right.
     */
    public Mower turnRight() {
        return new Mower(getX(), getY(), getOrientation().right);
    }

    @Override
    public boolean equals(final Object object) {
        if(!(object instanceof Mower)) {
            return false;
        }
        final Mower other = (Mower) object;
        return 
            this.x == other.x &&
            this.y == other.y &&
            this.orientation == other.orientation;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = result * prime + this.x;
        result = result * prime + this.y;
        result = result * prime + this.orientation.hashCode();
        return result;
    }

    /**
     * Enumeration corresponding to the possible directions faced by a mower.
     */
    public enum Orientation {
        NORTH,
        SOUTH,
        EAST,
        WEST;

        static {
            NORTH.left = WEST;
            NORTH.right = EAST;

            SOUTH.left = EAST;
            SOUTH.right = WEST;

            EAST.left = NORTH;
            EAST.right = SOUTH;

            WEST.left = SOUTH;
            WEST.right = NORTH;
        }

        private Orientation left;
        private Orientation right;

    }
}
