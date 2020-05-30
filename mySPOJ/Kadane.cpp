///////////////////////////////////////////////////////
/// NOTES: ////////////////////////////////////////////
/// TASK ID = 1299, NAME: STEFAN //////////////////////
/// link: https://pl.spoj.com/problems/FZI_STEF ///////
/// TIME RESULT FOR THIS SOLUTION = 0,02s /////////////
/// USAGE: KADANE'S ALGORITHM /////////////////////////
///////////////////////////////////////////////////////

#include <iostream>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, i, x;
    long maxL = 0, maxG = 0;
 
    cin >> n;
    for (i = 0; i < n; i++) {
        cin >> x;
        if (x > (x + maxL)) maxL = x;
        else maxL = x + maxL;
        if (maxL > maxG) maxG = maxL;
    }
    cout << maxG;
    return 0;
}