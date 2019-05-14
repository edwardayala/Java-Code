public class Lines {
    public static class Line {
        private int a,b,c;

        public Line(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public double getSlope(){
            return (double)-a / b;
        }

        public boolean isOnLine(int x, int y){
            return ((a*x) + (b*y) + c == 0);
        }
    }
    public static void main(String [] args){
        Line line1 = new Line(5, 4, -17);
        double slope1 = line1.getSlope();
        boolean onLine1 = line1.isOnLine(5, -2);

        Line line2 = new Line(-25, 40, 30);
        double slope2 = line2.getSlope();
        boolean onLine2 = line2.isOnLine(5, -2);

        System.out.println("Equation: 5x + 4y - 17 = 0");
        System.out.println("Slope: " + slope1);
        System.out.println("Is point (5, -2) on the line? " + (onLine1 ? "true" : "false"));

        System.out.println("Equation: -25x + 40y + 30 = 0");
        System.out.println("Slope: " + slope2);
        System.out.println("Is point (5, -2) on the line? " + (onLine2 ? "true" : "false"));

    }
}
