import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(java.lang.System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(java.lang.System.out));

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());

        int[] deque = new int[10_001];
        int head = 5_000;
        int tail = 5_000;

        for (int i = 0; i < n; i++) {
            String[] strings = br.readLine().split(" ");

            String order = strings[0];
            if (order.equals("push_front")) {
                deque[head - 1] = Integer.parseInt(strings[1]);
                head--;
            } else if (order.equals("push_back")) {
                deque[tail] = Integer.parseInt(strings[1]);
                tail++;
            } else if (order.equals("pop_front")) {
                if (tail - head == 0) {
                    bw.write("-1\n");
                } else {
                    bw.write(deque[head] + "\n");
                    head++;
                }
            } else if (order.equals("pop_back")) {
                if (tail - head == 0) {
                    bw.write("-1\n");
                } else {
                    bw.write(deque[tail - 1] + "\n");
                    tail--;
                }
            } else if (order.equals("size")) {
                bw.write(tail - head + "\n");
            } else if (order.equals("empty")) {
                if (tail - head == 0) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            } else if (order.equals("front")) {
                if (tail - head == 0) {
                    bw.write("-1\n");
                } else {
                    bw.write(deque[head] + "\n");
                }
            } else if (order.equals("back")) {
                if (tail - head == 0) {
                    bw.write("-1\n");
                } else {
                    bw.write(deque[tail - 1] + "\n");
                }
            }
        }
        bw.flush();
    }
}
