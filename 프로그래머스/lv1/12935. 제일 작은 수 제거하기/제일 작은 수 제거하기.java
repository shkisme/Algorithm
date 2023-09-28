import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer;
        
        if (arr.length == 1){
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        int min = Arrays.stream(arr).min().getAsInt();
        List<Integer> list = new ArrayList<>();
        for (int i : arr){
            if (i != min) list.add(i);
        }
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}