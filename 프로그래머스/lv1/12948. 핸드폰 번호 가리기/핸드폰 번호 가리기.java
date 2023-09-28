class Solution {
    public String solution(String phone_number) {
        String answer = "";
        int len = phone_number.length();
        int last = len - 4;
        
        for (int i = 0; i < last; i++){
            answer += "*";
        }
        for (int i = last; i < len; i++){
            answer += phone_number.charAt(i);
        }
        return answer;
    }
}