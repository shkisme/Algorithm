import java.util.*;

class Solution {
    public int[] solution(long n) {
        int len = String.valueOf(n).length();
        int[] answer = new int[len];
        
        int i = 0;
        while(n > 0){
            int num = Long.valueOf(n % 10).intValue();
            answer[i++] = num;
            n /= 10;
        }
        return answer;
    }
}