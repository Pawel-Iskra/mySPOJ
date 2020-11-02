///////////////////////////////////////////////////////
/// NOTES: ////////////////////////////////////////////
/// TASK ID = 498 /////////////////////////////////////
/// NAME: DŁUGOŚĆ NAJDŁUŻSZEGO WSPÓLNEGO PODCIĄGU /////
/// link: https://pl.spoj.com/problems/LENLCS/ ////////
/// TIME RESULT FOR THIS SOLUTION = 0,01s /////////////
/// USAGE: ALGORITHM DETERMINING LENGTH OF LONGEST ////
/// COMMON SUBSEQUENCE ////////////////////////////////
///////////////////////////////////////////////////////

#include <iostream>
#include <string>
using namespace std;

int getLengthOfLongestCommonSubsequence(string word1, string word2){
int max = 0, i, len1, len2;
len1 = word1.length();
len2 = word2.length();
int matrix[1001][1001];

for (int j = 0; j < len1; j++) {
	for (int k = 0; k < len2; k++) {
			if (word1[j] == word2[k]) {
			matrix[j + 1][k + 1] = 1 + matrix[j][k];
		}
		else {
			max = matrix[j + 1][k];
			if (matrix[j][k + 1] > max) max = matrix[j][k + 1];
			matrix[j + 1][k + 1] = max;
		}
	}
}
	return matrix[len1][len2];
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int t, i, len1, len2, result;
	string word1, word2;

	cin >> t;
	for (i = 0; i < t; i++) {
		cin >> len1 >> word1;
		cin >> len2 >> word2;
	    result = getLengthOfLongestCommonSubsequence(word1, word2);
		cout << result <<  "\n";
	}
	return 0;
}