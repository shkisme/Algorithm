import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        int pointer = 0;
        
        while(true){
            
            if (pointer >= speeds.length) break;
            
            for (int i = 0 ;i < speeds.length; i++){
                progresses[i] += speeds[i];
            }
            
            if (progresses[pointer] >= 100){
                    
                int cnt = 0;

                for (int j = pointer; j < speeds.length; j++){
                    if (progresses[j] >= 100){
                        cnt++;
                        pointer++;
                    }
                    if (progresses[j] < 100) break;
                }
                
                list.add(cnt);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}