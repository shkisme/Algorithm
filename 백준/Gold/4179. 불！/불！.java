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
        int r = Integer.parseInt(strings[0]);
        int c = Integer.parseInt(strings[1]);

        char[][] board = new char[r + 1][c + 1];
        for (int i = 0; i < r; i++) {
            String string = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = string.charAt(j);
            }
        }

        int[][] j_board = new int[r + 1][c + 1];
        int[][] f_board = new int[r + 1][c + 1];
        boolean[][] j_visit, f_visit;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                char charAt = board[i][j];
                if (charAt == 'J') {
                    q.offer(new Pair(i, j));
                    j_visit = new boolean[r + 1][c + 1];
                    j_visit[i][j] = true;

                    while (!q.isEmpty()) {
                        Pair poll = q.poll();

                        for (int d = 0; d < 4; d++) {
                            int nx = dx[d] + poll.x;
                            int ny = dy[d] + poll.y;

                            if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                                continue;
                            }
                            if (j_visit[nx][ny] || board[nx][ny] != '.') {
                                continue;
                            }

                            q.offer(new Pair(nx, ny));
                            j_visit[nx][ny] = true;

                            if (j_board[nx][ny] == 0) {
                                j_board[nx][ny] = j_board[poll.x][poll.y] + 1;
                            } else {
                                j_board[nx][ny] = Math.min(j_board[nx][ny], j_board[poll.x][poll.y] + 1);
                            }
                        }
                    }
                } else if (charAt == 'F') {
                    q.offer(new Pair(i, j));
                    f_visit = new boolean[r + 1][c + 1];
                    f_visit[i][j] = true;

                    while (!q.isEmpty()) {
                        Pair poll = q.poll();

                        for (int d = 0; d < 4; d++) {
                            int nx = dx[d] + poll.x;
                            int ny = dy[d] + poll.y;

                            if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                                continue;
                            }
                            if (f_visit[nx][ny] || board[nx][ny] != '.') {
                                continue;
                            }

                            q.offer(new Pair(nx, ny));
                            f_visit[nx][ny] = true;

                            if (f_board[nx][ny] == 0) {
                                f_board[nx][ny] = f_board[poll.x][poll.y] + 1;
                            } else {
                                f_board[nx][ny] = Math.min(f_board[nx][ny], f_board[poll.x][poll.y] + 1);
                            }
                        }
                    }
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                char charAt = board[i][j];
                if (charAt == 'J') {
                    q.offer(new Pair(i, j));
                    j_visit = new boolean[r + 1][c + 1];
                    j_visit[i][j] = true;

                    while (!q.isEmpty()) {
                        Pair poll = q.poll();

                        for (int d = 0; d < 4; d++) {
                            int nx = dx[d] + poll.x;
                            int ny = dy[d] + poll.y;

                            if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                                if (answer == 0) {
                                    answer = j_board[poll.x][poll.y] + 1;
                                } else {
                                    answer = Math.min(answer, j_board[poll.x][poll.y] + 1);
                                }
                                continue;
                            }
                            if (j_visit[nx][ny]
                                    || board[nx][ny] != '.'
                                    || (j_board[nx][ny] >= f_board[nx][ny] && f_board[nx][ny] != 0)) {
                                continue;
                            }
                            q.offer(new Pair(nx, ny));
                            j_visit[nx][ny] = true;
                        }
                    }
                }
            }
        }
        if (answer == 0) {
            bw.write("IMPOSSIBLE");
        } else {
            bw.write(answer + "");
        }

        bw.flush();
    }
}
