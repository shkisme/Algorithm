import java.util.*;

class Pair{
    String word;
    int idx;
    
    Pair(String w, int i){
        this.word = w;
        this.idx = i;
    }
}

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean flag = true;
        for (String w : words){
            if (w.equals(target)) flag = false;
        }
        if (flag) return 0;
        
        int answer = 0;
        Queue<String> q = new LinkedList<>();
        q.offer(begin);
        boolean[] visit = new boolean[words.length + 1];
        
        while(!q.isEmpty()){
            String poll = q.poll();
            if (poll.equals(target)) return answer;
            
            flag = false;
            for (int i = 0; i < words.length; i++){
                int cnt = 0;
                String word = words[i];
                for (int j = 0; j < word.length(); j++){
                    if (poll.charAt(j) != word.charAt(j)) cnt++;
                }
                if (cnt == 1 && !visit[i]){
                    q.offer(word);
                    visit[i] = true;
                    flag = true;
                }
            }
            
            if (flag) answer++;
        }
        
        return answer;
    }
}