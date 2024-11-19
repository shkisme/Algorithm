import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(java.lang.System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(java.lang.System.out));

    static int[] parent = new int[100_001];
    static int[] time = new int[100_001];

    public static void main(String[] args) throws Exception {
        String[] strings = br.readLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int k = Integer.parseInt(strings[1]);

        if (n == k) {
            bw.write("0\n" + n);
        } else {
            Queue<Integer> q = new LinkedList<>();
            q.offer(n);
            time[n] = 1;

            while (!q.isEmpty()) {
                Integer poll = q.poll();

                if (poll == k) {
                    break;
                }

                int n1 = poll * 2;
                if (n1 <= 100_000 && time[n1] == 0) {
                    time[n1] = time[poll] + 1;
                    parent[n1] = poll;
                    q.offer(n1);
                }

                int n2 = poll + 1;
                if (n2 <= 100_000 && time[n2] == 0) {
                    time[n2] = time[poll] + 1;
                    parent[n2] = poll;
                    q.offer(n2);
                }

                int n3 = poll - 1;
                if (n3 >= 0 && n3 <= 100_000 && time[n3] == 0) {
                    time[n3] = time[poll] + 1;
                    parent[n3] = poll;
                    q.offer(n3);
                }
            }
            bw.write(time[k] - 1 + "\n");

            Stack<Integer> stack = new Stack<>();
            stack.push(k);
            int index = k;
            while (index != n) {
                stack.push(parent[index]);
                index = parent[index];
            }
            while (!stack.isEmpty()) {
                bw.write(stack.pop() + " ");
            }
        }

        bw.flush();
    }
}
