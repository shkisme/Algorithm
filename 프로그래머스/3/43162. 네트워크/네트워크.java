import java.util.*;

class Pair{
    int x, y;
    
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        Queue<Pair> q = new LinkedList<>();
        boolean[][] isVisit = new boolean[n][n];
        
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (computers[i][j] == 1 && !isVisit[i][j]){
                    q.offer(new Pair(i, j));
                    isVisit[i][j] = true;
                    answer++;
                    
                    while(!q.isEmpty()){
                        Pair poll = q.poll();
                        
                        int x = poll.y;
                        
                        for (int k = 0; k < n; k++){
                            if (computers[x][k] == 1 && !isVisit[x][k]){
                                q.offer(new Pair(x, k));
                                isVisit[x][k] = true;
                            }
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}