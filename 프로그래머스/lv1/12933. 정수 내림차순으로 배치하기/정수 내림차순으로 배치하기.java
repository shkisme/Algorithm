import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        List<Long> list = new ArrayList<>();
        
        while(n > 0){
            long num = n % 10;
            list.add(num);
            n /= 10;
        }
        
        Collections.sort(list);
        
        int mult = 1;
        for (long l : list){
            answer += l * mult;
            mult *= 10;
        }
        
        return answer;
    }
}