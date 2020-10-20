///////////////////////////////////////////////////
/// NOTES: ////////////////////////////////////////
/// TASK ID = 506, NAME: FLAMASTER ////////////////
/// link: https://pl.spoj.com/problems/FLAMASTE ///
/// TIME RESULT FOR THIS SOLUTION = 0,00s /////////
/// SOURCE CODE LENGTH LIMIT = 2000B //////////////
///////////////////////////////////////////////////

#include <iostream>
#include <string>
using namespace std;

int main() {
	int t, length, i, j, k, count;
	string input;
	cin >> t;
	for (int i = 0; i < t; i++) {
		cin >> input;
		length = input.length();
		for (j = 0; j < length - 2; j++) {
			cout << input[j];
			if (input[j] == input[j + 1] && input[j + 1] == input[j + 2]) {
				k = j + 1;
				count = 1;
				while (input[j] == input[k]) {
					count++;
					k++;
					if (k == length) break;
				}
				cout << count;
				j = j + count - 1;
			}
		}
		if (j == length - 2) cout << input[j] << input[j + 1];
		else if (j == length - 1) cout << input[j];

		cout << "\n";
	}
	return 0;
}
