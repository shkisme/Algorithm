class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        if (4 != s.length() && 6 != s.length()) return false;
        
        for (int i = 0; i < s.length(); i++){
            if ('a' <= s.charAt(i) && s.charAt(i) <= 'z') return false;
            if ('A' <= s.charAt(i) && s.charAt(i) <= 'Z') return false;
        }
        return answer;
    }
}