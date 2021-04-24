/*
  Program Objective: Applying all the concepts learnt so far since week 1 especially Hierarchies.
Limitation of this class: Doesn't have a main method so cannot run on its own
 */
/* As needed students can write additional methods and add attributes */

public class ProsperousBiosphere extends Biosphere // Students can't change this inheritance relation.
{
    // Students can make any changes except for the relationship.
    // This initializes the array so that they can be used in this class
    public ProsperousBiosphere(Critter[][] aWorld) {
        super(aWorld);
        array1 = new int[100][2];
        for (int k = 0; k < 100; k++) {
            array1[k][0] = -1;
        }
        array2 = new int[100][2];
        for (int k = 0; k < 100; k++) {
            array2[k][0] = -1;
        }
    }

    public void NeighbourCount(int r, int c) {
        int column;
        int row;
        int counter = 0;
        for (row = r - 1; row < r + 2; row++) {
            for (column = c - 1; column < c + 2; column++) {
                if (row >= 0 && column >= 0 && row < ROWS && column < COLUMNS) {
                    if (current2[row][column].getAppearance() == '*') {
                        counter++;
                    }
                }
            }
        }
        if (counter == 4) {
            if (current2[r][c].getAppearance() == ' ') {
                array1[counteri][0] = r;
                array1[counteri][1] = c;
                counteri++;
            }
        }

    }

    public void NeighbourKill(int r, int c) {
        int column;
        int row;
        int counter = 0;
        for (row = r - 1; row < r + 2; row++) {
            for (column = c - 1; column < c + 2; column++) {
                if (row >= 0 && column >= 0 && row < ROWS && column < COLUMNS) {
                    if (current2[row][column].getAppearance() == '*') {
                        counter++;
                    }
                }
            }
        }
        if (((counter > 5 | counter < 2) && current2[r][c].getAppearance() == '*')) {
            array2[counting][0] = r;
            array2[counting][1] = c;
            counting++;
        }
    }

}
