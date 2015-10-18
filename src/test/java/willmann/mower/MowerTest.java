package willmann.mower;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import willmann.mower.Mower;
import willmann.mower.Mower.Orientation;

/**
 * Tests for the mower class
 */
public final class MowerTest {

    @Test
    public void moveForward() {
        final Mower mower = new Mower(0, 0, Orientation.NORTH).moveForward();

        assertEquals(new Mower(0, 1, Orientation.NORTH), mower);
    }

    @Test
    public void turnLeft() {
        final Mower mower = new Mower(0, 0, Orientation.NORTH).turnLeft();

        assertEquals(new Mower(0, 0, Orientation.WEST), mower);
    } 

    @Test
    public void turnRight() {
        final Mower mower = new Mower(0, 0, Orientation.NORTH).turnRight();

        assertEquals(new Mower(0, 0, Orientation.EAST), mower);
    } 
}
