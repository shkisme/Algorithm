class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        for (int n : num_list){
            while(true){
                if (n == 1) break;
                if (n % 2 == 0) {
                    n /= 2;
                    answer++;
                } else{
                    n--;
                    n /= 2;
                    answer++;
                }
            }
        }
        return answer;
    }
}