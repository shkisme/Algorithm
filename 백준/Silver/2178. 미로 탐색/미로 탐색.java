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
        int n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);

        int[][] board = new int[n + 1][m + 1];
        int[][] answer = new int[n + 1][m + 1];
        boolean[][] visit = new boolean[n + 1][m + 1];

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int i = 0; i < n; i++) {
            String string = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = string.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0 || visit[i][j]) {
                    continue;
                }

                Queue<Pair> q = new LinkedList<>();
                q.offer(new Pair(i, j));
                visit[i][j] = true;

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
                        answer[nx][ny] = answer[poll.x][poll.y] + 1;
                    }
                }
            }
        }

        bw.write(answer[n - 1][m - 1] + 1 + "");
        bw.flush();
    }
}
