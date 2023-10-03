class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        
        int plus = price;
        for (int i = 0; i < count; i++){
            answer += plus;
            plus += price;
        }
        if (money > answer) return 0;
        return answer - money;
    }
}