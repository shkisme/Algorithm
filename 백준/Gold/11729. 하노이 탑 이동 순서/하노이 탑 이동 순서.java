import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(java.lang.System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(java.lang.System.out));

    public static void main(String[] args) throws Exception {
        int k = Integer.parseInt(br.readLine());

        bw.write((1 << k) - 1 + "\n");
        func(1, 3, k);
        bw.flush();
    }

    // 원판 n개를 기둥 1에서 기둥 3으로 옮기는 방법을 출력하는 함수.
    // 시작 기둥과 도착 기둥도 인자로 받는 함수를 만든다.
    private static void func(final int a, final int b, final int n) throws IOException {
        if (n == 1) {
            bw.write(a + " " + b + "\n");
            return;
        }
        func(a, 6 - a - b, n - 1);
        bw.write(a + " " + b + "\n");
        func(6 - a - b, b, n - 1);
    }
}
