class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        int n1 = Integer.parseInt(String.valueOf(a) + String.valueOf(b));
        int n2 = 2 * a * b;
        if (n1 == n2) return n1;
        return n1 > n2 ? n1 : n2;
    }
}