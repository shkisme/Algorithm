class Solution {
    public int solution(int num) {
        int answer = 0;
        
        long num2 = (long) num;
        while(num2 != 1){
            if (num2 % 2 == 0){
                num2 /= 2;
            }
            else{
                num2 *= 3;
                num2++;
            }
            answer++;
            if (answer == 500 && num2 != 1) return -1;
        }
        
        return answer;
    }
}