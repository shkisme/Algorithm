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
        String[] read = br.readLine().split(" ");

        int N = Integer.parseInt(read[0]);
        int M = Integer.parseInt(read[1]);

        int[] arr1 = new int[N];
        int[] arr2 = new int[M];

        read = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(read[i]);
        }
        read = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(read[i]);
        }

        int idx1 = 0;
        int idx2 = 0;

        int[] ans = new int[N + M];

        for (int i = 0; i < N + M; i++) {
            if (idx2 == M) {
                ans[i] = arr1[idx1++];
            } else if (idx1 == N) {
                ans[i] = arr2[idx2++];
            } else if (arr1[idx1] <= arr2[idx2]) {
                ans[i] = arr1[idx1++];
            } else {
                ans[i] = arr2[idx2++];
            }
        }
        for (int i = 0; i < N + M; i++) {
            bw.write(ans[i] + " ");
        }
        bw.flush();
    }
}
