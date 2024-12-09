import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(java.lang.System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(java.lang.System.out));

    static int R, C;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        String[] strings = br.readLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        R = Integer.parseInt(strings[1]);
        C = Integer.parseInt(strings[2]);

        int pow = (int) Math.pow(2, n);

        fun(pow, R, C);
        bw.write(answer + "");
        bw.flush();
    }

    private static void fun(int size, int r, int c) {
        if (size == 1) {
            return;
        }

        int nextSize = size / 2;
        if (r < nextSize && c < nextSize) { // 1
            fun(nextSize, r, c);
        } else if (r < nextSize && c >= nextSize) { // 2
            answer += nextSize * nextSize;
            fun(nextSize, r, c - nextSize);
        } else if (r >= nextSize && c < nextSize) {
            answer += nextSize * nextSize * 2;
            fun(nextSize, r - nextSize, c);
        } else {
            answer += nextSize * nextSize * 3;
            fun(nextSize, r - nextSize, c - nextSize);
        }
    }
}
