////////////////////////////////////////////////////////
/// NOTES: /////////////////////////////////////////////
/// TASK ID = 9022, NAME: BAJTOCKIE ŚWIĘTO TRÓJKĄTA ////
/// link: https://pl.spoj.com/problems/BAJTST //////////
/// TIME RESULT FOR THIS SOLUTION = 0,00s //////////////
/// NOTE: BEST TIME IN JAVA RANKING SOLUTIONS //////////
/// USAGE: HERON'S FORMULA /////////////////////////////
////////////////////////////////////////////////////////

#include <iostream>
#include <math.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t, i, n, j, a, b, c;
    long result;
    double sum, k, x, area;

    cin >> t;
    for (i = 0; i < t; i++) {
        sum = 0;
        cin >> n;
        cin >> k;
        k = k / 10;

        for (j = 0; j < n; j++) {
            cin >> a >> b >> c;
            if (abs(b - c) < a && a < (b + c)) {
                area = sqrt((double)(a + b + c)
                    * (double)(a + b - c)
                    * (double)(a + c - b)
                    * (double)(b + c - a)) / 4;
                sum = sum + k * area;
            }
        }
        result = round(sum);
        cout << result << "\n";
    }
    return 0;
}
