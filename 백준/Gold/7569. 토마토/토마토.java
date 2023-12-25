import static java.lang.System.exit;
import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int x, y, z, dist;

    public Pair(int x, int y, int z, int dist) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.dist = dist;
    }
}

public class Main {

    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {-1, 1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int width = input[0];
        int length = input[1];
        int height = input[2];

        int[][][] arr = new int[height][length][width];
        Queue<Pair> pairs = new LinkedList<>();

        boolean[][][] isVisit = new boolean[height][length][width];

        for (int k = 0; k < height; k++) {
            for (int i = 0; i < length; i++) {
                int[] s = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                for (int j = 0; j < width; j++) {
                    arr[k][i][j] = s[j];
                    if (s[j] == 1) {
                        pairs.offer(new Pair(i, j, k, 0));
                        isVisit[k][i][j] = true;
                    }
                }
            }
        }

        int ans = 0;
        while (!pairs.isEmpty()) {
            Pair poll = pairs.poll();
            int len = poll.dist + 1;
            for (int i = 0; i < 6; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];
                int nz = poll.z + dz[i];
                if (nx < 0 || ny < 0 || nz < 0 || nz >= height || nx >= length || ny >= width) {
                    continue;
                }
                if (isVisit[nz][nx][ny] || arr[nz][nx][ny] == -1) {
                    continue;
                }
                if (arr[nz][nx][ny] == 0) {
                    arr[nz][nx][ny] = 1;
                    isVisit[nz][nx][ny] = true;
                    pairs.offer(new Pair(nx, ny, nz, len));
                    ans = len;
                }
            }
        }

        for (int k = 0; k < height; k++) {
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    if (arr[k][i][j] == 0) {
                        System.out.println(-1);
                        exit(0);
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
