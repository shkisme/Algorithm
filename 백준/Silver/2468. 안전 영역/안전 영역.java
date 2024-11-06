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
        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            String[] strings = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(strings[j]);
            }
        }

        Queue<Pair> q = new LinkedList<>();

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int mx = 1;

        for (int k = 1; k <= 100; k++) {
            int cnt = 0;
            boolean[][] visit = new boolean[n + 1][n + 1];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] > k && !visit[i][j]) {
                        q.offer(new Pair(i, j));
                        visit[i][j] = true;
                        cnt++;

                        while (!q.isEmpty()) {
                            Pair poll = q.poll();

                            for (int d = 0; d < 4; d++) {
                                int nx = dx[d] + poll.x;
                                int ny = dy[d] + poll.y;

                                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                                    continue;
                                }
                                if (board[nx][ny] <= k || visit[nx][ny]) {
                                    continue;
                                }
                                q.offer(new Pair(nx, ny));
                                visit[nx][ny] = true;
                            }
                        }
                    }
                }
            }

            mx = Math.max(mx, cnt);
        }

        bw.write(mx + "");
        bw.flush();
    }
}
