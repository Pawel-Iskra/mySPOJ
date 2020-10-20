///////////////////////////////////////////////////////
/// NOTES: ////////////////////////////////////////////
/// TASK ID = 747, NAME: NWW2 /////////////////////////
/// link: https://pl.spoj.com/problems/NWW ////////////
/// TIME RESULT FOR THIS SOLUTION = 0,00s /////////////
/// USAGE: LEAST COMMON MULTIPLE METHOD ///////////////
/// THAT USES EUCLIDEAN ALGORITHM TO RECEIVE //////////
/// GREATEST COMMON DIVISOR ///////////////////////////
///////////////////////////////////////////////////////

#include <iostream>
#include <math.h>
using namespace std;

unsigned long long getLCM(unsigned long long a, unsigned long long b) {
    unsigned long long small = 0, big = 0, rest = 0;
    if (a > b) {
        big = a;
        small = b;
    } else {
        big = b;
        small = a;
    }
    while ((rest = big % small) != 0) {
        big = small;
        small = rest;
    }
    return (a / small * b);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int i, t, n;
    unsigned long long x, res;
    cin >> t;
    while (t-- > 0) {
        res = 1;
        cin >> n;
        for (i = 0; i < n; i++) {
            cin >> x;
            res = getLCM(x, res);
        }
        cout << res << "\n";
    }
    return 0;
}
