class Solution {
    public String solution(String myString) {
        String answer = "";
        for (int i = 0; i < myString.length(); i++){
            char charAt = myString.charAt(i);
            
            if (charAt <= 'l'){
                answer += 'l';
            } else {
                answer += charAt;
            }
        }
        return answer;
    }
}