import java.io.*;
import java.util.*;

class Node {
    int x, y;
    int cnt;
    int horseCnt;

    public Node(final int x, final int y, final int cnt, final int horseCnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.horseCnt = horseCnt;
    }
}

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(java.lang.System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(java.lang.System.out));

    static int K, W, H;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        K = Integer.parseInt(br.readLine());
        String[] strings = br.readLine().split(" ");
        W = Integer.parseInt(strings[0]);
        H = Integer.parseInt(strings[1]);

        arr = new int[H][W];
        for (int i = 0; i < H; i++) {
            strings = br.readLine().split(" ");
            for (int j = 0; j < W; j++) {
                arr[i][j] = Integer.parseInt(strings[j]);
            }
        }

        bfs();
        bw.flush();
    }

    private static void bfs() throws IOException {
        Queue<Node> q = new LinkedList<>();
        boolean[][][] visit = new boolean[H + 1][W + 1][K + 2];

        q.offer(new Node(0, 0, 1, 0));

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int[] hdx = {1, 1, 2, 2, -1, -1, -2, -2};
        int[] hdy = {2, -2, 1, -1, -2, 2, -1, 1};

        while (!q.isEmpty()) {
            Node poll = q.poll();

            if (poll.x == H - 1 && poll.y == W - 1) {
                bw.write((poll.cnt - 1) + "");
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = dx[d] + poll.x;
                int ny = dy[d] + poll.y;

                if (nx < 0 || ny < 0 || nx >= H || ny >= W) {
                    continue;
                }
                if (arr[nx][ny] != 1 && !visit[nx][ny][poll.horseCnt]) {
                    visit[nx][ny][poll.horseCnt] = true;
                    q.offer(new Node(nx, ny, poll.cnt + 1, poll.horseCnt));
                }
            }

            for (int d = 0; d < 8; d++) {
                int nx = hdx[d] + poll.x;
                int ny = hdy[d] + poll.y;

                if (nx < 0 || ny < 0 || nx >= H || ny >= W) {
                    continue;
                }
                if (arr[nx][ny] != 1 && !visit[nx][ny][poll.horseCnt + 1] && poll.horseCnt + 1 <= K) {
                    visit[nx][ny][poll.horseCnt + 1] = true;
                    q.offer(new Node(nx, ny, poll.cnt + 1, poll.horseCnt + 1));
                }
            }
        }

        bw.write("-1");
    }
}
