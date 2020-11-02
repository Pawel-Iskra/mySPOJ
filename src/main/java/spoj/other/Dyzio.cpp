///////////////////////////////////////////////////////
/// NOTES: ////////////////////////////////////////////
/// TASK ID = 520, NAME: DYZIO ////////////////////////
/// link: https://pl.spoj.com/problems/DYZIO2 /////////
/// TIME RESULT FOR THIS SOLUTION = 0,18s /////////////
/// USAGE: SIEVE OF ERATOSTHENES //////////////////////
///////////////////////////////////////////////////////

#include <iostream>
#include <math.h>
using namespace std;

bool isPrime(int x) {
	int sqr, i;
	if (x % 2 == 0) return x == 2;
	sqr = (int) sqrt(x) + 1;
	for (i = 3; i < sqr; i++) if (x % i == 0) return false;
	return x > 1;
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int numberOfPrimes[1000001];
	int counter = 0, tests, lowerLimit, upperLimit;

	for (i = 0; i < 1000001; i++) {
		if (isPrime(i)) counter++;
		numberOfPrimes[i] = counter;
	}

	cin >> tests;
	while (tests-- > 0) {
		cin >> lowerLimit;
		cin >> upperLimit;
		cout << (numberOfPrimes[upperLimit] - numberOfPrimes[lowerLimit - 1]) << "\n";
	}
	return 0;
}
