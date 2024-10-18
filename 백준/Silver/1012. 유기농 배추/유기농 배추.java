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
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] strings = br.readLine().split(" ");
            int m = Integer.parseInt(strings[0]);
            int n = Integer.parseInt(strings[1]);
            int k = Integer.parseInt(strings[2]);

            int[][] board = new int[n + 1][m + 1];
            for (int j = 0; j < k; j++) {
                strings = br.readLine().split(" ");

                int x = Integer.parseInt(strings[0]);
                int y = Integer.parseInt(strings[1]);

                board[y][x] = 1;
            }

            int cnt = 0;
            Queue<Pair> q = new LinkedList<>();
            boolean[][] visit = new boolean[n + 1][m + 1];
            int[] dx = {0, 0, 1, -1};
            int[] dy = {1, -1, 0, 0};

            for (int j = 0; j < n; j++) {
                for (int z = 0; z < m; z++) {
                    if (board[j][z] == 0 || visit[j][z]) {
                        continue;
                    }

                    q.offer(new Pair(j, z));
                    visit[j][z] = true;
                    cnt++;

                    while (!q.isEmpty()) {
                        Pair poll = q.poll();

                        for (int d = 0; d < 4; d++) {
                            int nx = dx[d] + poll.x;
                            int ny = dy[d] + poll.y;

                            if (nx < 0 || nx >= n || ny < 0 || ny >= m || board[nx][ny] == 0 || visit[nx][ny]) {
                                continue;
                            }

                            q.offer(new Pair(nx, ny));
                            visit[nx][ny] = true;
                        }
                    }
                }
            }
            bw.write(cnt + "\n");
        }
        bw.flush();
    }
}
