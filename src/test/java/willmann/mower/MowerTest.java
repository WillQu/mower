package willmann.mower;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import willmann.mower.Mower;
import willmann.mower.Mower.Orientation;

public final class MowerTest {

    @Test
    public void moveForward() {
        final Mower start = new Mower(0, 0, Orientation.NORTH);
        final Mower end = start.moveForward();

        assertEquals(0, end.getX());
        assertEquals(1, end.getY());
        assertEquals(Orientation.NORTH, end.getOrientation());
    }

}
