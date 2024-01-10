import static java.lang.System.in;
import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[20_000_001];

        String[] read = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(read[i]) + 10_000_000] = 1;
        }

        int M = Integer.parseInt(br.readLine());

        read = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            int tmp = Integer.parseInt(read[i]) + 10_000_000;

            if (arr[tmp] == 1) {
                bw.write(1 + " ");
            } else {
                bw.write(0 + " ");
            }
            bw.flush();
        }
    }
}
