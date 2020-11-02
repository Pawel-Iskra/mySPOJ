///////////////////////////////////////////////////////
/// NOTES: ////////////////////////////////////////////
/// TASK ID = 1299, NAME: STEFAN //////////////////////
/// link: https://pl.spoj.com/problems/FZI_STEF ///////
/// TIME RESULT FOR THIS SOLUTION = 0,02s /////////////
/// USAGE: KADANE'S ALGORITHM /////////////////////////
///////////////////////////////////////////////////////

#include <iostream>
using namespace std;

long getMaxSubarraySum(int numbers[], int amount){
long maxLocal = 0, maxGlobal = 0;
for (int i = 0; i < amount; i++) {
     if (numbers[i] > (numbers[i] + maxLocal)) maxLocal = numbers[i];
     else maxLocal = numbers[i] + maxLocal;
     if (maxLocal > maxGlobal) maxGlobal = maxLocal;
    }
return maxGlobal;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int amount, number, i;

    cin >> amount;
    int numbers[amount];

    for (i = 0; i < amount; i++) {
        cin >> number;
        numbers[i] = number;
    }
    cout << getMaxSubarraySum(numbers, amount);

    return 0;
}