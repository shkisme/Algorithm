#include <bits/stdc++.h>
using namespace std;

int d[10];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int a, b, c;

    cin >> a >> b >> c;

    int mul = a * b * c;

    string result = to_string(mul);

    for (int i = 0 ; i < 10; i++){
        for (char c : result){
            if (c - '0' == i){
                d[i]++;
            }
        }
    }

    for (int i = 0; i < 10; i++){
        cout << d[i] << "\n";
    }

    return 0;
}
