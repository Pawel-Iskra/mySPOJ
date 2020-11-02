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

string getShortenedString(string input){
string result = "";
int t, length, i, j, k, count;
length = input.length();
for (j = 0; j < length - 2; j++) {
	result.push_back(input[j]);
	if (input[j] == input[j + 1] && input[j + 1] == input[j + 2]) {
	k = j + 1;
	count = 1;
	while (input[j] == input[k]) {
		count++;
		k++;
		if (k == length) break;
	}
	result.append(to_string(count));
	j = j + count - 1;
	}
}
if (j == length - 2){
	result.push_back(input[j]);
	result.push_back(input[j + 1]);
} else if (j == length - 1) result.push_back(input[j]);

return result;
}

int main() {
	int t, length, i, j, k, count;
	string input, result;
	cin >> t;
	for (int i = 0; i < t; i++) {
		cin >> input;
        result = getShortenedString(input);
		cout << result << "\n";
	}
	return 0;
}
