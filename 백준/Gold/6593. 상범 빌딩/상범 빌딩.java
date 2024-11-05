import java.io.*;
import java.util.*;

class Pair {
    int x, y, z;

    public Pair(final int z, final int x, int y) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(java.lang.System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(java.lang.System.out));

    public static void main(String[] args) throws Exception {
        while (true) {
            String[] strings = br.readLine().split(" ");
            int l = Integer.parseInt(strings[0]);
            int r = Integer.parseInt(strings[1]);
            int c = Integer.parseInt(strings[2]);

            if (l == 0 && r == 0 && c == 0) {
                break;
            }

            char[][][] board = new char[l + 1][r + 1][c + 1];
            boolean[][][] visit = new boolean[l + 1][r + 1][c + 1];

            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String string = br.readLine();
                    for (int k = 0; k < c; k++) {
                        board[i][j][k] = string.charAt(k);
                    }
                }
                br.readLine();
            }

            int[] dz = {1, -1, 0, 0, 0, 0};
            int[] dx = {0, 0, 1, -1, 0, 0};
            int[] dy = {0, 0, 0, 0, 1, -1};

            int[][][] dist = new int[l + 1][r + 1][c + 1];

            Queue<Pair> q = new LinkedList<>();

            int answer = 0;
            boolean flag = false;

            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    for (int k = 0; k < c; k++) {
                        char charAt = board[i][j][k];
                        if (charAt == 'S') {
                            q.offer(new Pair(i, j, k));
                            visit[i][j][k] = true;

                            while (!q.isEmpty()) {
                                Pair poll = q.poll();
                                if (board[poll.z][poll.x][poll.y] == 'E') {
                                    flag = true;
                                    answer = dist[poll.z][poll.x][poll.y];
                                    break;
                                }

                                for (int d = 0; d < 6; d++) {
                                    int nz = dz[d] + poll.z;
                                    int nx = dx[d] + poll.x;
                                    int ny = dy[d] + poll.y;

                                    if (nx < 0 || ny < 0 || nz < 0 || nx >= r || ny >= c || nz >= l) {
                                        continue;
                                    }
                                    if (visit[nz][nx][ny] || board[nz][nx][ny] == '#') {
                                        continue;
                                    }

                                    q.offer(new Pair(nz, nx, ny));
                                    visit[nz][nx][ny] = true;
                                    if (dist[nz][nx][ny] == 0) {
                                        dist[nz][nx][ny] = dist[poll.z][poll.x][poll.y] + 1;
                                    } else {
                                        dist[nz][nx][ny] = Math.min(dist[nz][nx][ny], dist[poll.z][poll.x][poll.y] + 1);
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (flag) {
                bw.write("Escaped in " + answer + " minute(s).\n");
            } else {
                bw.write("Trapped!\n");
            }
        }

        bw.flush();
    }
}
