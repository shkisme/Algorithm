import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(java.lang.System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(java.lang.System.out));

    static int[] arr;
    static boolean[] done;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            done = new boolean[n + 1];
            visited = new boolean[n + 1];
            result = 0;
            String[] strings = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[j + 1] = Integer.parseInt(strings[j]);
            }

            for (int j = 1; j <= n; j++) {
                if (!done[j]) {
                    dfs(j);
                }
            }
            bw.write(n - result + "\n");
        }
        bw.flush();
    }

    private static void dfs(final int num) {
        if (done[num]) {
            return;
        }

        if (visited[num]) {
            done[num] = true;
            result++;
        }

        visited[num] = true;
        dfs(arr[num]);
        done[num] = true;
        visited[num] = false;
    }
}
