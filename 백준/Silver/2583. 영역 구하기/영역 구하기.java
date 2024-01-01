import static java.lang.System.in;
import static java.util.Comparator.naturalOrder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(in));

    static int N = 0, M = 0, K = 0;

    static int[][] arr;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        String[] read = br.readLine().split(" ");
        M = Integer.parseInt(read[0]);
        N = Integer.parseInt(read[1]);
        K = Integer.parseInt(read[2]);

        arr = new int[M][N];

        for (int i = 0; i < K; i++) {
            String[] lines = br.readLine().split(" ");
            int lx = Integer.parseInt(lines[0]);
            int ly = Integer.parseInt(lines[1]);
            int rx = Integer.parseInt(lines[2]);
            int ry = Integer.parseInt(lines[3]);

            for (int y = ly; y < ry; y++) {
                for (int x = lx; x < rx; x++) {
                    arr[y][x] = 1;
                }
            }
        }

        Queue<Pair> pairs = new LinkedList<>();
        boolean[][] isVisit = new boolean[M][N];

        List<Integer> area = new ArrayList<>();

        int cnt = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0 && !isVisit[i][j]) {
                    pairs.offer(new Pair(i, j));
                    isVisit[i][j] = true;
                    cnt++;

                    int sum = 0;

                    while (!pairs.isEmpty()) {
                        Pair poll = pairs.poll();
                        sum++;
                        for (int k = 0; k < 4; k++) {
                            int nx = poll.x + dx[k];
                            int ny = poll.y + dy[k];
                            if (nx < 0 || nx >= M || ny < 0 || ny >= N || arr[nx][ny] == 1 || isVisit[nx][ny]) {
                                continue;
                            }
                            isVisit[nx][ny] = true;
                            pairs.offer(new Pair(nx, ny));
                        }
                    }
                    area.add(sum);
                }
            }
        }

        System.out.println(cnt);
        area.sort(naturalOrder());
        for (int i : area) {
            System.out.print(i + " ");
        }
    }
}
