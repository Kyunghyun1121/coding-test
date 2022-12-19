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

vector <int> arr;

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	
	int n[32] = {};
	int temp = 0;

	for (int a = 0; a < 28; a++) {
		cin >> temp;
		n[temp] = temp;
	}


	for (int a = 1; a < 31; a++) {
		if (n[a] == 0) {
			arr.push_back(a);
			
		}
	}

	cout << arr[0] << '\n';
	cout << arr[1] << '\n';

	return 0;
}