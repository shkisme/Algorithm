import java.util.*;

class Pair{
    int y;
    int x;
    
    Pair(int y, int x){
        this.y = y;
        this.x = x;
    }
    
    static Pair init(){
        return new Pair(0,0);
    }
}

class Solution {
    static int RED_END = 3;
    static int BLUE_END = 4;
    
    static boolean[][] redVisit;
    static boolean[][] blueVisit;
    
    static int answer = Integer.MAX_VALUE;
    static int 높이 = 0;
    static int 너비 = 0;
    
    static int[][] MAZE;
    
    static int[] dx = {0, 0, -1, 1}; // 위, 아래, 왼, 오
    static int[] dy = {-1, 1, 0, 0};
    
    public int solution(int[][] maze) {
        MAZE = maze;
        높이 = maze.length;
        너비 = maze[0].length;
        
        redVisit = new boolean[높이][너비];
        blueVisit = new boolean[높이][너비];
        
        Pair red = Pair.init();
        Pair blue = Pair.init();
        
        for (int y = 0; y < 높이; y++){
            for (int x = 0; x < 너비; x++){
                int value = maze[y][x];
                if (value == 1){
                    red.y = y;
                    red.x = x;
                    redVisit[y][x] = true;
                }
                if (value == 2){
                    blue.y = y;
                    blue.x = x;
                    blueVisit[y][x] = true;
                }
                if (value == 5){
                    redVisit[y][x] = true;
                    blueVisit[y][x] = true;
                }
            }
        }
        process(red, blue, 0);
        if (answer == Integer.MAX_VALUE) return 0;
        return answer;
    }
    
    void process(Pair red, Pair blue, int count){
        // 둘 다 도착
        if (MAZE[red.y][red.x] == RED_END && MAZE[blue.y][blue.x] == BLUE_END){
            if (count < answer){
                answer = count;
            }
            return;
        }
        // red 도착, blue 미도착
        else if (MAZE[red.y][red.x] == RED_END){
            for (int j = 0; j < 4; j++){
                int nY = blue.y + dy[j];
                int nX = blue.x + dx[j];
                if (nY < 0 || 높이 - 1 < nY || nX < 0 || 너비 - 1 < nX) continue;
                if (blueVisit[nY][nX] == true) continue;
                if (red.y == nY && red.x == nX) continue;
                
                blueVisit[nY][nX] = true;
                process(new Pair(red.y, red.x), new Pair(nY, nX), count + 1);
                blueVisit[nY][nX] = false;
            }
            return;
        }
        // blue 도착, red 미도착
        else if (MAZE[blue.y][blue.x] == BLUE_END){
            for (int j = 0; j < 4; j++){
                int nY = red.y + dy[j];
                int nX = red.x + dx[j];
                if (nY < 0 || 높이 - 1 < nY || nX < 0 || 너비 - 1 < nX) continue;
                if (redVisit[nY][nX] == true) continue;
                if (blue.y == nY && blue.x == nX) continue;
                
                redVisit[nY][nX] = true;
                process(new Pair(nY, nX), new Pair(blue.y, blue.x), count + 1);
                redVisit[nY][nX] = false;
            }
            return;
        }
    
        for (int i = 0; i < 4; i++){
            int nextY = red.y + dy[i];
            int nextX = red.x + dx[i];
            if (nextY < 0 || 높이 - 1 < nextY || nextX < 0 || 너비 - 1 < nextX) continue;
            if (redVisit[nextY][nextX] == true) continue;
            redVisit[nextY][nextX] = true;

            for (int j = 0; j < 4; j++){
                int nY = blue.y + dy[j];
                int nX = blue.x + dx[j];
                if (nY < 0 || 높이 - 1 < nY || nX < 0 || 너비 - 1 < nX) continue;
                if (blueVisit[nY][nX] == true) continue;
                if (nextY == nY && nextX == nX) continue;
                
                if (blue.x == nextX && blue.y == nextY && red.x == nX && red.y == nY) continue;
                
                blueVisit[nY][nX] = true;
                process(new Pair(nextY, nextX), new Pair(nY, nX), count + 1);
                blueVisit[nY][nX] = false;
            }
            redVisit[nextY][nextX] = false;
        }
    }
}