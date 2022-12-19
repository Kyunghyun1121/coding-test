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
long long num;

//첫째 줄에 정수의 개수 N(1 ≤ N ≤ 100)이 주어진다.
//둘째 줄에는 정수가 공백으로 구분되어져있다.
//셋째 줄에는 찾으려고 하는 정수 v가 주어진다.
//입력으로 주어지는 정수와 v는 - 100보다 크거나 같으며, 100보다 작거나 같다.
//첫째 줄에 입력으로 주어진 N개의 정수 중에 v가 몇 개인지 출력한다.

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	cin >> cas;
	int arr[101];

	for (int a = 0; a < cas; a++) {
		cin >> arr[a];
	}
	cin >> num;

	int coun = 0;
	for (int a = 0; a < cas; a++) {
		if (arr[a] == num)coun++;
	}
	cout << coun << '\n';

	return 0;
}