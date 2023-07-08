#include <bits/stdc++.h>
using namespace std;

int a[10];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int b;

    cin >> b;

    string num = to_string(b);
    int result = 0;

    for (char c : num){
        if (c == '9' || c == '6'){
            a[9]++;
            a[6]++;
            continue;
        }
        a[c - '0']++;
    }

    if (a[9] % 2 == 1){
        a[9] /= 2;
        a[6] /= 2;
        a[9]++;
        a[6]++;
    }
    else{
        a[9] /= 2;
        a[6] /= 2;
    }

    int m = INT_MIN;

    for (int i = 0; i < 10; i++){
        if (a[i] > m){
            m = a[i];
        }
    }

    cout << m;
}