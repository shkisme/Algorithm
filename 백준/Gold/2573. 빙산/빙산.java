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

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            strings = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(strings[j]);
            }
        }

        int answer = 0;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (true) {

            int[][] tmp = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] != 0) {
                        int cnt = 0;
                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];

                            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                                continue;
                            }
                            if (arr[nx][ny] == 0) {
                                cnt++;
                            }
                        }

                        tmp[i][j] = arr[i][j] - cnt;
                        if (tmp[i][j] < 0) {
                            tmp[i][j] = 0;
                        }
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = tmp[i][j];
                }
            }

            Queue<Pair> q = new LinkedList<>();
            boolean[][] visit = new boolean[n][m];
            int cnt = 0;
            boolean flag = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] != 0 && !visit[i][j]) {
                        flag = true;
                        q.offer(new Pair(i, j));
                        visit[i][j] = true;

                        cnt++;
                        while (!q.isEmpty()) {
                            Pair poll = q.poll();

                            for (int k = 0; k < 4; k++) {
                                int nx = poll.x + dx[k];
                                int ny = poll.y + dy[k];

                                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                                    continue;
                                }
                                if (arr[nx][ny] == 0 || visit[nx][ny]) {
                                    continue;
                                }

                                q.offer(new Pair(nx, ny));
                                visit[nx][ny] = true;
                            }
                        }
                    }
                }
            }

            answer++;
            if (cnt >= 2) {
                bw.write(answer + "");
                break;
            }
            if (flag == false) {
                bw.write("0");
                break;
            }
        }
        bw.flush();
    }
}
