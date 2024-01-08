import static java.lang.System.in;
import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
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


class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String read = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = read.charAt(j) - '0';
            }
        }

        Queue<Pair> queue = new LinkedList<>();
        boolean[][] isVisit = new boolean[N][N];

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int cnt = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && !isVisit[i][j]) {
                    isVisit[i][j] = true;
                    queue.add(new Pair(i, j));
                    cnt++;

                    int tmp = 0;
                    while (!queue.isEmpty()) {
                        Pair poll = queue.poll();
                        tmp++;

                        for (int k = 0; k < 4; k++) {
                            int nx = poll.x + dx[k];
                            int ny = poll.y + dy[k];

                            if (nx < 0 || ny < 0 || nx >= N || ny >= N || isVisit[nx][ny] || arr[nx][ny] == 0) {
                                continue;
                            }
                            isVisit[nx][ny] = true;
                            queue.offer(new Pair(nx, ny));
                        }
                    }
                    list.add(tmp);
                }
            }
        }

        bw.write(cnt + "\n");
        Collections.sort(list);
        for (int l : list) {
            bw.write(l + "\n");
        }
        bw.flush();
    }
}
