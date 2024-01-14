import static java.lang.System.in;
import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
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
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];

        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            String[] read = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(read[j]);
                if (maxValue < arr[i][j]) {
                    maxValue = arr[i][j];
                }
            }
        }

        int answer = Integer.MIN_VALUE;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int i = 0; i <= maxValue; i++) {

            int cnt = 0;
            Queue<Pair> queue = new LinkedList<>();
            boolean[][] isVisit = new boolean[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (i < arr[j][k] && !isVisit[j][k]) {
                        queue.offer(new Pair(j, k));
                        isVisit[j][k] = true;
                        cnt++;

                        while (!queue.isEmpty()) {
                            Pair poll = queue.poll();

                            for (int l = 0; l < 4; l++) {
                                int nx = poll.x + dx[l];
                                int ny = poll.y + dy[l];

                                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                                    continue;
                                }
                                if (isVisit[nx][ny] || arr[nx][ny] <= i) {
                                    continue;
                                }
                                queue.offer(new Pair(nx, ny));
                                isVisit[nx][ny] = true;
                            }
                        }
                    }
                }
            }
            if (answer < cnt) {
                answer = cnt;
            }
        }
        bw.write(answer + "");
        bw.flush();
    }
}
