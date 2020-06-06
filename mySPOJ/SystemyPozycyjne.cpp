/////////////////////////////////////////////////////////
/// NOTES: //////////////////////////////////////////////
/// TASK ID = 1019, NAME: SYSTEMY POZYCYJNE /////////////
/// link: https://pl.spoj.com/problems/SYS //////////////
/// TIME RESULT FOR THIS SOLUTION = 0,02s ///////////////
/// USAGE: CONVERTING A NUMBER FROM DECIMAL SYSTEM TO ///
/// HEXADECIMAL AND ELEVENTH SYSTEM REPRESENTATION //////
/////////////////////////////////////////////////////////

#include <iostream>
#include <string>
#include<bits/stdc++.h> 
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t, num, copy, rest;
    string result;
    cin >> t;
    while(t-- > 0) {
        result = "";
        cin >> num;
        copy = num;
        while (copy != 0) {
            rest = copy % 16;
            if (rest <= 9) result.insert(0,to_string(rest));
            else {
                switch (rest) {
                case 10:
                    result.insert(0,"A");
                    break;
                case 11:
                    result.insert(0,"B");
                    break;
                case 12:
                    result.insert(0,"C");
                    break;
                case 13:
                    result.insert(0,"D");
                    break;
                case 14:
                    result.insert(0,"E");
                    break;
                case 15:
                    result.insert(0,"F");
                    break;
                } // end switch
            } // end else
            copy = copy / 16;
        } // end while
        cout << result << " ";

        result = "";
        while (num != 0) {
            if (num % 11 <= 9) result.insert(0,to_string(num % 11));
            else result.insert(0,"A");
            num = num / 11;
        }
        cout << result << "\n";
    }
    return 0;
}
