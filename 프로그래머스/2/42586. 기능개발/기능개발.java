import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        int[] work = new int[progresses.length + 1];
        for (int i = 0; i < progresses.length; i++){
            int a = (100 - progresses[i]) / speeds[i];
            int b = (100 - progresses[i]) % speeds[i];
            
            if (b > 0) {
                work[i] = a + 1;
            } else {
                work[i] = a;
            }
        }
        
        List<Integer> list = new ArrayList<>();
        int mx = work[0];
        int cnt = 1;
        for (int i = 1; i < progresses.length; i++){
            int num = work[i];
            if (mx >= num){
                cnt++;
            } else {
                list.add(cnt);
                cnt = 1;
                mx = num;
            }
        }
        list.add(cnt);
        return list;
    }
}