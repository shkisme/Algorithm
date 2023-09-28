import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        
        for (int i : arr){
            if (i % divisor == 0) list.add(i);
        }
        
        int[] answer;
        if(list.isEmpty()){
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        
        Collections.sort(list);
        
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}