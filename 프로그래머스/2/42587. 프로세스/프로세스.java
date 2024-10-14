class Pair{
    int l;
    int p;
    
    Pair(int l, int p){
        this.l = l;
        this.p = p;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {    
        Pair[] queue = new Pair[1_000_000];
        int head = 0;
        int tail = priorities.length;
        
        int[] prioritie = new int[10];
        for (int i = 0; i < priorities.length; i++){
            int p = priorities[i];
            queue[i] = new Pair(i, p);
            prioritie[p]++;
        }
        
        int answer = 0;
        for (int i = 9; i > 0; i--){
            if (prioritie[i] > 0){
                while(prioritie[i] != 0){
                    if (queue[head].p == i){
                        if (queue[head].l == location) return answer + 1;
                        prioritie[i]--;
                        head++;
                        answer++;
                    } else {
                        queue[tail++] = queue[head++];
                    }
                }
            }
        }
        
        return answer;
    }
}