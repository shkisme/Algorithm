#include <bits/stdc++.h>

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        string str1, str2;
        cin >> str1 >> str2;

        int arr[26] = {};

        for (char c: str1) {
            arr[c - 'a']++;
        }
        for (char c: str2) {
            arr[c - 'a']--;
        }

        bool impossible = true;
        for (int j: arr) {
            if (arr[j] != 0) {
                cout << "Impossible\n";
                impossible = false;
                break;
            }
        }

        if (impossible == true) {
            cout << "Possible\n";
        }
    }
}