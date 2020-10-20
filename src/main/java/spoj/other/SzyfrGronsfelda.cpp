///////////////////////////////////////////////////
/// NOTES: ////////////////////////////////////////
/// TASK ID = 4840, NAME: SZYFR GRONSFELDA ////////
/// link: https://pl.spoj.com/problems/WI_SZYFR ///
/// THIS SOLUTION GETS RESULT = 100% //////////////
/// TIME RESULT FOR THIS SOLUTION = 0,02s /////////
/// USAGE: GRONSFELD CIPHER ///////////////////////
///////////////////////////////////////////////////

#include <iostream>
#include <string>
using namespace std;

int main() {
	string text, action, key;
	int keyy, textSize, keySize, k, i;
	
	cin >> action;
	cin >> keyy;
	cin >> text;

	key = to_string(keyy);
	textSize = text.length();
	keySize = key.length();
	switch (action[0]) {
	case 'S':
		for (i = 0; i < textSize; i++) {
			k = i % keySize;
			if (text[i] + key[k] > 138) cout << ((char)(text[i] + key[k] - 74));
			else cout << ((char)(text[i] + key[k] - 48));
		}
		break;
	case 'D':
		for (i = 0; i < textSize; i++) {
			k = i % keySize;
			if (text[i] - key[k] < 17) cout << ((char)(text[i] - key[k] + 74));
			else cout << ((char)(text[i] - key[k] + 48));
		}
		break;
	}
	
	return 0;
}
