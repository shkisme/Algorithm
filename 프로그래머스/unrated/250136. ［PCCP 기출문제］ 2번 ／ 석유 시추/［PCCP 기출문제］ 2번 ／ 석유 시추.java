import java.util.*;

class Solution {
    class Pair{
        int y;
        int x;
        
        Pair(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    
    int[] dx = { 0, 0, -1, 1}; // up, down, left, right
    int[] dy = {-1, 1,  0, 0};
    
    public int solution(int[][] land) {
        int answer = Integer.MIN_VALUE;
        int 높이 = land.length;
        int 너비 = land[0].length;
        
        int[] arr = new int[너비];
        
        boolean[][] isVisited = new boolean[높이][너비];
        for (int y = 0; y < 높이; y++){
            for(int x = 0; x < 너비; x++){
                if (land[y][x] == 1 && isVisited[y][x] == false){
                    Queue<Pair> q = new LinkedList<>();
                    List<Pair> pairs = new ArrayList<>();
                    
                    q.add(new Pair(y, x));
                    pairs.add(new Pair(y, x));
                    isVisited[y][x] = true;
                    int cnt = 1;
                    while(!q.isEmpty()){
                        Pair curr = q.poll();
                        int cy = curr.y;
                        int cx = curr.x;
                        for (int i = 0; i < 4; i++){
                            int tx = cx + dx[i];
                            int ty = cy + dy[i];
                            if (tx < 0 || 너비 - 1 < tx || ty < 0 || 높이 - 1 < ty) continue;
                            if (land[ty][tx] == 1 && isVisited[ty][tx] == false){
                                q.add(new Pair(ty, tx));
                                pairs.add(new Pair(ty, tx));
                                isVisited[ty][tx] = true;
                                cnt++;
                            }
                        }
                    }
                    boolean[] visited = new boolean[너비];
                    for (Pair p : pairs){
                        if(visited[p.x] == false){
                            arr[p.x] += cnt;
                            visited[p.x] = true;
                        }
                    }
                }
            }
        }
        
        for (int a : arr){
            if (answer < a) answer = a;
        }
        return answer;
    }
}