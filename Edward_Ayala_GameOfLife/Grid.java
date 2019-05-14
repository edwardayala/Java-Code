// Game of Life | Edward Ayala
public class Grid {
    static final int NUM_RUNS = 15;
    static final int NUM_DISPLAY = 1;


    // Properties
    private int rows;
    private int cols;
    private Square [][] _squares;

    // Constructor
    public Grid(int [][] states){
        // Create a 2D array of pointers to squares
        rows = states.length;
        cols = states[0].length;
        _squares = new Cell[rows][cols];

        // For each position(i, j) on the grid, add a cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // to be completed
                char img = (states[i][j] == 1? 'O':'-');
                _squares[i][j] = new Cell(this,new Coordinate(i,j),img, 0);
                _squares[i][j].setLiveInfo((states[i][j] == 1));
            }
        }
    }
    public Grid(){}

    // Methods
    public void run(){
        // Run the simulation generation by generation
        for (int n = 0; n < NUM_RUNS; n++) {
            // Update states of cells on the grid
            for (int i = 1; i < rows-1; i++) {
                for (int j = 1; j < cols-1; j++) {
                    // To be completed
                    _squares[i][j].update();
                }
            }
            // Update the images of cells based whether or not cells will be live.
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    _squares[i][j].setImage((_squares[i][j].getLiveInfo()? 'O':'-'));
                }
            }

            // Display grid every NUM_DISPLAY generations
            if ( n%NUM_DISPLAY == 0){
                System.out.println("\nRuns = " + (n+1));
                display();
                getStats();
                System.out.println();
            }
        }

    }
    public void display(){
        // Print the images of cells on the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                _squares[i][j].print();
            }
            System.out.println();
        }
    }
    public void getStats(){
        int numLiveCells = 0;
        int numDeadCells = 0;

        for (int i = 0; i < _squares.length; i++) {
            for (int j = 0; j < _squares[0].length; j++) {
                // To be completed
                if (_squares[i][j].getLiveInfo())
                    numLiveCells++;
                else
                    numDeadCells++;
            }
        }
        System.out.println("The number of live cells = " + numLiveCells
                       + "\nThe number of dead cells = " + numDeadCells
                       + "\nTotal cells = " + (numLiveCells+numDeadCells));
    }
    public int getRows(){
        return rows;
    }
    public int getCols(){
        return cols;
    }
    public Square getSquare(int x, int y){
        return _squares[x][y];
    }
}
