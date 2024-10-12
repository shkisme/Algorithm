import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(java.lang.System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(java.lang.System.out));

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            bw.write("1");
            bw.flush();
            return;
        }

        int[] queue = new int[1_000_000];
        int head = 0;
        int tail = 0;

        for (int i = 1; i <= n; i++) {
            queue[tail++] = i;
        }

        while (true) {
            head++;
            int num = queue[head++];
            queue[tail++] = num;
            if (tail - head == 1) {
                break;
            }
        }
        bw.write(queue[head] + "");
        bw.flush();
    }
}
