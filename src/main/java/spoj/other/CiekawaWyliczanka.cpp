///////////////////////////////////////////////////////
/// NOTES: ////////////////////////////////////////////
/// TASK ID = 751 , NAME: CIEKAWA WYLICZANKA //////////
/// link: https://pl.spoj.com/problems/ETI06F2 ////////
/// TIME RESULT FOR THIS SOLUTION = 0,00s /////////////
///////////////////////////////////////////////////////

#include <iostream>
#include <string>
#include <bitset>
#include <boost/algorithm/string.hpp>
using namespace std;

string getInterestingNumber(int n){
string result, binaryN, diffChars, baseChars = "";
int i, baseNr, length, diff, baseLen, diffLen;
bool ifContains;

binaryN = bitset<32>(n).to_string();
while (binaryN[0] == '0') binaryN.erase(0, 1);
length = binaryN.length();

ifContains = boost::algorithm::contains(binaryN, "0");
if (ifContains) {
	length--;
	for (i = 0; i < length; i++) baseChars.append("5");
	baseNr = 1;
	for (i = 0; i < length; i++) baseNr = baseNr * 2;
	baseNr--;
	diff = n - baseNr;
	diffChars = bitset<32>(diff).to_string();
	while (diffChars[0] == '0') diffChars.erase(0, 1);

	baseLen = baseChars.length();
	diffLen = diffChars.length();
	for (int i = 0; i < diffLen; i++){
		baseChars[baseLen - i - 1] = (char)(baseChars[baseLen - i - 1] + diffChars[diffLen - i - 1] - 48);
        }
    result = baseChars;
	} else {
	for (i = 0; i < length; i++) result.append("5");
	}
return result;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int number;
	string result;

	cin >> number;
	result = getInterestingNumber(number);
	cout << result;

	return 0;
}
