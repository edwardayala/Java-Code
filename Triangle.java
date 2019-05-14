// Edward Ayala - P6 Triangle

//Triangle class
class Triangle {
  private Point p1, p2, p3;  //instance variables: three Point objects 
  
  final double error = 0.0001; //tolerance error when comparing two double precision numbers.
  
  //Constructors
  public Triangle() {
      this.p1 = new Point(0,0);
      this.p2 = new Point(1,1);
      this.p3 = new Point(2,5);
  }

  //Given the x, y coordinates of three points: (x1, y1), (x2, y2), and (x3, y3)
  public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
      this.p1 = new Point(x1,y1);
      this.p2 = new Point(x2,y2);
      this.p3 = new Point(x3,y3);
  }


//  //Given three Point objects: p1, p2, and p3
    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    //Getters
    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public Point getP3() {
        return p3;
    }

    //Setters
    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public void setP3(Point p3) {
        this.p3 = p3;
    }

    //Calculate the perimeter of a triangle
  public double getPerimeter() {
      return p1.distance(p2)+p2.distance(p3)+p3.distance(p1);
  }

  //Calculate the area of a triangle  
  public double getArea() {
      return Math.abs(((p1.getX()*(p2.getY() - p3.getY()))
                    + ((p2.getX()*(p3.getY() - p1.getY())))
                    + ((p3.getX()*(p1.getY() - p2.getY()))))/2);
  }

  //Return true if this triangle contains a point, say, p(x, y). 
  //In other words, a point, say, p(x, y) is inside this triangle.  
  public boolean contains(double x, double y) {
	  //Algorithm to be used:
	  //Check if the sum of three smaller triangles formed by the sides of the 
	  //containing triangle and the lines connecting the point p(x, y) with 
	  //the three end points of the containing triangle is equal to the area 
	  //of the containing triangle. Return true if so, otherwise false.
      Point p = new Point(x,y);
      Triangle t1 = new Triangle(p,p1,p2);
      Triangle t2 = new Triangle(p,p1,p3);
      Triangle t3 = new Triangle(p,p2,p3);

      double pArea = getArea();
      double t1Area = t1.getArea();
      double t2Area = t2.getArea();
      double t3Area = t3.getArea();

      return Math.abs(t1Area + t2Area + t3Area - pArea) < error;
  }
  

  //Return true if a triangle t is contained in this triangle
  public boolean contains(Triangle t) {    
    //If a triangle t is contained in this triangle, its three points must be contained in this triangle
      return this.contains(t.p1.getX(), t.p1.getY())
              && (this.contains(t.p2.getX(), t.p2.getY()))
              && (this.contains(t.p3.getX(), t.p3.getY()));
	}
  
  //Return true if a triangle t overlaps with this triangle
  public boolean overlaps(Triangle t) {    
    //Two triangles overlap each other if one is inside the other (check if A.contains(B) or B.contains(A)) or 
	//a side in one triangle intersects a side in the other triangle (nine combinations)
      Line l1 = new Line(p1.getX(),p1.getY(),p2.getX(),p2.getY());
      Line l2 = new Line(p2.getX(),p2.getY(),p3.getX(),p3.getY());
      Line l3 = new Line(p1.getX(),p1.getY(),p3.getX(),p3.getY());
      Line t1 = new Line(t.p1.getX(),t.p1.getY(),t.p2.getX(),t.p2.getY());
      Line t2 = new Line(t.p2.getX(),t.p2.getY(),t.p3.getX(),t.p3.getY());
      Line t3 = new Line(t.p1.getX(),t.p1.getY(),t.p3.getX(),t.p3.getY());
      boolean lineIntersect = (t1.intersectsLine(l1) || t1.intersectsLine(l2) ||
                               t1.intersectsLine(l3) || t2.intersectsLine(l1) ||
                               t2.intersectsLine(l2) || t2.intersectsLine(l3) ||
                               t3.intersectsLine(l1) || t3.intersectsLine(l2) ||
                               t3.intersectsLine(l3));
      boolean triContains = this.contains(t) || t.contains(this);
      return lineIntersect || triContains;
  }
  
  //Print the three points of this triangle
  public void print()
  {
      System.out.println("Three points are: ");
      p1.print();
      p2.print();
      p3.print();
  }
}

//Line class
class Line {
	private Point p1, p2;
    final double error = 0.0001; //tolerance error when comparing two double precision numbers.
    
	//Constructor 
	Line(double x1, double y1, double x2, double y2) {
        p1 = new Point(x1,y1);
        p2 = new Point(x2,y2);
	}

    void print(){
		p1.print();
		p2.print();
	}
	
	//Return true if a point p is on this line
	boolean contains(double x, double y) {
	//Assume the two end points of this line are A and B.
	//If a point P is on this line AB, then |AP| + |PB| = |AB|. |...| represents distance between two points.
        Point p = new Point(x,y);
        return (p1.distance(p) + p.distance(p2) - p1.distance(p2)) < error;
	}
	
	//Return true if "this" line segment intersects "line" segment.
	boolean intersectsLine(Line line){
		double a =  (this.p1.getY() - this.p2.getY());
		double b = -(this.p1.getX() - this.p2.getX());
		double c =  (line.p1.getY() - line.p2.getY());
		double d = -(line.p1.getX() - line.p2.getX());
		double e = (this.p1.getY() - this.p2.getY()) * this.p1.getX() - (this.p1.getX() - this.p2.getX()) * this.p1.getY();
		double f = (line.p1.getY() - line.p2.getY()) * line.p1.getX() - (line.p1.getX() - line.p2.getX()) * line.p1.getY();

		double detA = a * d - b * c;
		
		if (detA == 0) {
		  //System.out.println("The two lines are parallel");
		  return false;
		}
		else // check the intersection point is on the both lines 
		{
		  double x = (e * d - b * f) / detA;
		  double y = (a * f - e * c) / detA;
		  //System.out.printf("The intersecting point is at (%.5f,  %.5f)\n", x, y);

            return this.contains(x, y) && line.contains(x, y);
		}
	}
}

//Point class
class Point {
  private double x;
  private double y;

  //Constructor
  public Point(double x, double y) {
      this.x = x;
      this.y = y;
  }

  //Print the coordinates of a point
  void print()
  {
	  System.out.println("(" + x + ", " + y + ")");
  }

  //Calculate the distance between two points
  public double distance(Point secondPoint) {
    return distance(this, secondPoint);
  }

  //Calculate the distance between two points. This is a class method
  public static double distance(Point p1, Point p2) {
      return (Math.sqrt((Math.pow(p2.x - p1.x,2))+Math.pow(p2.y - p1.y,2)));
  }

  //Getters
  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }
}
