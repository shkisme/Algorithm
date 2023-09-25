import javafx.util.Pair;
import java.util.*;

class Solution {
    
    static int number;
    static List<List<String>> list = new ArrayList<>();
    static int answer = 0;
    static Map<String,Boolean> visited = new HashMap<>();
    
    public int solution(String begin, String target, String[] words) {
        if(!Arrays.stream(words).anyMatch(target::equals)){
            return 0;
        }
        
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(begin, 0));
        
        while(!q.isEmpty()){
            var m = q.peek();
            q.poll();
            
            if (m.getKey().equals(target)) return m.getValue();
            
            for (String w : words){
                if(canChange(w, m.getKey())){
                    q.add(new Pair<>(w, m.getValue() + 1));
                }
            }
        }
        
        return answer;
    }
    
    
    public boolean canChange(String str1, String str2){
        int diffCnt = 0;
        for (int j = 0; j < str1.length(); j++){
            if (str1.charAt(j) != str2.charAt(j)){
                diffCnt++;
                if (diffCnt > 1){
                    return false;
                }
            }
        }
        return true;
    }
}