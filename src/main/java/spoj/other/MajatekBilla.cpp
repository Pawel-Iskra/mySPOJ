////////////////////////////////////////////////////////
/// NOTES: /////////////////////////////////////////////
/// TASK ID = 5853, NAME: MAJĄTEK BILLA ////////////////
/// link: https://pl.spoj.com/problems/MWP2_2B /////////
/// TIME RESULT FOR THIS SOLUTION = 0,04s //////////////
/// NOTE: BEST TIME IN JAVA RANKING SOLUTIONS //////////
/// USAGE: FAST MODULAR EXPONENTIATION /////////////////
////////////////////////////////////////////////////////

#include <iostream>
using namespace std;

int getModulo(int base, int exp, int mod){
int rest, i, result = 1;
rest = base % mod;
for (i = 1; i <= exp; i = i << 1) {
     rest = rest % mod;
     if ((exp & i) != 0) {
         result = result * rest;
         result = result % mod;
     }
     rest = rest * rest;
}
return result;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int base, exp, mod, result;

    cin >> base >> exp >> mod;
    do {
       result = getModulo(base, exp, mod);
       cout << result << "\n";

       cin >> base >> exp >> mod;
    } while (base != 0 && exp != 0 && mod != 0);

    return 0;
}

