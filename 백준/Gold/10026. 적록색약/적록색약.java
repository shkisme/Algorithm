import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int x, y;
    char value;

    public Pair(int x, int y, char value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }
}

public class Main {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        int N = Integer.parseInt(br.readLine());
        Character[][] arr = new Character[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        Queue<Pair> pairs = new LinkedList<>();
        boolean[][] isVisit = new boolean[N][N];

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisit[i][j]) {
                    isVisit[i][j] = true;
                    pairs.offer(new Pair(i, j, arr[i][j]));
                    cnt++;
                    while (!pairs.isEmpty()) {
                        Pair poll = pairs.poll();

                        char p = poll.value;
                        for (int k = 0; k < 4; k++) {
                            int nx = poll.x + dx[k];
                            int ny = poll.y + dy[k];

                            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                                continue;
                            }
                            if (isVisit[nx][ny] || arr[nx][ny] != p) {
                                continue;
                            }
                            isVisit[nx][ny] = true;
                            pairs.offer(new Pair(nx, ny, arr[nx][ny]));
                        }
                    }
                }
            }
        }
        System.out.print(cnt + " ");

        cnt = 0;
        boolean[][] isVisit2 = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisit2[i][j]) {
                    isVisit2[i][j] = true;
                    pairs.offer(new Pair(i, j, arr[i][j]));
                    cnt++;
                    while (!pairs.isEmpty()) {
                        Pair poll = pairs.poll();

                        char p = poll.value;
                        for (int k = 0; k < 4; k++) {
                            int nx = poll.x + dx[k];
                            int ny = poll.y + dy[k];

                            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                                continue;
                            }
                            if (isVisit2[nx][ny]) {
                                continue;
                            }
                            if (p == 'R') {
                                if (arr[nx][ny] != 'G' && arr[nx][ny] != p) {
                                    continue;
                                }
                            } else if (p == 'G') {
                                if (arr[nx][ny] != 'R' && arr[nx][ny] != p) {
                                    continue;
                                }
                            } else {
                                if (arr[nx][ny] != p) {
                                    continue;
                                }
                            }
                            isVisit2[nx][ny] = true;
                            pairs.offer(new Pair(nx, ny, arr[nx][ny]));
                        }
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
