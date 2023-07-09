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

        if (str1.length() != str2.length()) {
            cout << "Impossible\n";
            continue;
        }

        int c1[26], c2[26];

        fill(c1, c1 + 26, 0);
        fill(c2, c2 + 26, 0);

        for (char c: str1) {
            c1[c - 'a']++;
        }
        for (char c: str2) {
            c2[c - 'a']++;
        }

        bool impossible = true;
        for (int i = 0; i < 26; i++) {
            if (c1[i] != c2[i]) {
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