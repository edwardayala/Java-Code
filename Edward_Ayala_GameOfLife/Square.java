// Game of Life | Edward Ayala

// A living thing that serves the parent class of Cell class
abstract class Square {
    // Properties
    private Grid _grid;
    private Coordinate _coord;

    // Constructor
    public Square( Grid aGrid, Coordinate aCoord){
        _grid = aGrid;
        _coord = aCoord;
    }

    // Methods
    public Coordinate getCoordinate(){
        return _coord;
    }
    public Grid getGrid(){
        return _grid;
    }

    // Abstract Methods
    abstract boolean getLiveInfo();
    abstract void setLiveInfo(boolean lf);
    abstract char getImage();
    abstract void setImage( char img);
    abstract void print();
    abstract void update();

}
