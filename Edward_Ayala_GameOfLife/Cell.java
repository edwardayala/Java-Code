// Game of Life | Edward Ayala
// Cell.countLiveNeighbors - Assistance from Jiazhen Yu
public class Cell extends Square{
    // Properties
    private char _image;           // For example: cell:0 | square:-
    private int _lifeSpan;         // The number of generations this cell has lived
    private boolean _toBeLive;     // True if this cell will be live next generation
    private int _liveNeighbors = 0;// Used to keep track of the number of live neighbors

    // Constructor
    public Cell( Grid aGrid, Coordinate aCoord, char aImage, int f){
        super(aGrid,aCoord);
        _image = aImage;
        _toBeLive = false;
        _lifeSpan = f;

    }

    // Methods
    public char getImage(){
        return _image;
    }
    public void setImage(char img){
        _image = img;
    }
    public boolean getLiveInfo(){
        return _toBeLive;
    }
    public void setLiveInfo(boolean lf){
        _toBeLive = lf;
    }
    public void reset(){ _liveNeighbors = 0; }
    public int countLiveNeighbors(){
        // Count how many live cells among the eight neighbors using the rules

        // Changed num -> _liveNeighbors : making live neighbors a class property
//        int num = 0;

        Grid g = super.getGrid();
        Coordinate coord = super.getCoordinate();
        int x = coord.getX();
        int y = coord.getY();
        int rows = g.getRows();
        int cols = g.getCols();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (x > 0 && y > 0 && x < rows- 1  && y < cols- 1) {
                    if (g.getSquare(x + i, y + j).getLiveInfo()) {
                        _liveNeighbors++;
                        if (i == 0 && j == 0){
                            _liveNeighbors -= 1;
                        }
                    }
                }
            }
        }
        return _liveNeighbors;
    }
    public void resetLifeSpan(){
        _lifeSpan = 0;
    }
    public void incrementLiveSpan(){
        _lifeSpan++;
    }
    public void update(){
        // Based on the number of live neighbor cells, update the state of each cell
//        int liveNeighbors = countLiveNeighbors();
//       1: Any live cell with fewer than two live neighbours dies, as if caused by under-population.
//       2: Any live cell with two or three live neighbours lives on to the next generation.
//       3: Any live cell with more than three live neighbours dies, as if by overcrowding.
//       4: Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
        if (getLiveInfo()){
            // Rule 1:
            if (_liveNeighbors < 2){
                this.setLiveInfo(false);
                this.resetLifeSpan();
            }
            // Rule 2:
            if (_liveNeighbors == 2 || _liveNeighbors == 3){
                this.setLiveInfo(true);
                this.incrementLiveSpan();
            }
            // Rule 3:
            if (_liveNeighbors > 3){
                this.setLiveInfo(false);
                this.resetLifeSpan();
            }
        }
        else{
            // Rule 4:
            if (_liveNeighbors == 3){
                this.setLiveInfo(true);
                this.incrementLiveSpan();
            }
        }
        reset();
    }
    public void print(){
        countLiveNeighbors();   // Used to keep track of live neighbors per run
        System.out.print(_image + " "); }
}
