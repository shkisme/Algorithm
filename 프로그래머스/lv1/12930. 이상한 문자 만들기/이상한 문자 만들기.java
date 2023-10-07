class Solution {
    public String solution(String s) {
        String answer = "";
        int idx = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == ' ') {
                idx = 0;
                answer += " ";
                continue;
            }
            if (idx % 2 == 0){ // 짝수
                answer += Character.toUpperCase(s.charAt(i));
            }
            else{
                answer += Character.toLowerCase(s.charAt(i));
            }
            idx++;
        }
        return answer;
    }
}