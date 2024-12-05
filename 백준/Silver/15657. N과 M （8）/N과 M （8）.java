import java.io.*;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M;
    static int[] arr;
    static int[] tmp;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        String[] strings = br.readLine().split(" ");
        N = Integer.parseInt(strings[0]);
        M = Integer.parseInt(strings[1]);

        arr = new int[N];
        tmp = new int[N];
        visit = new boolean[N];
        strings = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }

        Arrays.sort(arr);
        backtracking(0, 0);
        bw.flush();
    }

    private static void backtracking(final int num, int start) throws IOException {
        if (num == M) {
            for (int i = 0; i < M; i++) {
                bw.write(tmp[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            tmp[num] = arr[i];
            backtracking(num + 1, i);
        }
    }
}
