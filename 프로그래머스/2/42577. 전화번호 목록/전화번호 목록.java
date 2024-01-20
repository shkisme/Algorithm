import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Map<String,String> map = new HashMap<>();

        Arrays.sort(phone_book);
        
        for (String p : phone_book){
            
            String tmp = "";
            
            for (int i = 0; i < p.length(); i++){
                tmp += String.valueOf(p.charAt(i) - '0');
                
                String val = map.getOrDefault(tmp, "no");
                
                if (!val.equals("no")) return false;
            }
            
            map.put(p, p);
        }
        
        return answer;
    }
}