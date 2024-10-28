import java.io.*;
import java.util.*;

class Pair {
    int x, y;

    public Pair(final int x, final int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(java.lang.System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(java.lang.System.out));

    public static void main(String[] args) throws Exception {
        String[] strings = br.readLine().split(" ");
        int m = Integer.parseInt(strings[0]);
        int n = Integer.parseInt(strings[1]);

        int[][] board = new int[n + 1][m + 1];
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            strings = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(strings[j]);
                if (board[i][j] == 1) {
                    q.offer(new Pair(i, j));
                }
            }
        }

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int[][] dist = new int[n + 1][m + 1];
        int max = 0;

        while (!q.isEmpty()) {
            Pair poll = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = dx[d] + poll.x;
                int ny = dy[d] + poll.y;

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (board[nx][ny] == 1 || board[nx][ny] == -1) {
                    continue;
                }
                q.offer(new Pair(nx, ny));
                board[nx][ny] = 1;
                if (dist[nx][ny] == 0) {
                    dist[nx][ny] = dist[poll.x][poll.y] + 1;
                    max = Math.max(max, dist[nx][ny]);
                } else {
                    dist[nx][ny] = Math.min(dist[poll.x][poll.y] + 1, dist[nx][ny]);
                    max = Math.max(max, dist[nx][ny]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    bw.write("-1");
                    bw.flush();
                    return;
                }
            }
        }

        bw.write(max + "");
        bw.flush();
    }
}
