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

double getArea(int sideA, int sideB, int sideC){
double area = 0;
if (abs(sideB - sideC) < sideA && sideA < (sideB + sideC)) {
    area = sqrt((double)(sideA + sideB + sideC)
           * (double)(sideA + sideB - sideC)
           * (double)(sideA + sideC - sideB)
           * (double)(sideB + sideC - sideA)) / 4;
   }
return area;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int tests, i, people, j, sideA, sideB, sideC;
    long result;
    double sum, chalkUsage, x;

    cin >> tests;
    for (i = 0; i < tests; i++) {
        sum = 0;
        cin >> n;
        cin >> chalkUsage;
        chalkUsage = chalkUsage / 10;

        for (j = 0; j < people; j++) {
            cin >> sideA >> sideB >> sideC;
            sum = sum + chalkUsage * getArea(sideA, sideB, sideC);
        }
        result = round(sum);
        cout << result << "\n";
    }
    return 0;
}
