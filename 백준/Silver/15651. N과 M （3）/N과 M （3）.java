import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(java.lang.System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(java.lang.System.out));

    static int n, m;
    static int[] arr = new int[10];
    static boolean[] isUsed = new boolean[10];

    public static void main(String[] args) throws Exception {
        String[] strings = br.readLine().split(" ");
        n = Integer.parseInt(strings[0]);
        m = Integer.parseInt(strings[1]);

        backtracking(0);
        bw.flush();
    }

    private static void backtracking(final int k) throws IOException {
        if (k == m) {
            for (int i = 0; i < m; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            arr[k] = i;
            backtracking(k + 1);
        }
    }
}
