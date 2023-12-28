import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(in));

    static int N = 0;

    static int[][] arr;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String read = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = read.charAt(j) - '0';
            }
        }

        fun(N, 0, 0);
    }

    private static void fun(int n, int x, int y) {

        int flag = arr[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (flag != arr[i][j]) {
                    System.out.print("(");
                    fun(n / 2, x, y);
                    fun(n / 2, x, y + n / 2);
                    fun(n / 2, x + n / 2, y);
                    fun(n / 2, x + n / 2, y + n / 2);
                    System.out.print(")");
                    return;
                }
            }
        }

        if (flag == 0) {
            System.out.print(0);
        } else if (flag == 1) {
            System.out.print(1);
        }

    }
}
