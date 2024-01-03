import static java.lang.System.in;
import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

    static int N = 0, M = 0;

    static int[] save;
    static int[] arr = new int[10];

    public static void main(String[] args) throws Exception {
        String[] read = br.readLine().split(" ");

        N = Integer.parseInt(read[0]);
        M = Integer.parseInt(read[1]);

        read = br.readLine().split(" ");
        save = new int[N];
        for (int i = 0; i < N; i++) {
            save[i] = Integer.parseInt(read[i]);
        }
        Arrays.sort(save);

        func(0);
        bw.flush();
    }

    private static void func(int cur) throws IOException {
        if (cur == M) {
            for (int i = 0; i < M; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            arr[cur] = save[i];

            int flag = arr[0];
            boolean next = true;
            for (int k = 1; k <= cur; k++) {
                if (flag > arr[k]) {
                    next = false;
                    break;
                }
                flag = arr[k];
            }
            if (!next) {
                continue;
            }
            func(cur + 1);
        }
    }
}
