import static java.lang.System.exit;
import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
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

        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int width = input[0];
        int height = input[1];

        int[][] arr = new int[height][width];
        Queue<Pair> pairs = new LinkedList<>();

        boolean isVisit[][] = new boolean[height][width];

        for (int i = 0; i < height; i++) {
            int[] s = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < width; j++) {
                arr[i][j] = s[j];
                if (s[j] == 1) {
                    pairs.offer(new Pair(i, j));
                    isVisit[i][j] = true;
                }
            }
        }

        int cnt = -1;
        Queue<Pair> tmp = new LinkedList<>();
        while (!pairs.isEmpty()) {
            while (!pairs.isEmpty()) {
                Pair poll = pairs.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = poll.x + dx[i];
                    int ny = poll.y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= height || ny >= width) {
                        continue;
                    }
                    if (isVisit[nx][ny] || arr[nx][ny] == -1) {
                        continue;
                    }
                    arr[nx][ny] = 1;
                    isVisit[nx][ny] = true;
                    tmp.offer(new Pair(nx, ny));
                }
            }
            while (!tmp.isEmpty()) {
                Pair poll = tmp.poll();
                pairs.offer(poll);
            }
            cnt++;
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (arr[i][j] == 0) {
                    System.out.println(-1);
                    exit(0);
                }
            }
        }

        System.out.println(cnt);
    }
}
