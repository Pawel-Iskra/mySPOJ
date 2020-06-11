///////////////////////////////////////////////////////
/// NOTES: ////////////////////////////////////////////
/// TASK ID = 1432, NAME: SZYFFROWANIE 2 //////////////
/// link: https://pl.spoj.com/problems/JSZYFR2 ////////
/// TIME RESULT FOR THIS SOLUTION = 0,00s /////////////
///////////////////////////////////////////////////////

#include <iostream>
using namespace std;

int main(){
	int primes[] = { 127, 131, 137, 139, 149 };
	int tests, numbers, i, j, value, x, prime, count, key, flag;
	int nums[25];

	cin >> tests;
	while (tests-- > 0) {
		cin >> numbers;
		for (i = 0; i < numbers; i++) {
			cin >> x;
			nums[i] = x;
		}
		flag = 0;
		key = 0;
		for (i = 0; i < 5; i++) {
			prime = primes[i];
			count = 0;
			for (j = 0; j < numbers; j++) {
				value = nums[j] % prime;
				if (value >= 65 && value <= 90) count++;
				else break;
			}
			if (count == numbers) {
				flag++;
				if (flag == 2) break;
				key = prime;
			}
		}
		if (flag != 1) cout << "NIECZYTELNE";
		else {
			cout << key << " ";
			for (i = 0; i < numbers; i++) cout << (char) (nums[i] % key);
		}
		cout << "\n";
	}
	return 0;
}