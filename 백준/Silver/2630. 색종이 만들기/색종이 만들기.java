import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(in));

    static int N = 0;

    static int[][] arr;

    static int a1 = 0, a2 = 0; // 하얀색, 파란색

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] read = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(read[j]);
            }
        }

        fun(N, 0, 0);

        System.out.println(a2);
        System.out.println(a1);
    }

    private static void fun(int n, int x, int y) {
        int flag = arr[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (flag != arr[i][j]) {

                    fun(n / 2, x, y);
                    fun(n / 2, x, y + n / 2);
                    fun(n / 2, x + n / 2, y);
                    fun(n / 2, x + n / 2, y + n / 2);

                    return;
                }
            }
        }

        if (flag == 1) { // 파란색
            a1++;
        } else if (flag == 0) { // 하얀색
            a2++;
        }
    }
}
