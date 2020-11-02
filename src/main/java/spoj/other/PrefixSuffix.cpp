/////////////////////////////////////////////////////////
/// NOTES: //////////////////////////////////////////////
/// TASK ID = 11059, NAME: Prefiks równoważący sufiks ///
/// link: https://pl.spoj.com/problems/MWP4_1E //////////
/// TIME RESULT FOR THIS SOLUTION = 0,05s ///////////////
/////////////////////////////////////////////////////////

#include <iostream>
using namespace std;

int getPosition(int array[], int len){
long i, x, suffix = 0, prefix = 0;
for(i = 0; i < len; i++) suffix = suffix + array[i];

for(i = 0; i < len-1; i++){
    x = array[i];
    prefix = prefix + x;
    suffix = suffix - x;
    if(suffix == prefix) return ++i;
    }
    return 0;
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int tests, i, j, number, amount, position;
	int array[10001];

	cin >> tests;
	for (i = 0; i < tests; i++) {
		cin >> amount;
		for (j = 0; j < amount; j++) {
			cin >> number;
			array[j] = number;
		}
	position = getPosition(array, amount);
	cout << position << "\n";
	}
	return 0;
}