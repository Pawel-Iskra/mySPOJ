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

string getAnswer(int number){
string number1, number2, answer = "";
int count = 0;

do {
	number1 = to_string(number);
	number2 = number1;
	reverse(number2.begin(), number2.end());
	count++;
	number = stoi(number1) + stoi(number2);
    } while (!(stoi(number1) == stoi(number2)));

    answer.append(to_string(number / 2)).append(" ").append(to_string(--count));
return answer;
}

int main() {
	int tests, number, i;
	string answer;

	cin >> tests;
	for (i = 0; i < tests; i++) {
		cin >> number;

        answer = getAnswer(number);
		cout << answer << "\n";
	}
	return 0;
}

