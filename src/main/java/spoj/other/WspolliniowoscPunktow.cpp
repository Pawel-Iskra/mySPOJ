///////////////////////////////////////////////////////
/// NOTES: ////////////////////////////////////////////
/// TASK ID = 1240, NAME: WSPO�LINIOWO�� PUNKT�W //////
/// link: https://pl.spoj.com/problems/JWSPLIN/ ///////
/// TIME RESULT FOR THIS SOLUTION = 0,00s /////////////
/// USAGE: DETERMINANT OF SQUARE MATRIX ///////////////
///////////////////////////////////////////////////////

#include <iostream>
using namespace std;

string getIfCollinearOrNot(int coords[]){
int det;
det = coords[0] * coords[3] + coords[2] * coords[5] + coords[4] * coords[1]
    - coords[2] * coords[1] - coords[0] * coords[5] - coords[4] * coords[3];

return det == 0 ? "TAK" : "NIE";
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int tests;
    int coords[6];
    string answer;

    cin >> tests;
    while (tests-- > 0) {
        cin >> coords[0] >> coords[1] >> coords[2] >> coords[3] >> coords[4] >> coords[5];

        answer = getIfCollinearOrNot(coords);
        cout << answer << "\n";
    }
    return 0;
}
