///////////////////////////////////////////////////////
/// NOTES: ////////////////////////////////////////////
/// TASK ID = 655, NAME: Gray code ////////////////////
/// link: https://pl.spoj.com/problems/PP0505D ////////
/// TIME RESULT FOR THIS SOLUTION = 0,00s /////////////
/// USAGE: GENERATING ALL POSIBBLE BINARY STRINGS /////
/// OF A GIVEN LENGTH IN THE ORDER OF GRAY CODE ///////
///////////////////////////////////////////////////////

#include <iostream>
#include <string>
#include <math.h>
#include <bitset>
using namespace std;

string getGrayCodeForLevel(int level){
string result, subresult;
int i, j, halfI, power, res;

power = pow(2, level);
for (i = 0; i < power; i++) {
	halfI = i / 2;
	res = i ^ halfI;
	subresult = (bitset<32>(res).to_string());

	for (j = 0; j < 32 - level; j++) subresult.erase(0, 1);
    result.append(subresult).append("\n");
}
return result;
}

int main() {
	string result;
	int t, level;

	cin >> t;
	while (t-- > 0) {
		cin >> level;
	    result = getGrayCodeForLevel(level);
		cout << result << "\n";
		}
	return 0;
}