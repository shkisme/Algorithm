import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String,Integer> map = new HashMap<>();
        
        for (String c : completion){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (String p : participant){
            int val = map.getOrDefault(p, 0);
            
            if (val <= 0) return p;
            
            map.put(p, map.getOrDefault(p, 0) - 1);
        }
        
        return answer;
    }
}