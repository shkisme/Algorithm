import java.util.*;

class Pair{
    int p, l;
    
    Pair(int p, int l){
        this.p = p;
        this.l = l;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Pair> q = new LinkedList<>();
        
        for(int i = 0; i < priorities.length; i++){
            q.offer(new Pair(priorities[i], i));
        }
        
        int cnt = 0;
        
        while(!q.isEmpty()){
            
            Pair p = q.poll();
            
            Queue<Pair> tmp = new LinkedList<>();
            
            boolean flag = false;
            
            while(!q.isEmpty()){
                Pair np = q.poll();
                
                if (p.p < np.p){
                    flag = true;
                }
                tmp.offer(np);
            }
            
            if (flag == true){
                tmp.offer(p);
            }
            else{
                cnt++;
                if (p.l == location) return cnt;
            }
            q = tmp;
        }
        
        return answer;
    }
}