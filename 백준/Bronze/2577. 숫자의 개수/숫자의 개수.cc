#include <iostream>
#include <string>
using namespace std;

int main() {
	int num1, num2, num3;
	int result; // 값들의 곱

	int cnt[10] = {}; 


	cin >> num1 >> num2 >> num3;

	result = num1 * num2 * num3;

	while (result > 0) {
		cnt[result % 10]++;
		result /= 10;
	}

	for (int num : cnt)
		cout << num << "\n";

	return 0;
}