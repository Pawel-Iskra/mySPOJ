///////////////////////////////////////////////////////
/// NOTES: ////////////////////////////////////////////
/// TASK ID = 1240, NAME: WSPO£LINIOWOŒÆ PUNKTÓW //////
/// link: https://pl.spoj.com/problems/JWSPLIN/ ///////
/// TIME RESULT FOR THIS SOLUTION = 0,00s /////////////
/// USAGE: DETERMINANT OF SQUARE MATRIX ///////////////
///////////////////////////////////////////////////////

#include <iostream>
using namespace std;

int main(){
    int t, i, j, det, num0, num1, num2, num3, num4, num5;

    cin >> t;
    for (i = 0; i < t; i++) {
        cin >> num0 >> num1 >> num2 >> num3 >> num4 >> num5;

        det = num0 * num3 + num2 * num5 + num4 * num1 - num2 * num1 - num0 * num5 - num4 * num3;
        if (det == 0) cout << "TAK\n";
        else cout << "NIE\n";
    }
    return 0;
}
