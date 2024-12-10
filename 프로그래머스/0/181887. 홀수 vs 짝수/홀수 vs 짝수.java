class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int s1 = 0, s2 = 0;
        
        for (int i = 0; i < num_list.length; i++){
            if((i + 1) % 2 == 0) s1 += num_list[i];
            else s2 += num_list[i];
        }
        return s1 > s2 ? s1 : s2;
    }
}