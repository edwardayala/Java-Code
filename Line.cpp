// Line Assignment - Edward Ayala

#include <iostream>

using namespace std;

class Line
{
public:
	Line(int a1, int b1, int c1)
	{
		a = a1;
		b = b1;
		c = c1;
	}
	double getSlope()
	{
		return (double)-a / b;
	}
	bool isOnLine(int x, int y)
	{
		return ((a*x) + (b*y) + c == 0);
	}
private:
	int a;
	int b;
	int c;
};

int main()
{
	Line line1(5, 4, -17);
	double slope1 = line1.getSlope();
	bool onLine1 = line1.isOnLine(5, -2);

	Line * line2 = new Line(-25, 40, 30);
	double slope2 = line2->getSlope();
	bool onLine2 = line2->isOnLine(5, -2);

	cout << "Equation: 5x + 4y - 17 = 0\n";
	cout << "Slope: " << slope1 << endl;
	cout << "Is point (5, -2) on the line? " << (onLine1 ? "true\n" : "false\n") << endl;

	cout << "Equation: -25x + 40y + 30 = 0\n";
	cout << "Slope: " << slope2 << endl;
	cout << "Is point (5, -2) on the line? " << (onLine2 ? "true\n" : "false\n") << endl;

	system("PAUSE");
}