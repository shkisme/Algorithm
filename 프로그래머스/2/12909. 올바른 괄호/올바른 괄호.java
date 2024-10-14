class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        char[] stack = new char[100_001];
        int index = 0;
        
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                stack[index++] = '(';
            } else {
                if (index == 0){
                    answer = false;
                    break;
                }
                
                if (stack[index - 1] == ')'){
                    answer = false;
                    break;
                } else {
                    index--;
                }
            }
        }
        
        if (index != 0) {
            answer = false;
        }

        return answer;
    }
}