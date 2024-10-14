import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] stack = new int[1_000_001];
        int index = 0;
        
        for (int a : arr){
            if (index == 0){
                stack[index++] = a;
                continue;
            }
            
            if (a != stack[index - 1]){
                stack[index++] = a;
            }
        }
        
        int[] answer = new int[index];
        for (int i = 0; i < index; i++){
            answer[i] = stack[i];
        }

        return answer;
    }
}