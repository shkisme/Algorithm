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
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] strings = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(strings[j]);
            }
        }

        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        int value = 2;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    q.offer(new Pair(i, j));
                    visited[i][j] = true;
                    arr[i][j] = value;

                    while (!q.isEmpty()) {
                        Pair poll = q.poll();

                        for (int d = 0; d < 4; d++) {
                            int nx = dx[d] + poll.x;
                            int ny = dy[d] + poll.y;

                            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                                continue;
                            }
                            if (arr[nx][ny] == 0 || visited[nx][ny]) {
                                continue;
                            }
                            q.offer(new Pair(nx, ny));
                            visited[nx][ny] = true;
                            arr[nx][ny] = value;
                        }
                    }

                    value++;
                }
            }
        }

        int[][] dist = new int[n][n];

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = arr[i][j];
                if (num != 0) {
                    for (int d = 0; d < 4; d++) {
                        int nx = dx[d] + i;
                        int ny = dy[d] + j;

                        if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                            continue;
                        }
                        if (arr[nx][ny] == 0) {
                            visited = new boolean[n][n];
                            q.offer(new Pair(nx, ny));
                            visited[nx][ny] = true;

                            if (dist[nx][ny] == 0) {
                                dist[nx][ny] = dist[i][j] + 1;
                            } else {
                                dist[nx][ny] = Math.min(dist[nx][ny], dist[i][j] + 1);
                            }

                            while (!q.isEmpty()) {
                                Pair poll = q.poll();

                                for (int k = 0; k < 4; k++) {
                                    int newX = dx[k] + poll.x;
                                    int newY = dy[k] + poll.y;

                                    if (newX < 0 || newY < 0 || newX >= n || newY >= n) {
                                        continue;
                                    }
                                    if (visited[newX][newY]) {
                                        continue;
                                    }
                                    if (arr[newX][newY] == 0) {
                                        dist[newX][newY] = dist[poll.x][poll.y] + 1;
                                        q.offer(new Pair(newX, newY));
                                        visited[newX][newY] = true;
                                    } else if (arr[newX][newY] != num) {
                                        min = Math.min(min, dist[poll.x][poll.y]);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

       /* for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(dist[i][j] + " ");
            }
            bw.write("\n");
        }*/

        bw.write(min + "");
        bw.flush();
    }
}
