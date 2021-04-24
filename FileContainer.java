
/*
  Program Objective: Applying all the concepts learnt so far since week 1 especially Hierarchies.
Limitation of this class:Doesn't have a main method so cannot run on its own
 */
import java.io.FileReader;
import java.io.BufferedReader;

/*
  Author:  James Tam
  Version: February 16, 2021

*/

public class FileContainer {
    private BufferedReader br;
    private FileReader fr;

    public FileContainer(BufferedReader aBufferedReader, FileReader aFileReader) {
        br = aBufferedReader;
        fr = aFileReader;
    }

    public BufferedReader getBufferedReader() {
        return (br);
    }

    public FileReader getFileReader() {
        return (fr);
    }
}
