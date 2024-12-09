import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(java.lang.System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(java.lang.System.out));

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            String[] strings = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(strings[j]);
            }
        }

        int[][] sum = new int[n][3];
        sum[0][0] = arr[0][0];
        sum[0][1] = arr[0][1];
        sum[0][2] = arr[0][2];

        for (int i = 1; i < n; i++) {

            int m = Integer.MAX_VALUE;
            for (int j = 0; j < 3; j++) {
                if (j != 0 && sum[i - 1][j] < m) {
                    m = sum[i - 1][j];
                }
            }
            sum[i][0] = arr[i][0] + m;

            m = Integer.MAX_VALUE;
            for (int j = 0; j < 3; j++) {
                if (j != 1 && sum[i - 1][j] < m) {
                    m = sum[i - 1][j];
                }
            }
            sum[i][1] = arr[i][1] + m;

            m = Integer.MAX_VALUE;
            for (int j = 0; j < 3; j++) {
                if (j != 2 && sum[i - 1][j] < m) {
                    m = sum[i - 1][j];
                }
            }
            sum[i][2] = arr[i][2] + m;
        }

        int answer = Math.min(sum[n - 1][0], sum[n - 1][1]);
        answer = Math.min(answer, sum[n - 1][2]);
        bw.write(answer + "");
        bw.flush();
    }
}
