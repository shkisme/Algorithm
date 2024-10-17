import java.io.*;
import java.util.*;

class Pair {
    int point, idx;

    public Pair(final int point, final int idx) {
        this.point = point;
        this.idx = idx;
    }
}

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(java.lang.System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(java.lang.System.out));

    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] strings = br.readLine().split(" ");
            int n = Integer.parseInt(strings[0]);
            int m = Integer.parseInt(strings[1]);

            strings = br.readLine().split(" ");

            int[] points = new int[10];
            Pair[] queue = new Pair[1000];
            int cnt = 0, head = 0, tail = n;
            for (int j = 0; j < n; j++) {
                int point = Integer.parseInt(strings[j]);
                points[point]++;
                queue[j] = new Pair(point, j);
            }

            boolean isEnd = false;
            for (int j = 9; j > 0; j--) {
                while (points[j] > 0 && !isEnd) {
                    if (queue[head].point < j) {
                        queue[tail++] = queue[head];
                        head++;
                    } else if (queue[head].point == j) {
                        if (queue[head].idx == m) {
                            isEnd = true;
                        }
                        points[j]--;
                        cnt++;
                        head++;
                    }
                }

                if (isEnd) {
                    break;
                }
            }
            bw.write(cnt + "\n");
        }
        bw.flush();
    }
}
