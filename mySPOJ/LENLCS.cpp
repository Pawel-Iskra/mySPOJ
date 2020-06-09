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

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int max = 0, t, i, len1, len2;
	string word1, word2;
	cin >> t;
	for (i = 0; i < t; i++) {
		cin >> len1 >> word1;
		cin >> len2 >> word2;
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
		cout << matrix[len1][len2] <<  "\n";
	}
	return 0;
}