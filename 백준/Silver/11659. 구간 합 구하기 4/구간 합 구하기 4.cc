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
int N, M;
int arr[100002];
int sum[100002];






int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	
	

	cin >> N >> M;
	int s = 0;
	sum[0] = 0;
	for (int a = 1; a <= N; a++) {
		cin >> arr[a];
		sum[a] = sum[a - 1] + arr[a];
	}

	for (int a = 0; a < M; a++) {
		int s, e;
		cin >> s >> e;
		cout << sum[e] - sum[s - 1] << '\n';
	}
	


	return 0;
}