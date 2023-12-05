import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int y, x;

    public Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int max넓이 = 0;
        int 그림개수 = 0;

        int height = input[0];
        int width = input[1];
        int[][] arr = new int[height][width];

        for (int i = 0; i < height; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        boolean isVisit[][] = new boolean[height][width];

        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int value = arr[y][x];
                int cnt = 0;
                if (isVisit[y][x] == false && value == 1) {
                    Queue<Pair> q = new LinkedList<>();
                    q.offer(new Pair(y, x));
                    isVisit[y][x] = true;
                    cnt++;
                    그림개수++;

                    while (!q.isEmpty()) {
                        Pair pair = q.poll();
                        for (int i = 0; i < 4; i++) {
                            int nx = pair.x + dx[i];
                            int ny = pair.y + dy[i];

                            if (nx < 0 || ny < 0 || width <= nx || height <= ny) {
                                continue;
                            }
                            if (isVisit[ny][nx] == false && arr[ny][nx] == 1) {
                                q.offer(new Pair(ny, nx));
                                isVisit[ny][nx] = true;
                                cnt++;
                            }
                        }
                    }

                    if (max넓이 < cnt) {
                        max넓이 = cnt;
                    }
                }
            }
        }

        System.out.println(그림개수);
        System.out.println(max넓이);
    }
}
