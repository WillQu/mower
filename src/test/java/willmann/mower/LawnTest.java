package willmann.mower;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import willmann.mower.Lawn;
import willmann.mower.Mower;
import willmann.mower.Mower.Orientation;

/**
 * Tests for the lawn class
 */
public final class LawnTest {
    
    @Test
    public void moveMowerForward() {
        final Lawn lawn = new Lawn(5, 5, new Mower(3, 4, Orientation.EAST));
        final Lawn result = lawn.moveMowerForward();

        assertEquals(new Mower(4, 4, Orientation.EAST), result.getCurrentMower());
    }

    @Test
    public void preventMovingOut() {
        final Lawn lawn = new Lawn(5, 5, new Mower(5, 4, Orientation.EAST));
        final Lawn result = lawn.moveMowerForward();

        /* The mower can't go out of the lawn, it shouldn't have moved. */
        assertEquals(new Mower(5, 4, Orientation.EAST), result.getCurrentMower());
    } 

}
