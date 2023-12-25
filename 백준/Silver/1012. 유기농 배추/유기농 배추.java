import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {

            String[] token = br.readLine().split(" ");
            int width = Integer.parseInt(token[0]);
            int length = Integer.parseInt(token[1]);
            int cnt = Integer.parseInt(token[2]);

            Queue<Pair> pairs = new LinkedList<>();
            boolean[][] isVisit = new boolean[length][width];
            int[][] arr = new int[length][width];

            for (int i = 0; i < cnt; i++) {
                token = br.readLine().split(" ");
                int y = Integer.parseInt(token[0]); // 가로
                int x = Integer.parseInt(token[1]); // 세로
                arr[x][y] = 1;
            }

            int ans = 0;
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {

                    if (arr[i][j] == 1 && !isVisit[i][j]) {
                        isVisit[i][j] = true;
                        pairs.offer(new Pair(i, j));
                        ans++;
                        while (!pairs.isEmpty()) {
                            Pair poll = pairs.poll();

                            for (int k = 0; k < 4; k++) {
                                int nx = poll.x + dx[k];
                                int ny = poll.y + dy[k];

                                if (nx < 0 || ny < 0 || nx >= length || ny >= width || isVisit[nx][ny]
                                        || arr[nx][ny] == 0) {
                                    continue;
                                }
                                isVisit[nx][ny] = true;
                                pairs.offer(new Pair(nx, ny));
                            }
                        }
                    }
                }
            }

            System.out.println(ans);

        }
    }
}
