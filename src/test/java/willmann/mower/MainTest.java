package willmann.mower;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import willmann.mower.Lawn;
import willmann.mower.Mower;
import willmann.mower.Mower.Orientation;

/**
 * Main test
 */
public final class MainTest {
    
    @Test
    public void mainTest() {
        Lawn lawn = new Lawn(5, 5, new Mower(1, 2, Orientation.NORTH));
        lawn = lawn
            .turnMowerLeft()
            .moveMowerForward()
            .turnMowerLeft()
            .moveMowerForward()
            .turnMowerLeft()
            .moveMowerForward()
            .turnMowerLeft()
            .moveMowerForward()
            .moveMowerForward();
        assertEquals(new Mower(1, 3, Orientation.NORTH), lawn.getCurrentMower());

        lawn = new Lawn(5, 5, new Mower(3, 3, Orientation.EAST));
        lawn = lawn
            .moveMowerForward()
            .moveMowerForward()
            .turnMowerRight()
            .moveMowerForward()
            .moveMowerForward()
            .turnMowerRight()
            .moveMowerForward()
            .turnMowerRight()
            .turnMowerRight()
            .moveMowerForward();
        assertEquals(new Mower(5, 1, Orientation.EAST), lawn.getCurrentMower());
    }
}
