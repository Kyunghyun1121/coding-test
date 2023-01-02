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

int q, pSum[222222][26];
string S;

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	
	
	cin >> S;
	for (int i = 0; i < S.length(); ++i) {
		// 이전꺼 합
		if (i != 0) {
			for (int k = 0; k < 26; ++k)
				pSum[i][k] = pSum[i - 1][k];
		}
		int now = S[i] - 'a';
		pSum[i][now]++;
	}

	cin >> q;
	for (int i = 0; i < q; ++i) {
		char num;
		int l, r;
		cin >> num;
		cin >> l >> r;
		int now = num - 'a';

		int p1 = l > 0 ? pSum[l - 1][now] : 0;
		int p2 = pSum[r][now];
		cout << p2 - p1 << '\n';
	}

	return 0;
}