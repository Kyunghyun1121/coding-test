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
int ma, mr, mc;


int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	
	int temp;
	ma = -1;

	for (int a = 1; a <= 9; a++) {
		for (int b = 1; b <= 9; b++) {
			cin >> temp;
			if (temp > ma) {
				ma = temp;
				mr = a;
				mc = b;
			}
		}
	}

	cout << ma << '\n' << mr << " " << mc << " ";




	return 0;
}