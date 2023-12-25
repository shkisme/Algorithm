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

        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int subin = inputs[0];
        int dongsang = inputs[1];

        int[] depth = new int[100_001];
        for (int i = 0; i < 100_001; i++) {
            depth[i] = -1;
        }
        depth[subin] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(subin);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (poll == dongsang) {
                System.out.println(depth[poll]);
                exit(0);
            }

            int tmp = depth[poll] + 1;

            int n1 = poll - 1;
            int n2 = poll + 1;
            int n3 = poll * 2;

            if (0 <= n1 && n1 <= 100_000) {
                if (depth[n1] == -1 || tmp < depth[n1]) {
                    depth[n1] = tmp;
                    queue.offer(n1);
                }
            }
            if (n2 <= 100_000) {
                if (depth[n2] == -1 || tmp < depth[n2]) {
                    depth[n2] = tmp;
                    queue.offer(n2);
                }
            }

            if (n3 <= 100_000) {
                if (depth[n3] == -1 || tmp < depth[n3]) {
                    depth[n3] = tmp;
                    queue.offer(n3);
                }
            }
        }
    }
}
