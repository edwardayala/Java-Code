// Game of Life | Edward Ayala

// Coordinate of a cell (square)
public class Coordinate {
    // Properties
    private int _x;
    private int _y;

    // Constructors
    public Coordinate(){
        _x = 0;
        _y = 0;
    }
    public Coordinate(int x, int y){
        _x = x;
        _y = y;
    }

    // Methods
    public int getX(){ return _x; }
    public int getY(){ return _y; }
    public void setX(int anX){ _x = anX; }
    public void setY(int aY){  _y = aY;  }

}
