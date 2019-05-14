// Game of Life | Edward Ayala with some help from Jiazhen Yu
// To compile: javac client.java
// To run: java client pattern1.txt
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;

public class client {

    static final int NUM_CELLS = 50;
    static final char LIVE_IMAGE = 'O';
    static final char DEAD_IMAGE = '-';
    static final int NUM_RUNS = 15;
    static final int NUM_DISPLAY = 1;

    public static void main(String [] args) throws FileNotFoundException{
        String inputFileName = args[0];

        int [][] initStates = getInitialStates(inputFileName);

        Grid gd = new Grid(initStates);

        gd.display();
        gd.getStats();
        gd.run();
    }

    public static int [][] getInitialStates(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner input = new Scanner(file);     // Create scanner to read file
        int[][] states;
        int rows = input.nextInt();                   // get rows and cols values from first values of text file
        int cols = input.nextInt();
        // states = new int[rows][cols];           // Create 2d array w/ rows and cols
        states = new int[rows][];
            for (int i = 0; i < rows; i++) {
            states[i] = new int[cols];
            }

        // Read initial states from the input file
        for (int i = 0; i < states.length; i++) {
            for (int j = 0; j < states[0].length; j++) {
                states[i][j] = input.nextInt();
            }
        }
        return states;
        //        return states;
    }
    // If we wanted to add cells on grid randomly, use the following function to generate cell states.
    public static void getInitialStates(int rows, int cols, int [][] states){
        // Create a 2d array for initial state of cells
        states = new int[rows][cols];
        Random rand = new Random();
        int random = rand.nextInt();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (random%100 <= 100*NUM_CELLS/(rows*cols)){
                    states[i][j] = 1;
                }
                else{
                    states[i][j] = 0;
                }
            }
        }
    }
}
