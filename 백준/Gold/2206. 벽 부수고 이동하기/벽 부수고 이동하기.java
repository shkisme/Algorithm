import java.io.*;
import java.security.cert.TrustAnchor;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int x, y;
    int cnt;
    boolean destroy;

    public Node(final int x, final int y, final int cnt, final boolean destroy) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.destroy = destroy;
    }
}

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        String[] strings = br.readLine().split(" ");
        N = Integer.parseInt(strings[0]);
        M = Integer.parseInt(strings[1]);
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String string = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = string.charAt(j) - '0';
            }
        }

        bfs();
        bw.flush();
    }

    private static void bfs() throws IOException {
        boolean[][][] visit = new boolean[N + 1][M + 1][2];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 1, false));

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!q.isEmpty()) {
            Node poll = q.poll();

            if (poll.x == N - 1 && poll.y == M - 1) {
                bw.write(poll.cnt + "");
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = dx[d] + poll.x;
                int ny = dy[d] + poll.y;

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if (arr[nx][ny] == 0) {

                    if (!poll.destroy && !visit[nx][ny][0]) {
                        q.offer(new Node(nx, ny, poll.cnt + 1, false));
                        visit[nx][ny][0] = true;
                    } else if (poll.destroy && !visit[nx][ny][1]) {
                        q.offer(new Node(nx, ny, poll.cnt + 1, true));
                        visit[nx][ny][1] = true;
                    }

                } else {
                    if (!poll.destroy) {
                        q.offer(new Node(nx, ny, poll.cnt + 1, true));
                        visit[nx][ny][1] = true;
                    }
                }
            }
        }
        bw.write("-1");
    }
}
