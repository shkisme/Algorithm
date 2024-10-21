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

    public static void main(String[] args) throws Exception {
        String[] strings = br.readLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int k = Integer.parseInt(strings[1]);

        if (n == k) {
            bw.write("0");
            bw.flush();
            return;
        }

        int[] array = new int[200_000];

        Queue<Integer> q = new LinkedList<>();
        q.offer(n);

        while (!q.isEmpty()) {
            Integer poll = q.poll();

            int n1 = poll - 1;
            int n2 = poll + 1;
            int n3 = 2 * poll;

            if (n1 >= 0 && array[n1] == 0) {
                array[n1] = array[poll] + 1;
                q.offer(n1);
            }
            if (n2 < 200_000 && array[n2] == 0) {
                array[n2] = array[poll] + 1;
                q.offer(n2);
            }
            if (n3 < 200_000 && array[n3] == 0) {
                array[n3] = array[poll] + 1;
                q.offer(n3);
            }

            if (n1 == k || n2 == k || n3 == k) {
                break;
            }
        }
        bw.write(array[k] + "");
        bw.flush();
    }
}
