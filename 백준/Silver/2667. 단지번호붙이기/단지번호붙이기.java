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
        boolean[][] visit = new boolean[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            String string = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = string.charAt(j) - '0';
            }
        }

        Queue<Pair> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int cnt = 0;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1 && !visit[i][j]) {
                    q.offer(new Pair(i, j));
                    visit[i][j] = true;
                    cnt++;

                    int tmp = 0;

                    while (!q.isEmpty()) {
                        Pair poll = q.poll();
                        tmp++;

                        for (int d = 0; d < 4; d++) {
                            int nx = dx[d] + poll.x;
                            int ny = dy[d] + poll.y;

                            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                                continue;
                            }
                            if (board[nx][ny] == 0 || visit[nx][ny]) {
                                continue;
                            }

                            visit[nx][ny] = true;
                            q.offer(new Pair(nx, ny));
                        }
                    }
                    list.add(tmp);
                }
            }
        }
        bw.write(cnt + "\n");
        list.sort(Comparator.naturalOrder());
        for (int i = 0; i < list.size(); i++) {
            bw.write(list.get(i) + "\n");
        }
        bw.flush();
    }
}
