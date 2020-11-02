///////////////////////////////////////////////////
/// NOTES: ////////////////////////////////////////
/// TASK ID = 4840, NAME: SZYFR GRONSFELDA ////////
/// link: https://pl.spoj.com/problems/WI_SZYFR ///
/// THIS SOLUTION GETS RESULT = 100% //////////////
/// TIME RESULT FOR THIS SOLUTION = 0,01s /////////
/// USAGE: GRONSFELD CIPHER ///////////////////////
///////////////////////////////////////////////////

#include <iostream>
#include <string>
using namespace std;

string getResultText(string text, string action, int keyy){
int i, k, textSize, keySize;
string key, resultText;

key = to_string(keyy);
textSize = text.length();
keySize = key.length();

switch (action[0]) {
case 'S':
	for (i = 0; i < textSize; i++) {
		k = i % keySize;
		if (text[i] + key[k] > 138) resultText.push_back((char)(text[i] + key[k] - 74));
		else resultText.push_back((char)(text[i] + key[k] - 48));
	}
	break;
case 'D':
	for (i = 0; i < textSize; i++) {
		k = i % keySize;
		if (text[i] - key[k] < 17) resultText.push_back((char)(text[i] - key[k] + 74));
		else resultText.push_back((char)(text[i] - key[k] + 48));
	}
	break;
  }
  return resultText;
}

int main() {
	string text, action, resultText;
	int key;
	
	cin >> action >> key >> text;

    resultText = getResultText(text, action, key);
	cout << resultText;
	return 0;
}
