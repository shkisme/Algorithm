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
        char[][] board = new char[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            String string = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = string.charAt(j);
            }
        }

        Queue<Pair> q1 = new LinkedList<>();
        Queue<Pair> q2 = new LinkedList<>();

        boolean[][] visit1 = new boolean[n + 1][n + 1];
        boolean[][] visit2 = new boolean[n + 1][n + 1];

        int cnt1 = 0;
        int cnt2 = 0;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char charAt = board[i][j];

                if (charAt == 'R' && !visit1[i][j]) {
                    q1.offer(new Pair(i, j));
                    visit1[i][j] = true;
                    cnt1++;

                    while (!q1.isEmpty()) {
                        Pair poll = q1.poll();

                        for (int d = 0; d < 4; d++) {
                            int nx = dx[d] + poll.x;
                            int ny = dy[d] + poll.y;

                            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                                continue;
                            }
                            if (board[nx][ny] != 'R' || visit1[nx][ny]) {
                                continue;
                            }
                            q1.offer(new Pair(nx, ny));
                            visit1[nx][ny] = true;
                        }
                    }
                } else if (charAt == 'G' && !visit1[i][j]) {
                    q1.offer(new Pair(i, j));
                    visit1[i][j] = true;
                    cnt1++;

                    while (!q1.isEmpty()) {
                        Pair poll = q1.poll();

                        for (int d = 0; d < 4; d++) {
                            int nx = dx[d] + poll.x;
                            int ny = dy[d] + poll.y;

                            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                                continue;
                            }
                            if (board[nx][ny] != 'G' || visit1[nx][ny]) {
                                continue;
                            }
                            q1.offer(new Pair(nx, ny));
                            visit1[nx][ny] = true;
                        }
                    }
                } else if (charAt == 'B' && !visit1[i][j]) {
                    q1.offer(new Pair(i, j));
                    visit1[i][j] = true;
                    cnt1++;

                    while (!q1.isEmpty()) {
                        Pair poll = q1.poll();

                        for (int d = 0; d < 4; d++) {
                            int nx = dx[d] + poll.x;
                            int ny = dy[d] + poll.y;

                            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                                continue;
                            }
                            if (board[nx][ny] != 'B' || visit1[nx][ny]) {
                                continue;
                            }
                            q1.offer(new Pair(nx, ny));
                            visit1[nx][ny] = true;
                        }
                    }
                }

                if ((charAt == 'R' || charAt == 'G') && !visit2[i][j]) {
                    q2.offer(new Pair(i, j));
                    visit2[i][j] = true;
                    cnt2++;

                    while (!q2.isEmpty()) {
                        Pair poll = q2.poll();

                        for (int d = 0; d < 4; d++) {
                            int nx = dx[d] + poll.x;
                            int ny = dy[d] + poll.y;

                            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                                continue;
                            }
                            if (board[nx][ny] == 'B' || visit2[nx][ny]) {
                                continue;
                            }
                            q2.offer(new Pair(nx, ny));
                            visit2[nx][ny] = true;
                        }
                    }
                } else if (charAt == 'B' && !visit2[i][j]) {
                    q2.offer(new Pair(i, j));
                    visit2[i][j] = true;
                    cnt2++;

                    while (!q2.isEmpty()) {
                        Pair poll = q2.poll();

                        for (int d = 0; d < 4; d++) {
                            int nx = dx[d] + poll.x;
                            int ny = dy[d] + poll.y;

                            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                                continue;
                            }
                            if (board[nx][ny] != 'B' || visit2[nx][ny]) {
                                continue;
                            }
                            q2.offer(new Pair(nx, ny));
                            visit2[nx][ny] = true;
                        }
                    }
                }
            }
        }

        bw.write(cnt1 + " " + cnt2);
        bw.flush();
    }
}
