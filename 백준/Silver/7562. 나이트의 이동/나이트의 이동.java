import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

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
        int t = Integer.parseInt(br.readLine());

        int[] dx = {-1, -1, 1, 1, -2, -2, 2, 2};
        int[] dy = {-2, 2, -2, 2, -1, 1, -1, 1};

        for (int i = 0; i < t; i++) {
            int l = Integer.parseInt(br.readLine());

            Queue<Pair> q = new LinkedList<>();
            boolean[][] visit = new boolean[l + 1][l + 1];
            int[][] dist = new int[l + 1][l + 1];

            String[] strings = br.readLine().split(" ");
            Pair start = new Pair(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]));
            q.offer(new Pair(start.x, start.y));
            visit[start.x][start.y] = true;
            strings = br.readLine().split(" ");
            Pair end = new Pair(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]));

            while (!q.isEmpty()) {
                Pair poll = q.poll();
                if (poll.x == end.x && poll.y == end.y) {
                    bw.write(dist[poll.x][poll.y] + "\n");
                    break;
                }

                for (int j = 0; j < 8; j++) {
                    int nx = dx[j] + poll.x;
                    int ny = dy[j] + poll.y;

                    if (nx < 0 || ny < 0 || nx >= l || ny >= l) {
                        continue;
                    }
                    if (visit[nx][ny]) {
                        continue;
                    }
                    q.offer(new Pair(nx, ny));
                    visit[nx][ny] = true;
                    if (dist[nx][ny] == 0) {
                        dist[nx][ny] = dist[poll.x][poll.y] + 1;
                    } else {
                        dist[nx][ny] = Math.min(dist[nx][ny], dist[poll.x][poll.y] + 1);
                    }
                }
            }
        }

        bw.flush();
    }
}
