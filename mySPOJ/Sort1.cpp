#include <iostream>
#include <math.h>
#include <string>
using namespace std;

class Points {
public:
	string name;
	double dist;
};

int main() {
	int t, n, x, y, j, k, i;
	double dist;
	string name;

	cin >> t;
	while (t-- > 0) {
		Points points[1000];
		i = 0;
		cin >> n;
		while (n-- > 0) {
			Points point;
			cin >> name;
			cin >> x >> y;
			dist = sqrt(x * x + y * y);
			point.dist = dist;
			name = name + " " + to_string(x) + " " + to_string(y);
			point.name = name;
			points[i] = point;
			i++;
		}

		for (j = 1; j < i; j++) {
			Points temp = points[j];
			k = j - 1;
			while (k >= 0 && temp.dist < points[k].dist) {
				points[k + 1] = points[k];
				k--;
			}
			points[++k] = temp;
		}

		for (j = 0; j < i; j++) {
			cout << points[j].name << "\n";
		}
		cout << "\n";
	}
	return 0;
}