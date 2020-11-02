///////////////////////////////////////////////////////
/// NOTES: ////////////////////////////////////////////
/// TASK ID = 1432, NAME: SZYFFROWANIE 2 //////////////
/// link: https://pl.spoj.com/problems/JSZYFR2 ////////
/// TIME RESULT FOR THIS SOLUTION = 0,00s /////////////
///////////////////////////////////////////////////////

#include <iostream>
using namespace std;

string getAnswer(int numbers[], int amount){
int i, j, value, x, prime, count, key, flag;
string result = "";
int primes[] = { 127, 131, 137, 139, 149 };

flag = 0;
key = 0;
for (i = 0; i < 5; i++) {
	prime = primes[i];
	count = 0;
	for (j = 0; j < amount; j++) {
		value = numbers[j] % prime;
		if (value >= 65 && value <= 90) count++;
		else break;
	}
	if (count == amount) {
		flag++;
		if (flag == 2) break;
		key = prime;
	}
}
if (flag != 1) result = "NIECZYTELNE";
else {
	result.append(to_string(key)).append(" ");
	for (i = 0; i < amount; i++) result.push_back((char) (numbers[i] % key));
}
return result;
}

int main(){
	int i, tests, amount, number;
	int numbers[25];
	string answer;

	cin >> tests;
	while (tests-- > 0) {
		cin >> amount;
		for (i = 0; i < amount; i++) {
			cin >> number;
			numbers[i] = number;
		}
		answer = getAnswer(numbers, amount);
		cout << answer << "\n";
	}
	return 0;
}