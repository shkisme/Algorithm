import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        q.add(arr[0]);
        list.add(arr[0]);
        
        for (int i : arr){
            int p = q.peek();
            if (p == i) continue;
            q.remove();
            q.add(i);
            list.add(i);
        }
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}