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
int arr[12];
long long small = 1000000000;
long long big = -1000000000;


void track(int* cal, int check, long long sum) {


	if (check == cas) {
		small = min(small, sum);
		big = max(big, sum);
		return;
	}

	for (int a = 0; a < 4; a++) {
		if (cal[a] != 0) {

			cal[a] -= 1;

			if (a == 0) {
				track(cal, check + 1, sum + arr[check]);
			}
			else if (a == 1) {
				track(cal, check + 1, sum - arr[check]);
			}
			else if (a == 2) {
				track(cal, check + 1, sum * arr[check]);
			}
			else if (a == 3) {
				track(cal, check + 1, sum / arr[check]);
			}

			cal[a] += 1;
		}
	}



}

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	
	int plu, minu, doub, divd;
	int cal[5];

	cin >> cas;

	for (int a = 0; a < cas; a++) {
		cin >> arr[a];
	}

	cin >> cal[0] >> cal[1] >> cal[2] >> cal[3];

	track(cal, 1, arr[0]);

	cout << big << '\n' << small << '\n';



	return 0;
}