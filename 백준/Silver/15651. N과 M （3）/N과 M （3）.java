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

    static int N = 0, M = 0;

    static int[] arr = new int[10];

    public static void main(String[] args) throws Exception {
        String[] read = br.readLine().split(" ");
        N = Integer.parseInt(read[0]);
        M = Integer.parseInt(read[1]);

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
        for (int i = 1; i <= N; i++) { // 1부터 n개까지 수에 대해서,
            arr[num] = i; // K번째 수를 i로 정함.
            func(num + 1); // 다음 수를 정하러 한 단계 더 들어감.
        }
    }
}

