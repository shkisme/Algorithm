import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(java.lang.System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(java.lang.System.out));

    static int N, M;
    static int[] arr = new int[10];
    static boolean[] isUsed = new boolean[10];

    public static void main(String[] args) throws Exception {
        String[] strings = br.readLine().split(" ");
        N = Integer.parseInt(strings[0]);
        M = Integer.parseInt(strings[1]);

        fun(1);
        bw.flush();
    }

    private static void fun(final int num) throws IOException {
        if (num == M + 1) {
            for (int i = 1; i <= M; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!isUsed[i]) {
                arr[num] = i;
                isUsed[i] = true;
                fun(num + 1);
                isUsed[i] = false;
            }
        }
    }
}
