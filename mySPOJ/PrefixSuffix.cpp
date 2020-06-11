/////////////////////////////////////////////////////////
/// NOTES: //////////////////////////////////////////////
/// TASK ID = 11059, NAME: Prefiks równoważący sufiks ///
/// link: https://pl.spoj.com/problems/MWP4_1E //////////
/// TIME RESULT FOR THIS SOLUTION = 0,05s ///////////////
/////////////////////////////////////////////////////////

#include <iostream>
using namespace std;

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int t, i, j, x, n;
	long sufiks, prefiks;
	int numbers[10001];
	bool flag;

	cin >> t;
	for (i = 0; i < t; i++) {
		cin >> n;
		sufiks = 0;
		for (j = 0; j < n; j++) {
			cin >> x;
			numbers[j] = x;
			sufiks = sufiks + x;
		}
		prefiks = 0;
		flag = false;
		for (j = 0; j < n - 1; j++) {
			x = numbers[j];
			prefiks = prefiks + x;
			sufiks = sufiks - x;
			if (prefiks == sufiks) {
				cout << (++j) << "\n";
				flag = true;
				break;
			}
		}
		if (!flag) cout << "0\n";
	}
	return 0;
}