class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        if (a == b) return a;
        
        int min = Math.min(a, b);
        int max = min == a ? b : a;
        for(long i = min; i <= max; i++){
            answer += i;
        }
        return answer;
    }
}