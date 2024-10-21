import java.util.*;

class Pair{
    int x, y;
    
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int solution(int[][] maps) {
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visit = new boolean[n][m];
        int[][] answer = new int[n][m];
        
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0));
        visit[0][0] = true;

        while(!q.isEmpty()){
            Pair poll = q.poll();

            for (int d = 0; d < 4; d++){
                int nx = dx[d] + poll.x;
                int ny = dy[d] + poll.y;

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (maps[nx][ny] == 0 || visit[nx][ny]) continue;
                q.offer(new Pair(nx, ny));
                visit[nx][ny] = true;
                answer[nx][ny] = answer[poll.x][poll.y] + 1;
            }
        }
        
        if (answer[n - 1][m - 1] == 0) return -1;
        return answer[n - 1][m - 1] + 1;
    }
}