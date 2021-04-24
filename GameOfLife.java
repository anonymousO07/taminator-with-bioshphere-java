
/*
  Program Objective: Applying all the concepts learnt so far since week 1 especially Hierarchies.
  Limitation of this class: Doesn't have a main method so cannot run on its own
 */
import java.util.Scanner;

/* No additional methods and nor attributes to be added. */
/*
Features of the program:
Uses the File I/O classes to read the starting positions from file and displays the 3 states of the world side by side
The starting positions read in from the file can be used to create a 'ProsperousBiosphere'.
 */
public class GameOfLife {
    public static void main(String[] args) {
        // Start of code written by James Tam, students can freely modify (but still
        // need to
        // fulfill assignment requirements and stylistic approaches).
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 'p' or 'P' for Prosperous Biosphere and 'r' or 'R' for Regular Biosphere: ");
        String inputValue = input.nextLine();
        if (inputValue.equals("p") | inputValue.equals("P")) {
            System.out.println("Running Prosperous Biosphere");
            ProsperousBiosphere smart;
            smart = new ProsperousBiosphere(FileInitialization.read());
            smart.runTurn();
        }

        if (inputValue.equals("r") | inputValue.equals("R") | inputValue.equals("")) {
            System.out.println("Running Regular Biosphere");
            Biosphere regular;
            regular = new Biosphere(FileInitialization.read());
            regular.runTurn();
        }

    }
}
