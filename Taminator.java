
/*Program Objective: Applying all the concepts learnt so far since week 1 especially Hierarchies.
  Limitation of this class:No Limitations as of such
As needed students can write additional methods and add attributes */

import java.util.Random;

public class Taminator extends Critter {
    // Class attribute by James Tam. Students do not make any changes to it but
    // additional attributes may be added.
    public static final char DEFAULT_APPEARANCE = 'T';
    private int[][] array1;

    // Start of modifiable code written by James Tam
    // Taminator(), Taminator(char)
    // Students can make any changes.
    public Taminator() {
        super(DEFAULT_APPEARANCE);
    }

    public Taminator(char newAppearance) {
        super(newAppearance);
    }
    // End of modifiable code written by James Tam

    // Students can add additional methods below as needed.
    // random location

    // clears the area around the Taminator
    public int[][] ExterminateNeighbours(int i, int j) {
        array1 = new int[8][2];
        int c = 0;

        int column;
        int row;
        for (row = i - 1; row < i + 2; row++) {
            for (column = j - 1; column < j + 2; column++) {
                if (row >= 0 && column >= 0 && row < Biosphere.ROWS && column < Biosphere.COLUMNS)
                    if (column == j && row == i) {
                        continue;
                    }
                array1[c][0] = row;
                array1[c][1] = column;

                c++;
            }
        }

        return array1;
    }

    public int randomMovement() {
        Random rand = new Random();
        return rand.nextInt(Biosphere.ROWS);
    }
}
