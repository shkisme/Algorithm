import java.util.*;

class Pair{
    int x, y, depth;
    
    Pair(int x, int y, int depth){
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
}

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] isVisit = new boolean[maps.length][maps[0].length];
        
        Queue<Pair> q = new LinkedList<>();
        
        q.offer(new Pair(0,0,1));
        isVisit[0][0] = true;
        
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        
        while(!q.isEmpty()){
            Pair poll = q.poll();
            
            if (poll.x == n - 1 && poll.y == m - 1){
                answer = poll.depth;
                break;
            }
            
            for (int i = 0; i < 4; i++){
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= n || ny >= m){
                    continue;
                }
                if (maps[nx][ny] == 0 || isVisit[nx][ny]) continue;
                q.offer(new Pair(nx, ny, poll.depth + 1));
                isVisit[nx][ny] = true;
            }
        }
        
        return answer;
    }
}