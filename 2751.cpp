#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <string>
#include <cstring>
#include <cmath>
#include <vector>
#include<algorithm>
using namespace std;


int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	// 
	int* arr;
	int num;
	cin >> num;
	arr = new int[num + 1];

	for (int a = 0; a < num; ++a) {
		cin >> arr[a];
	}

	sort(arr, arr+num);

	for (int a = 0; a < num; ++a) {
		cout << arr[a] << '\n';
	}

	return 0;
}