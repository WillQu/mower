package willmann.mower;

import java.util.List;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import willmann.mower.MowerInstructions.BadInstructionsException;

public final class MowerApp {

    public static void main(final String[] args) {
        try {
            final InputStream input;
            if(args.length > 0) {
                input = new FileInputStream(args[0]);
            } else {
                input = System.in;
            }

            final List<MowerInstructions> instructions = MowerInstructions.readInstructions(input);
            for(final MowerInstructions instruction : instructions) {
                System.out.println(instruction.executeInstructions());
            }
        } catch(final FileNotFoundException e) {
            System.err.println("Impossible de lire le fichier");
            System.exit(1);
        } catch(final BadInstructionsException e) {
            System.err.println("Fichier d'instructions invalide");
            System.exit(2);
        }
    }
}
