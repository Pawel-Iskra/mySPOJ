///////////////////////////////////////////////////////
/// NOTES: ////////////////////////////////////////////
/// TASK ID = 568, NAME: ZABAWNE DODAWANIE PIOTRUSIA //
/// link: https://pl.spoj.com/problems/BFN1 ///////////
/// TIME RESULT FOR THIS SOLUTION = 0,00s /////////////
///////////////////////////////////////////////////////

#include <iostream>
#include <string>
#include <bits/stdc++.h> 
using namespace std;

int main() {
	int t, i, count, number;
	string number1, number2;

	cin >> t;
	for (i = 0; i < t; i++) {
		count = 0;
		cin >> number;

		do {
			number1 = to_string(number);
			number2 = number1;
			reverse(number2.begin(), number2.end());
			count++;
			number = stoi(number1) + stoi(number2);
		} while (!(stoi(number1) == stoi(number2)));

		cout << number / 2 << " " << --count << "\n";
	}
	return 0;
}

