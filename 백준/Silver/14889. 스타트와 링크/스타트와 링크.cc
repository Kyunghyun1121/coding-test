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
int arr[21][21];
bool visit[21];
int out = 202000002;
vector<int> s;

void fi() {

	int sum1 = 0;
	int sum2 = 0;
	int mid = cas / 2;
	for (int a = 0; a < mid; a++) {
		for (int b = a + 1; b < mid; b++) {
			sum1 += arr[s[a]][s[b]] + arr[s[b]][s[a]];
		}
	}

	for (int a = mid; a < cas; a++) {
		for (int b = a + 1; b < cas; b++) {
			sum2 += arr[s[a]][s[b]] + arr[s[b]][s[a]];
		}
	}

	int m = abs(sum1 - sum2);
	if (m < out) {

		out = m;
	}

}


void ch(int coun, int num) {



	if (coun == cas/2) {
		for (int a = 0; a < cas; a++) {
			if (!visit[a]) {
				s.push_back(a);
			}
		}
		fi();
		for (int a = 0; a < cas; a++) {
			if (!visit[a]) {
				s.pop_back();
			}
		}
		return;
	}

	if (visit[num] == true)return;

	visit[num] = true;
	s.push_back(num);

	for (int a = num; a < cas; a++) {

		ch(coun+1, a);
		
	}

	visit[num] = false;
	s.pop_back();
}




int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	
	

	cin >> cas;
	for (int a = 0; a < cas; a++) {
		for (int b = 0; b < cas; b++) {
			cin >> arr[a][b];
		}
	}

	for (int a = 0; a < 21; a++) {
		visit[a] = false;
	}


	ch(0, 0);
	cout << out << '\n';


	return 0;
}