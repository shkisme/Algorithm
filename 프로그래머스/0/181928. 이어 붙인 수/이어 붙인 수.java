class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        String even = "", odd = "";
        
        for (int n : num_list){
            if (n % 2 == 0) even += String.valueOf(n);
            else odd += String.valueOf(n);
        }
        return Integer.parseInt(even) + Integer.parseInt(odd);
    }
}