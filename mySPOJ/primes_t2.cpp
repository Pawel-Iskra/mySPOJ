//////////////////////////////////////////////////////////
/// NOTES: ///////////////////////////////////////////////
/// TASK ID = 438, NAME: LICZBY PIERWSZE /////////////////
/// link: https://pl.spoj.com/problems/PRIME_T ///////////
/// TIME RESULT FOR THIS SOLUTION = 0,01s ////////////////
/// USAGE: DETERMINING IF THE NUMBER IS PRIME ////////////
/// BY USING - IN SOME WAY - SIEVE OF ERATOSTHENES ///////
//////////////////////////////////////////////////////////


#include <iostream>
#include <math.h>
using namespace std;

bool isPrime(int x) {
    if (x % 2 == 0) return x == 2;
    int sqr = (int)sqrt(x) + 1;
    for (int i = 3; i < sqr; i = i + 2) if (x % i == 0) return false;
    return x > 1;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t, x;
    cin >> t;
    while (t-- > 0) {
        cin >> x;
        if (isPrime(x)) cout << "TAK\n";
        else cout << "NIE\n";
    }
    return 0;
}