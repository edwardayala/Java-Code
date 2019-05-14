// Image Processing Assignment - Edward Ayala

#include <iostream>
#include <iomanip>
using namespace std;

class GrayImage;  //Pre-declaration

//Classes
class Pixel
{
public:
	Pixel(int v, int r, int c, GrayImage * m);
	Pixel()
	{
		value = 0;
	}
	int getValue()
	{
		return value;
	}
	void setValue(int val)
	{
		value = val;
	}
	void print();

private:
	int value;
	int rol;
	int col;
	GrayImage * img;
};

//v: pixel value; r: row; c: column; m is a pointer to the image to which this pixel belongs.
Pixel::Pixel(int v, int r, int c, GrayImage * m)
{
	//To be completed
	value = v;
	rol = r;
	col = c;
	img = m;
}

void Pixel::print()
{
	cout << setw(4) << value << " ";
}

// Global Variables
const int BLACK = 0;
const int WHITE = 255;

class GrayImage
{
public:
	GrayImage(int ** arr, int r, int c);
	int countWhitePixels();
	void processImage();
	Pixel * getPixel(int, int);
	int getRows();
	int getCols();
	void print();
	int * getHistogram();

private:
	int rows;
	int cols;

	Pixel *** pixels;  //A 2D array of pointers to pixels (of type Pixel)
};


//Constructor. arr is a 2D array of pixel values. r: rows; c: columns
GrayImage::GrayImage(int ** arr, int r, int c)
{
	//Create a 2D array of pointers to pixels (of type Pixel)
	pixels = new Pixel **[r];

	for (int i = 0; i < r; i++)
		pixels[i] = new Pixel *[c];

	rows = r;
	cols = c;

	for (int i = 0; i < rows; i++)
	{
		for (int j = 0; j < cols; j++)
		{
			pixels[i][j] = new Pixel();
			pixels[i][j]->setValue(arr[i][j]);
		}
	}

}

Pixel * GrayImage::getPixel(int r, int c)
{
	return pixels[r][c];
}

int GrayImage::countWhitePixels()
{
	int n = 0; //The number of white pixels (i.e. 255)

	for (int i = 0; i < rows; i++)
	{
		for (int j = 0; j < cols; j++)
			if (getPixel(i, j)->getValue() == WHITE)
				n++;
	}
	return n;
}
void GrayImage::processImage()
{
	for (int i = 0; i < rows; i++)
	{
		for (int j = 0; j < cols; j++)
		{
			if (i + 2 < rows && j + 2 < cols)
			{
				int diffPixel = pixels[i][j]->getValue() - pixels[i + 2][j + 2]->getValue();

				if (diffPixel < 0)
				{
					pixels[i][j]->setValue(0);
				}
				else
				{
					pixels[i][j]->setValue(diffPixel);
				}
			}
		}
	}
}

int * GrayImage::getHistogram()
{
	int histArr[256] = { 0 };
	for (int i = 0; i < rows; i++)
	{
		for (int j = 0; j < cols; j++)
		{
			int pixVal = pixels[i][j]->getValue();
			for (int count = 0; count < 256; count++)
			{
				if (count == pixVal)
					histArr[count]++;
			}
		}
	}
	cout << "\nHistogram: \n";
	for (int i = 0; i < 256; i++)
	{
		cout << histArr[i] << " ";
	}
	cout << endl;
	return histArr;
}


void GrayImage::print()
{
	cout << "\nThe pixel values of the image are: \n" << endl;

	for (int i = 0; i < rows; i++)
	{
		for (int j = 0; j < cols; j++)
		{
			pixels[i][j]->print();
		}
		cout << endl;
	}
}

int main()
{
	//Create a 2D dynamic array
	int ** a;
	a = new int *[4];

	for (int i = 0; i < 4; i++)
		a[i] = new int[5];

	//Input pixel values to a temporary 2D array
	int b[4][5] = {
		{ 221, 184, 178, 84, 135 },
		{ 84, 255, 255, 130, 84 },
		{ 78, 255, 0, 0, 78 },
		{ 84, 130, 255, 130, 84 }
	};

	//Copy to the dynamic array
	for (int i = 0; i < 4; i++)
	{
		for (int j = 0; j < 5; j++)
		{
			a[i][j] = b[i][j];
		}
	}

	GrayImage gimg(a, 4, 5);
	gimg.print();
	cout << "\nThe number of white pixels is " << gimg.countWhitePixels() << endl;
	gimg.getHistogram();
	gimg.processImage();
	gimg.print();
	return 0;
}


//The pixel values of the image are:
//
// 221  184  178   84  135
//  84  255  255  130   84
//  78  255    0    0   78
//  84  130  255  130   84
//
//The number of white pixels is 4
//
//The pixel values of the image are:
//
// 221  184  100   84  135
//   0  125  171  130   84
//  78  255    0    0   78
//  84  130  255  130   84
//Press any key to continue . . .