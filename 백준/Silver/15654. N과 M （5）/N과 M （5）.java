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

    static int[] arr = new int[10];

    static int[] save;
    static boolean[] isVisit;

    public static void main(String[] args) throws Exception {
        String[] read = br.readLine().split(" ");
        N = Integer.parseInt(read[0]);
        M = Integer.parseInt(read[1]);

        read = br.readLine().split(" ");

        save = new int[N];
        isVisit = new boolean[N];

        for (int i = 0; i < N; i++) {
            save[i] = Integer.parseInt(read[i]);
        }

        Arrays.sort(save);

        func(0);
        bw.flush();
    }

    private static void func(int num) throws IOException { // 현재까지 K개의 수를 택함.
        if (num == M) { // M개를 모두 택했다면
            for (int i = 0; i < M; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = 0; i < N; i++) { // 1부터 n개까지 수에 대해서,
            if (!isVisit[i]) {
                arr[num] = save[i]; // K번째 수를 i로 정함.
                isVisit[i] = true;
                func(num + 1); // 다음 수를 정하러 한 단계 더 들어감.
                isVisit[i] = false;
            }
        }
    }
}

