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
int arr[5];

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	
	
	int sum = 0;
	cin >> arr[0] >> arr[1] >> arr[2] >> arr[3] >> arr[4];
	for (int a = 0; a < 5; a++) {
		sum += arr[a];
	}

	sort(arr, arr + 5);

	cout << sum / 5 << '\n' << arr[2] << '\n';



	return 0;
}