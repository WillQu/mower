package willmann.mower;

import java.util.List;
import java.util.ArrayList;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;

import willmann.mower.Mower;
import willmann.mower.Mower.Orientation;

/**
 * This class contains methods to read mowers positions and moves from an input stream
 *
 */
public final class MowerInstructions {

    private final Lawn initialPosition;
    private final List<Move> moves;

    public static List<MowerInstructions> readInstructions(final InputStream input) throws BadInstructionsException {
        final List<MowerInstructions> result = new ArrayList<>();
        try {
            final BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            final String[] lawnDimensions = reader.readLine().split(" ");
            if(lawnDimensions.length != 2) {
                throw new BadInstructionsException();
            }

            final int width = Integer.parseInt(lawnDimensions[0]);
            final int length = Integer.parseInt(lawnDimensions[1]);

            String line;
            while((line = reader.readLine()) != null) {
                final Lawn lawn = readLawn(line, length, width);
                line = reader.readLine();
                if(line == null) {
                    throw new BadInstructionsException();
                }
                final List<Move> moves = readMoves(line);
                result.add(new MowerInstructions(lawn, moves));
            }

            return result;
        } catch(final IOException | NumberFormatException e) {
            throw new BadInstructionsException(e);
        }
    }

    private MowerInstructions(final Lawn initialPosition, final List<Move> moves) {
        this.initialPosition = initialPosition;
        this.moves = moves;
    }

    public Mower executeInstructions() {
        Lawn lawn = this.initialPosition;
        for(final Move move : moves) {
            switch(move) {
                case FORWARD: lawn = lawn.moveMowerForward(); break;
                case LEFT: lawn = lawn.turnMowerLeft(); break;
                case RIGHT: lawn = lawn.turnMowerRight(); break;
            }
        }
        return lawn.getCurrentMower();
    }

    private static Lawn readLawn(final String string, final int length, final int width) throws BadInstructionsException {
        final String[] split = string.split(" ");
        if(split.length != 3) {
            throw new BadInstructionsException();
        }
        final int x = Integer.parseInt(split[0]);
        final int y = Integer.parseInt(split[1]);
        final Orientation orientation;
        switch(split[2].charAt(0)) {
            case 'N': orientation = Orientation.NORTH; break;
            case 'S': orientation = Orientation.SOUTH; break;
            case 'W': orientation = Orientation.WEST; break;
            case 'E': orientation = Orientation.EAST; break;
            default: throw new BadInstructionsException();
        }
        return new Lawn(length, width, new Mower(x, y, orientation));
    }

    private static List<Move> readMoves(final String string) throws BadInstructionsException {
        final List<Move> moves = new ArrayList<>();
        for(final char c : string.toCharArray()) {
            switch(c) {
                case 'A': moves.add(Move.FORWARD); break;
                case 'G': moves.add(Move.LEFT); break;
                case 'D': moves.add(Move.RIGHT); break;
                default: throw new BadInstructionsException();
            }
        }
        return moves;
    }

    public enum Move {
        LEFT,
        RIGHT,
        FORWARD;
    }

    public static class BadInstructionsException extends Exception {
        private final static long serialVersionUID = 1L;

        private BadInstructionsException() {
            super();
        }

        private BadInstructionsException(final Exception e) {
            super(e);
        }
    };

}
