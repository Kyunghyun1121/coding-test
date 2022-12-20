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


int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	
	int n1[101][101];
	int n2[101][101];
	int n3[101][101];
	int n, m;
	cin >> n >> m;

	for (int a = 0; a < n; a++) {
		for (int b = 0; b < m; b++) {
			cin >> n1[a][b];
		}
	}


	for (int a = 0; a < n; a++) {
		for (int b = 0; b < m; b++) {
			cin >> n2[a][b];
		}
	}

	for (int a = 0; a < n; a++) {
		for (int b = 0; b < m; b++) {
			n3[a][b] = n1[a][b] + n2[a][b];
		}
	}

	for (int a = 0; a < n; a++) {
		for (int b = 0; b < m; b++) {
			cout << n3[a][b] << " ";
		}cout << '\n';
	}


	return 0;
}