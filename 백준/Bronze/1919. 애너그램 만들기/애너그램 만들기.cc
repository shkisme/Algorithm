#include <bits/stdc++.h>

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    string str1, str2;
    cin >> str1 >> str2;

    int arr1[26] = {};
    int arr2[26] = {};

    for (char c: str1) {
        arr1[c - 'a']++;
    }

    for (char c: str2) {
        arr2[c - 'a']++;
    }

    int result = 0;

    for (int i = 0; i < 26; i++) {
        if (arr1[i] != arr2[i]) {
            result += abs(arr1[i] - arr2[i]);
        }
    }

    cout << result;
}