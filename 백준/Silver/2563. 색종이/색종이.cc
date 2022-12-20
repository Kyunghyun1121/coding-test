#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <string>
#include <cstring>
#include <cmath>
#include <vector>
#include <list>
#include <cstdlib>
#include <queue>
#include <deque>
#include <stack>
#include<algorithm>
#include <map>
using namespace std;
long long cas;
bool paper[102][102];

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	
	cin >> cas;
	for (int a = 0; a < cas; a++) {
		int row, col;
		cin >> row >> col;
		for (int b = row; b < row + 10; b++) {
			for (int c = col; c < col + 10; c++) {
				paper[b][c] = true;
			}
		}
	}

	int coun = 0;
	for (int b = 0; b < 101; b++) {
		for (int c = 0; c < 101; c++) {
			if (paper[b][c])coun++;
		}
	}

	cout << coun << '\n';



	return 0;
}