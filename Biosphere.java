/*
  Program Objective: Applying all the concepts learnt so far since week 1 especially Hierarchies.
Features of the program: This is the most essential part of the program as this accounts for the main functions that run.
Limitation of this class:Doesn't have a main method so cannot run on its own
 */

/* As needed students can write additional methods and add attributes */

import java.util.Scanner;

public class Biosphere<check> {
    // Constant declarations and attributes by James Tam, don't change.
    // Declaration of contants and attributes so that they could be used by the
    // parent as well as the child Class
    public static final int ROWS = 10;
    public static final int COLUMNS = 10;
    public static final String HORIZONTAL_LINE = "  - - - - - - - - - -";
    public static final String HORIZONTAL_COUNT = "  0 1 2 3 4 5 6 7 8 9 ";
    private Critter[][] current;
    protected Critter[][] current2;
    protected Critter[][] currentlam;
    protected int[][] array1;
    protected int counteri = 0;
    protected int counting = 0;
    protected int[][] array2;
    Taminator tam = new Taminator();
    boolean debug = false;

    // Original code written by James Tam, don't modify
    public Biosphere(Critter[][] aWorld) {
        // Original code
        current = aWorld;

        // Student code
        // These are used to set the critter arrays to each other so that when printed
        // they get updated to the values of each other.
        current2 = new Critter[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                current2[i][j] = new Critter(current[i][j].getAppearance());
            }
        }
        currentlam = new Critter[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                currentlam[i][j] = new Critter(current2[i][j].getAppearance());
            }
        }

    }

    // The code used by the student was based on the display code written by James
    // Tam
    // I have made changes in the display code so that it prints the output side by
    // side and then it also prints the rest of the details.
    public void display() {
        counteri = 0;
        counting = 0;
        System.out.printf("  PREVIOUS GENERATION" + "%36s", "BIRTHS AND DEATHS");
        System.out.printf("" + "%32s", "TAMINATOR");

        System.out.println();
        int k;
        int r;
        int c;
        // System.out.println(" PREVIOUS GENERATION");
        System.out.printf(HORIZONTAL_COUNT + "%37s", HORIZONTAL_COUNT);
        System.out.printf("" + "%37s", HORIZONTAL_COUNT);
        System.out.println();
        System.out.print(" ");

        for (k = 0; k < ROWS; k++)
            System.out.print(" -"); // Line of dashes before the array
        System.out.printf("%17s", " ");
        for (k = 0; k < ROWS; k++)
            System.out.print(" -"); // Line of dashes before the array
        System.out.printf("%17s", " ");
        for (k = 0; k < ROWS; k++)
            System.out.print(" -"); // Line of dashes before the array
        System.out.println();
        for (r = 0; r < ROWS; r++) {
            System.out.print(r); // Line # before each row
            for (c = 0; c < COLUMNS; c++) {
                System.out.print("|" + current[r][c]); // Bounding line left of array element
            }
            System.out.print("|");
            System.out.print("               ");
            System.out.print(r);
            for (c = 0; c < COLUMNS; c++) {
                System.out.print("|" + current2[r][c]); // Bounding line left of array element
            }
            System.out.print("|"); // Bounding line at the of the row for the last element
            System.out.print("               ");
            System.out.print(r);
            for (c = 0; c < COLUMNS; c++) {
                System.out.print("|" + currentlam[r][c]); // Bounding line left of array element
            }
            System.out.println("|");
            System.out.print(" ");
            for (k = 0; k < ROWS; k++) {
                System.out.print(" -"); // Bounding line below each array element
            }
            System.out.printf("%17s", " ");
            for (k = 0; k < ROWS; k++) {
                System.out.print(" -"); // Bounding line below each array element
            }
            System.out.printf("%17s", " ");
            for (k = 0; k < ROWS; k++) {
                System.out.print(" -"); // Bounding line below each array element
            }
            System.out.println();
        }

    }

    public void addCritter() {
        int row;
        int r;
        int c;
        for (row = 0; row < 100; row++) {
            if (array1[row][0] != -1) {
                r = array1[row][0];
                c = array1[row][1];
                current2[r][c] = new Critter('*');
                if (debug) {
                    System.out.println("Added critter at r:" + r + "   c:" + c);
                }
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
        if (((counter > 4 | counter < 3) && current2[r][c].getAppearance() == '*')) {
            array2[counting][0] = r;
            array2[counting][1] = c;
            counting++;
        }
    }

    // the Taminator class and this decide to move and kill from the Taminator
    public void MoveTamo() {

        int nocurren = -1;
        int currencycs = -1;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                currentlam[i][j] = new Critter(current2[i][j].getAppearance());
            }
        }

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (current2[i][j].getAppearance() == 'T') {
                    nocurren = i;
                    currencycs = j;
                    if (debug) {
                        System.out.println("current taminator is at: " + nocurren + "/" + currencycs);
                    }
                }
            }
        }
        if (nocurren != -1 && currencycs != -1) {
            int[][] none;
            none = tam.ExterminateNeighbours(nocurren, currencycs);
            for (int i = 0; i < 8; i++) {
                int r = none[i][0];
                int c = none[i][1];
                if (r < 10 && r >= 0 && c < 10 && c >= 0) {
                    currentlam[r][c].setAppearance(' ');
                }
            }
        }
        while (0 < 1) {
            int row = tam.randomMovement();
            int column = tam.randomMovement();

            if (currentlam[row][column].getAppearance() == ' ' && nocurren != -1 && currencycs != -1) {
                currentlam[row][column] = new Taminator('T');
                currentlam[nocurren][currencycs].setAppearance(' ');
                break;
            }
        }

    }

    public void TaminatorCheck() {
        for (int k = 0; k < 10; k++) {
            for (int j = 0; j < 10; j++) {
                currentlam[k][j].setAppearance(current2[k][j].getAppearance());
            }
        }
        for (int k = 0; k < 10; k++) {
            for (int j = 0; j < 10; j++) {

                if (currentlam[k][j].getAppearance() == 'T') {
                    MoveTamo();
                }
            }
        }
    }

    public Critter[][] getCurrent() {
        return (current);
    }

    public void CritterCheck() {

        array1 = new int[100][2];
        for (int k = 0; k < 100; k++) {
            array1[k][0] = -1;
        }
        array2 = new int[100][2];
        for (int k = 0; k < 100; k++) {
            array2[k][0] = -1;
        }

        for (int k = 0; k < 10; k++) {
            for (int j = 0; j < 10; j++) {
                if ((current2[k][j].getAppearance() == ' ')) {
                    NeighbourCount(k, j);
                }
            }
        }

        // places suitable for the death of a critter
        for (int k = 0; k < 10; k++) {
            for (int j = 0; j < 10; j++) {
                if ((current2[k][j].getAppearance() == '*')) {
                    NeighbourKill(k, j);
                }
            }
        }

        addCritter();
        Killer();
        TaminatorCheck();
    }

    // it is being printed out

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
        if (counter == 3) {
            if (current2[r][c].getAppearance() == ' ') {

                array1[counteri][0] = r;
                array1[counteri][1] = c;
                counteri++;
            }
        }
    }

    public void Killer() {
        int row;
        int r;
        int c;
        for (row = 0; row < 100; row++) {
            if (array2[row][0] != -1) {
                r = array2[row][0];
                c = array2[row][1];
                current2[r][c] = new Critter(' ');
                if (debug) {
                    System.out.println("Killed critter at r:" + r + "   c:" + c);
                }
            }
        }
    }

    public void runTurn() {
        int y = 0;
        String endingCode = " ";

        Scanner Lmn = new Scanner(System.in);
        while (true) {
            if (y != 0) {
                System.out.println(
                        "Enter key to continue. Type 'Q' or 'q' to Terminate the code. Type 'd' or 'D' for debug mode");
                endingCode = Lmn.nextLine();
                if (endingCode.equals("Q") | endingCode.equals("q")) {
                    break;
                }
                if (endingCode.equals("D") | endingCode.equals("d")) {
                    debug = true;
                }
            }

            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLUMNS; j++) {
                    current[i][j] = new Critter(currentlam[i][j].getAppearance());
                    current2[i][j] = new Critter(currentlam[i][j].getAppearance());
                }
            }
            CritterCheck();
            display();
            debug = false;
            y++;

        }
    }
}
