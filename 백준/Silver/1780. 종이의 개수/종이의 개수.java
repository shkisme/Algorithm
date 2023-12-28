import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(in));

    static int N = 0;

    static int[][] arr;

    static int a1 = 0, a2 = 0, a3 = 0; // -1, 0, 1

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

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
    }

    private static void fun(int n, int x, int y) {
        int flag = arr[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (flag != arr[i][j]) {

                    // TODO : 재귀 실행
                    fun(n / 3, x, y);
                    fun(n / 3, x, y + n / 3);
                    fun(n / 3, x, y + (n / 3) * 2);

                    fun(n / 3, x + n / 3, y);
                    fun(n / 3, x + n / 3, y + n / 3);
                    fun(n / 3, x + n / 3, y + (n / 3) * 2);

                    fun(n / 3, x + (n / 3) * 2, y);
                    fun(n / 3, x + (n / 3) * 2, y + n / 3);
                    fun(n / 3, x + (n / 3) * 2, y + (n / 3) * 2);

                    return;
                }
            }
        }

        if (flag == -1) {
            a1++;
        } else if (flag == 0) {
            a2++;
        } else {
            a3++;
        }
    }
}
