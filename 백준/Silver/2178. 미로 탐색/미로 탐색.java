import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int x, y, ans;

    public Pair(int x, int y, int ans) {
        this.x = x;
        this.y = y;
        this.ans = ans;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int height = input[0];
        int width = input[1];
        int[][] arr = new int[height][width];

        for (int i = 0; i < height; i++) {
            String s = br.readLine();
            for (int j = 0; j < width; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        boolean isVisit[][] = new boolean[height][width];

        Queue<Pair> pairs = new LinkedList<>();
        pairs.offer(new Pair(0, 0, 1));
        isVisit[0][0] = true;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        while (!pairs.isEmpty()) {
            Pair poll = pairs.poll();
            int len = poll.ans + 1;
            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= height || ny >= width || isVisit[nx][ny] == true || arr[nx][ny] == 0) {
                    continue;
                }
                isVisit[nx][ny] = true;
                pairs.offer(new Pair(nx, ny, len));
                if (nx == height - 1 && ny == width - 1) {
                    System.out.println(len);
                    break;
                }
            }
        }
    }
}
