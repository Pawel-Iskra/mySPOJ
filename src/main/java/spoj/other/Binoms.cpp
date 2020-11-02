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

long getNewtonSymbol(int n, int k){
int num, den;
long result = 1;
if ((n - k) > k) {
    k = n - k;
}
k++;
for (num = n, den = 1; num >= k; num--, den++){
     result = result * num / den;
}
return result;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int tests, i, n, k;
    long result;

    cin >> tests;
    for (i = 0; i < tests; i++) {
        cin >> n;
        cin >> k;
        result = getNewtonSymbol(n, k);
        cout << result <<"\n";
    }
    return 0;
}
