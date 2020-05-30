///////////////////////////////////////////////////////
/// NOTES: ////////////////////////////////////////////
/// TASK ID = 833, NAME: DWUMIANY /////////////////////
/// link: https://pl.spoj.com/problems/BINOMS /////////
/// TIME RESULT FOR THIS SOLUTION = 0,00s /////////////
/// USAGE: BINOMINAL COEFFICIENT - NEWTON SYMBOL //////
///////////////////////////////////////////////////////

#include <iostream>
#include <math.h>
using namespace std;


int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t, i, n, k, num, den; 
    long res;

    cin >> t;
    for (i = 0; i < t; i++) {
        cin >> n;
        cin >> k;

        if ((n - k) > k) k = n - k;
        k++;

        res = 1;
        for (num = n, den = 1; num >= k; num--, den++)
            res = res * num / den;

        cout << res <<"\n";
    }
    return 0;
}
