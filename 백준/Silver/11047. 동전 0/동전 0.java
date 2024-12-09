import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(java.lang.System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(java.lang.System.out));

    static int n, k;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        String[] strings = br.readLine().split(" ");
        n = Integer.parseInt(strings[0]);
        k = Integer.parseInt(strings[1]);

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        fun();
        bw.flush();
    }

    private static void fun() throws IOException {
        int answer = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] <= k) {
                answer += k / arr[i];
                k %= arr[i];
            }
        }
        bw.write(answer + "");
    }
}
