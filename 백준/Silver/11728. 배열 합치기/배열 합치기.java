import static java.lang.System.in;
import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

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

        List<Integer> list = new ArrayList<>();

        while (true) {

            if (idx1 == N && idx2 == M) {
                break;
            }

            if (idx1 == N) { // 맨 마지막 원소
                list.add(arr2[idx2]);
                idx2++;
                continue;
            }

            if (idx2 == M) {
                list.add(arr1[idx1]);
                idx1++;
                continue;
            }
            int min = Math.min(arr1[idx1], arr2[idx2]);
            if (min == arr1[idx1]) {
                idx1++;
            } else {
                idx2++;
            }
            list.add(min);
        }

        for (int i : list) {
            bw.write(i + " ");
        }
        bw.flush();
    }
}
