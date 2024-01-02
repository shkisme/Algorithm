import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(in));

    static int N = 0, M = 0;

    static int[] arr = new int[10];
    static boolean[] isUsed = new boolean[10];

    public static void main(String[] args) throws Exception {
        String[] read = br.readLine().split(" ");
        N = Integer.parseInt(read[0]);
        M = Integer.parseInt(read[1]);

        func(0);
    }

    private static void func(int num) { // 현재까지 K개의 수를 택함.
        if (num == M) { // M개를 모두 택했다면
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= N; i++) { // 1부터 n개까지 수에 대해서,
            if (!isUsed[i]) { // 아직 사용되지 않았다면,
                arr[num] = i; // K번째 수를 i로 정함.
                isUsed[i] = true; // i를 사용했다고 표시
                func(num + 1); // 다음 수를 정하러 한 단계 더 들어감.
                isUsed[i] = false; // k번째 수를 i로 정한 모든 경우에 대해서 다 확인했으니, i를 이제 사용되지 않았다고 명시함.
            }
        }
    }
}
