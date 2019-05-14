// ImageProcessing C++ -> Java - Edward Ayala
public class ImageProcessing {

    public static class Pixel {
        private int value;
        private int row;
        private int col;
        public GrayImage img;

        public Pixel() {
            value = 0;
        }

        public Pixel(int value, int row, int col, GrayImage img) {
            this.value = value;
            this.row = row;
            this.col = col;
            this.img = img;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }

        public void print(){
            System.out.print("\t" + value + "\t");
        }
    }
    public static class GrayImage {
        private int rows;
        private int cols;
        public Pixel [][] pixels;

        public GrayImage( int [][] arr, int rows, int cols) {
            pixels = new Pixel[rows][];
            for (int i = 0; i < rows; i++)
                pixels[i] = new Pixel [cols];
            this.rows = rows;
            this.cols = cols;
            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < cols; j++)
                {
                    pixels[i][j] = new Pixel(arr[i][j], i, j, this);
                //  pixels[i][j].setValue(arr[i][j]);
                }
            }
        }

        public Pixel getPixel(int x, int y){
            return pixels[x][y];
        }

        public int countWhitePixels(){
            int n = 0; //The number of white pixels (i.e. 255)

            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < cols; j++)
                    if (getPixel(i, j).getValue() == 255)
                        n++;
            }
            return n;
        }

        public void processImage(){
            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < cols; j++)
                {
                    if (i + 2 < rows && j + 2 < cols)
                    {
                        int diffPixel = pixels[i][j].getValue() - pixels[i + 2][j + 2].getValue();

                        if (diffPixel < 0)
                        {
                            pixels[i][j].setValue(0);
                        }
                        else
                        {
                            pixels[i][j].setValue(diffPixel);
                        }
                    }
                }
            }
        }

        public int [] getHistogram(){
            int [] histArr = new int [256];
            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < cols; j++)
                {
                    int pixVal = pixels[i][j].getValue();
                    for (int count = 0; count < 256; count++)
                    {
                        if (count == pixVal)
                            histArr[count]++;
                    }
                }
            }
            System.out.println("Histogram: ");
            for (int i = 0; i < 256; i++)
                System.out.print(histArr[i] + " ");
            System.out.println();
            return histArr;
        }

        public void print(){
            System.out.println("The pixel values of the image are:");

            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < cols; j++)
                {
                    pixels[i][j].print();
                }
                System.out.println();
            }
        }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
    }

    public static void main(String [] args){
        //Create a 2D dynamic array
        int [][] a;
        a = new int [4][];

        for (int i = 0; i < a.length; i++)
            a[i] = new int[5];

        //Input pixel values to a temporary 2D array
        int [][] b = {
            { 221, 184, 178, 84, 135 },
            { 84, 255, 255, 130, 84 },
            { 78, 255, 0, 0, 78 },
            { 84, 130, 255, 130, 84 }
        };

        //Copy to the dynamic array
        for(int i = 0; i < b.length; i++)
        {
            for (int j = 0; j < b[0].length; j++)
            {
                a[i][j] = b[i][j];
            }
        }

        GrayImage gimg = new GrayImage(a, 4, 5);
        gimg.print();
        System.out.println("The number of white pixels is " + gimg.countWhitePixels());
        gimg.getHistogram();
        gimg.processImage();
        gimg.print();
    }
}