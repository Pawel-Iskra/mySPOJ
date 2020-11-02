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

unsigned long long getLeastCommonMultiple(unsigned long long a, unsigned long long b) {
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

unsigned long long getLCMforAll(unsigned long long array[], int amount){
    unsigned long long result = 1;

    for(int i = 0; i < amount; i++){
    result = getLeastCommonMultiple(result, array[i]);
    }
    return result;
}


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int i, tests, amount;
    unsigned long long number;

    cin >> tests;
    while (tests-- > 0) {
        cin >> amount;
        unsigned long long array[amount];
        for (i = 0; i < amount; i++) {
            cin >> number;
            array[i] = number;
        }
        cout << getLCMforAll(array, amount) << "\n";
    }
    return 0;
}
