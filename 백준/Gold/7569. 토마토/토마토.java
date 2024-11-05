import java.io.*;
import java.util.*;

class Pair {
    int x, y, z;

    public Pair(final int z, final int x, final int y) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(java.lang.System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(java.lang.System.out));

    public static void main(String[] args) throws Exception {
        String[] strings = br.readLine().split(" ");
        int m = Integer.parseInt(strings[0]);
        int n = Integer.parseInt(strings[1]);
        int h = Integer.parseInt(strings[2]);

        int[][][] board = new int[h + 1][n + 1][m + 1];
        int[][][] dist = new int[h + 1][n + 1][m + 1];

        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                strings = br.readLine().split(" ");
                for (int k = 0; k < m; k++) {
                    board[i][j][k] = Integer.parseInt(strings[k]);
                    if (board[i][j][k] == 1) {
                        q.offer(new Pair(i, j, k));
                    }
                }
            }
        }

        int[] dz = {1, -1, 0, 0, 0, 0};
        int[] dx = {0, 0, 1, -1, 0, 0};
        int[] dy = {0, 0, 0, 0, 1, -1};

        int mx = 0;

        while (!q.isEmpty()) {
            Pair poll = q.poll();

            for (int d = 0; d < 6; d++) {
                int nx = dx[d] + poll.x;
                int ny = dy[d] + poll.y;
                int nz = dz[d] + poll.z;

                if (nx < 0 || ny < 0 || nz < 0 || nx >= n || ny >= m || nz >= h) {
                    continue;
                }
                if (board[nz][nx][ny] == 1 || board[nz][nx][ny] == -1) {
                    continue;
                }

                if (dist[nz][nx][ny] == 0) {
                    dist[nz][nx][ny] = dist[poll.z][poll.x][poll.y] + 1;
                } else {
                    dist[nz][nx][ny] = Math.min(dist[nz][nx][ny], dist[poll.z][poll.x][poll.y] + 1);
                }
                mx = Math.max(mx, dist[nz][nx][ny]);
                q.offer(new Pair(nz, nx, ny));
                board[nz][nx][ny] = 1;
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (board[i][j][k] == 0) {
                        bw.write("-1");
                        bw.flush();
                        return;
                    }
                }
            }
        }

        bw.write(mx + "");
        bw.flush();
    }
}
