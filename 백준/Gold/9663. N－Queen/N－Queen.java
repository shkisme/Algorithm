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

    static int N = 0;
    static int cnt = 0;

    static boolean[] isUsed1 = new boolean[20]; // column 에 대응되는 값.
    static boolean[] isUsed2 = new boolean[40]; // 우측 상단을 연결하는 대각선 값
    static boolean[] isUsed3 = new boolean[40]; // 우측 하단을 연결하는 대각선 값 방문 판단을 하기 위한 배열.

    public static void main(String[] args) throws Exception {
        String read = br.readLine();
        N = Integer.parseInt(read);

        func(0);
        bw.write(cnt + "");
        bw.flush();
    }

    private static void func(int cur) throws IOException {
        if (cur == N) { // 퀸 N개를 놓는데 성공했다.
            cnt++; // 개수 증가
            return;
        }
        for (int i = 0; i < N; i++) { // cur - x, i - y
            if (isUsed1[i]
                    || isUsed2[i + cur]
                    || isUsed3[cur - i + N - 1]) { // 인덱스를 음수로 보내지 않게 하기 위해 N - 1을 더함.
                continue;
            }
            isUsed1[i] = true;
            isUsed2[i + cur] = true;
            isUsed3[cur - i + N - 1] = true;
            func(cur + 1);
            isUsed1[i] = false;
            isUsed2[i + cur] = false;
            isUsed3[cur - i + N - 1] = false;
        }
    }
}

