import java.io.*;
import java.util.*;

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

    static Pair[] arr;
    static Pair[] tmp;
    static boolean[] visit;
    static int n, m, v;

    public static void main(String[] args) throws Exception {
        String[] strings = br.readLine().split(" ");
        n = Integer.parseInt(strings[0]);
        m = Integer.parseInt(strings[1]);
        v = Integer.parseInt(strings[2]);

        arr = new Pair[2 * m];
        tmp = new Pair[2 * m];

        for (int i = 0; i < 2 * m; i += 2) {
            strings = br.readLine().split(" ");
            arr[i] = new Pair(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]));
            arr[i + 1] = new Pair(Integer.parseInt(strings[1]), Integer.parseInt(strings[0]));
        }

        mergeSort(0, 2 * m);

        // dfs
        visit = new boolean[n + 1];
        dfs(v);
        bw.write("\n");

        // bfs
        visit = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visit[v] = true;

        while (!q.isEmpty()) {
            Integer poll = q.poll();
            bw.write(poll + " ");

            for (int i = 0; i < 2 * m; i++) {
                Pair pair = arr[i];
                if (pair.x == poll && !visit[pair.y]) {
                    q.offer(pair.y);
                    visit[pair.y] = true;
                } else if (pair.y == poll && !visit[pair.x]) {
                    q.offer(pair.x);
                    visit[pair.x] = true;
                }
            }
        }

        bw.flush();
    }

    private static void dfs(final int num) throws IOException {
        if (visit[num]) {
            return;
        }
        bw.write(num + " ");
        visit[num] = true;
        for (int i = 0; i < 2 * m; i++) {
            Pair pair = arr[i];
            if (pair.x == num && !visit[pair.y]) {
                dfs(pair.y);
                visit[pair.y] = true;
            } else if (pair.y == num && !visit[pair.x]) {
                dfs(pair.x);
                visit[pair.x] = true;
            }
        }
    }

    private static void mergeSort(final int start, final int end) {
        if (start + 1 == end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(start, mid);
        mergeSort(mid, end);
        merge(start, end);
    }

    private static void merge(final int start, final int end) {
        int mid = (start + end) / 2;
        int lidx = start;
        int ridx = mid;
        for (int i = start; i < end; i++) {
            if (lidx == mid) {
                tmp[i] = arr[ridx++];
            } else if (ridx == end) {
                tmp[i] = arr[lidx++];
            } else if (arr[lidx].x < arr[ridx].x) {
                tmp[i] = arr[lidx++];
            } else if (arr[lidx].x == arr[ridx].x) {
                if (arr[lidx].y < arr[ridx].y) {
                    tmp[i] = arr[lidx++];
                } else {
                    tmp[i] = arr[ridx++];
                }
            } else {
                tmp[i] = arr[ridx++];
            }
        }

        for (int i = start; i < end; i++) {
            arr[i] = tmp[i];
        }
    }
}
