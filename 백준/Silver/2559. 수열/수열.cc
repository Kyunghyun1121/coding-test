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
int day;
int arr[100002];
int sum[100002];
int out = -1000000000;


int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	
	

	cin >> cas >> day;
	sum[0] = 0;

	for (int a = 1; a <= cas; a++) {
		cin >> arr[a];
		sum[a] = sum[a - 1] + arr[a];
	}

	for (int a = day; a <= cas; a++) {
		out = max(out, sum[a] - sum[a - day]);
	}
	
	cout << out << '\n';

	return 0;
}