package willmann.mower;

public final class Mower {
    private final int x;
    private final int y;
    private final Orientation orientation;

    public Mower(final int x, final int y, final Orientation orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Orientation getOrientation() {
        return this.orientation;
    }

    public Mower moveForward() {
        int newX = this.x, newY = this.y;
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
        return new Mower(newX, newY, this.orientation);
    }

    public enum Orientation {
        NORTH,
        SOUTH,
        EAST,
        WEST;
    }
}
