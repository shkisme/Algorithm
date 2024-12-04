import java.io.*;
import java.util.Set;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, S;
    static int answer = 0;
    static int now;
    static boolean[] visit;
    static int[] arr;
    static int[] tmp;

    public static void main(String[] args) throws Exception {
        String[] strings = br.readLine().split(" ");
        N = Integer.parseInt(strings[0]);
        visit = new boolean[N];
        arr = new int[N];
        tmp = new int[N];
        S = Integer.parseInt(strings[1]);

        strings = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }

        for (int i = 1; i <= N; i++) {
            now = i;
            backtracking(0, 0);
        }
        bw.write(answer + "");
        bw.flush();
    }

    private static void backtracking(final int num, int start) throws IOException {
        if (num == now) {
            int sum = 0;
            for (int i = 0; i < now; i++) {
                sum += tmp[i];
            }
            if (sum == S) {
                answer++;
            }
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                tmp[num] = arr[i];
                backtracking(num + 1, i);
                visit[i] = false;
            }
        }
    }
}
