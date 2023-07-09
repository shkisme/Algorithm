#include <bits/stdc++.h>

using namespace std;

int arr[201];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        int tmp;
        cin >> tmp;

        if (tmp <= 0) {
            arr[-tmp]++;
            continue;
        }
        arr[tmp + 100]++;
    }

    int v;
    cin >> v;

    if (v <= 0) {
        cout << arr[-v];
    }
    else{
        cout << arr[v + 100];
    }
}