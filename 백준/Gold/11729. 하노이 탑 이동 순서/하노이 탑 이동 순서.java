import static java.lang.System.in;
import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());

        bw.write((int) Math.pow(2, N) - 1 + "\n");
        fun(N, 1, 3);
        bw.flush();
    }

    private static void fun(int N, int src, int dest) throws IOException {
        if (N == 1) {
            bw.write(src + " " + dest + "\n");
            return;
        }
        fun(N - 1, src, 6 - src - dest);
        bw.write(src + " " + dest + "\n");
        fun(N - 1, 6 - src - dest, dest);
    }
}
