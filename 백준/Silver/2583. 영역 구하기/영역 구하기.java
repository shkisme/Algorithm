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
        int k = Integer.parseInt(strings[2]);

        int[][] board = new int[n + 1][m + 1];

        for (int i = 0; i < k; i++) {
            strings = br.readLine().split(" ");

            int lx = Integer.parseInt(strings[0]);
            int ly = Integer.parseInt(strings[1]);
            int rx = Integer.parseInt(strings[2]);
            int ry = Integer.parseInt(strings[3]);

            for (int j = lx; j < rx; j++) {
                for (int d = ly; d < ry; d++) {
                    board[j][d] = 1;
                }
            }
        }

        Queue<Pair> q = new LinkedList<>();
        boolean[][] visit = new boolean[n + 1][m + 1];
        int cnt = 0;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0 && !visit[i][j]) {
                    q.offer(new Pair(i, j));
                    visit[i][j] = true;
                    cnt++;

                    int area = 0;

                    while (!q.isEmpty()) {
                        Pair poll = q.poll();
                        area++;

                        for (int d = 0; d < 4; d++) {
                            int nx = dx[d] + poll.x;
                            int ny = dy[d] + poll.y;

                            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                                continue;
                            }
                            if (board[nx][ny] == 1 || visit[nx][ny]) {
                                continue;
                            }

                            q.offer(new Pair(nx, ny));
                            visit[nx][ny] = true;
                        }
                    }

                    list.add(area);
                }
            }
        }
        bw.write(cnt + "\n");
        list.sort(Comparator.naturalOrder());
        for (int i = 0; i < list.size(); i++) {
            bw.write(list.get(i) + " ");
        }
        bw.flush();
    }
}
