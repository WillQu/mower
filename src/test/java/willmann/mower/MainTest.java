package willmann.mower;

import java.util.List;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import willmann.mower.Lawn;
import willmann.mower.Mower;
import willmann.mower.Mower.Orientation;
import willmann.mower.MowerInstructions;
import willmann.mower.MowerInstructions.BadInstructionsException;

/**
 * Main test
 */
public final class MainTest {
    
    @Test
    public void lawnMainTest() {
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

    @Test
    public void completeMainTest() throws BadInstructionsException {
        final String inputString =
            "5 5\n" +
            "1 2 N\n" +
            "GAGAGAGAA\n" +
            "3 3 E\n" +
            "AADAADADDA";
        final InputStream input = new ByteArrayInputStream(inputString.getBytes());
        final List<MowerInstructions> instructions = MowerInstructions.readInstructions(input);

        assertEquals("1 3 N", instructions.get(0).executeInstructions().toString());
        assertEquals("5 1 E", instructions.get(1).executeInstructions().toString());
    }
}
