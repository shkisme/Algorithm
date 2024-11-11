import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(java.lang.System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(java.lang.System.out));

    static int ans1, ans2, ans3;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());

        arr = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            String[] strings = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(strings[j]);
            }
        }

        func(n, 0, 0);
        bw.write(ans1 + "\n");
        bw.write(ans2 + "\n");
        bw.write(ans3 + "\n");
        bw.flush();
    }

    public static void func(int size, int x, int y) throws IOException {
        int num = arr[x][y];
        if (size == 1) {
            //bw.write("1: " + num + "\n");
            judge(num);
            return;
        }

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != num) {
                    int nextSize = size / 3;
                    for (int k = 0; k < 3; k++) {
                        for (int z = 0; z < 3; z++) {
                            //bw.write("nextSize: " + nextSize + " x: " + x + " y: " + y + "\n");
                            func(nextSize, nextSize * k + x, nextSize * z + y);
                        }
                    }
                    return;
                }
            }
        }
        //bw.write("x: " + x + " y: " + y + " size: " + size + "\n");
        judge(num);
    }

    public static void judge(int num) {
        if (num == -1) {
            ans1++;
        } else if (num == 0) {
            ans2++;
        } else if (num == 1) {
            ans3++;
        }
    }
}
