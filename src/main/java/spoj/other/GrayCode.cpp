///////////////////////////////////////////////////////
/// NOTES: ////////////////////////////////////////////
/// TASK ID = 655, NAME: Gray code ////////////////////
/// link: https://pl.spoj.com/problems/PP0505D ////////
/// TIME RESULT FOR THIS SOLUTION = 0,01s /////////////
/// USAGE: GENERATING ALL POSIBBLE BINARY STRINGS /////
/// OF A GIVEN LENGTH IN THE ORDER OF GRAY CODE ///////
///////////////////////////////////////////////////////

#include <iostream>
#include <string>
#include <math.h>
#include <bitset>
using namespace std;


int main() {
	int t, n, i, j, halfI, power, res;
	string result;

	cin >> t;
	while (t-- > 0) {
		cin >> n;
		power = pow(2, n);
		for (i = 0; i < power; i++) {
			halfI = i / 2;
			res = i ^ halfI;
			result = bitset<32>(res).to_string();
			for (j = 0; j < 32 - n; j++) result.erase(0, 1);
			cout << result << "\n";
		}
	}
	return 0;
}