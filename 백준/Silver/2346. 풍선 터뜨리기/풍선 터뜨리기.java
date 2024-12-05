import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

class Pair {
    int idx;
    int value;

    public Pair(final int idx, final int value) {
        this.idx = idx;
        this.value = value;
    }
}

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());

        String[] strings = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }

        Deque<Pair> dq = new ArrayDeque<>();
        for (int i = 1; i < n; i++) {
            dq.add(new Pair(i + 1, arr[i]));
        }

        int value = arr[0];
        bw.write("1 ");
        while (!dq.isEmpty()) {
            if (value > 0) {
                for (int i = 1; i < value; i++) {
                    dq.add(dq.poll());
                }

                Pair next = dq.poll();
                value = next.value;
                bw.write(next.idx + " ");
            } else {
                for (int i = 1; i < -value; i++) {
                    dq.addFirst(dq.pollLast());
                }

                Pair next = dq.pollLast();
                value = next.value;
                bw.write(next.idx + " ");
            }
        }

        bw.flush();
    }
}
