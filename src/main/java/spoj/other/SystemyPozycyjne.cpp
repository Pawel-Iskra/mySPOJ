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

string getHexadecimal(int number){
string result = "";
int rest;

while (number != 0) {
       rest = number % 16;
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
       number = number / 16;
} // end while
return result;
}

string getEleventhSystem(int number){
string result = "";
while (number != 0) {
      if (number % 11 <= 9) result.insert(0,to_string(number % 11));
      else result.insert(0,"A");
      number = number / 11;
      }
return result;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int tests, number;
    string result;

    cin >> tests;
    while(tests-- > 0) {
        cin >> number;
        cout << getHexadecimal(number) << " " << getEleventhSystem(number) << "\n";
    }
    return 0;
}
