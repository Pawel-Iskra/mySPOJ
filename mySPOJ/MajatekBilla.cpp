#include <iostream>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int base, exp, mod, result, rest, i;
    cin >> base >> exp >> mod;

    do {
        result = 1;
        rest = base % mod;
        for (i = 1; i <= exp; i = i << 1) {
            rest = rest % mod;
            if ((exp & i) != 0) {
                result = result * rest;
                result = result % mod;
            }
            rest = rest * rest;
        }
        cout << result << "\n";
        cin >> base >> exp >> mod;
    } while (base != 0 && exp != 0 && mod != 0);
    return 0;
}

