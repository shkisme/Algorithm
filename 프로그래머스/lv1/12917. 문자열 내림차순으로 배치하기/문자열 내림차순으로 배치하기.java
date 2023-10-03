import java.util.*;

class Solution {
    public String solution(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String answer = new String(chars);
        
        StringBuffer sb = new StringBuffer(answer);
        return sb.reverse().toString();
    }
}