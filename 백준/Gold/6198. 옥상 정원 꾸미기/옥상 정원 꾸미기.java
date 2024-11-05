import java.io.*;
import java.util.*;

class Pair {
    int value;
    int idx;

    public Pair(final int value, final int idx) {
        this.value = value;
        this.idx = idx;
    }
}

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(java.lang.System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(java.lang.System.out));

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n + 1];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Pair[] stack = new Pair[n + 1];
        int[] cnt = new int[n + 1];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            if (idx == 0) {
                stack[++idx] = new Pair(array[i], i);
                continue;
            }

            Pair top = stack[idx];
            int now = array[i];
            if (top.value > now) {
                stack[++idx] = new Pair(array[i], i);
            } else { // top <= now
                int tmp = 0;
                int deleteCnt = 0;
                while (idx > 0 && stack[idx].value <= now) {
                    cnt[stack[idx].idx] = cnt[stack[idx].idx] + tmp++;
                    idx--;
                    deleteCnt++;
                }

                for (int j = 1; j <= idx; j++) {
                    cnt[stack[idx].idx] = cnt[stack[idx].idx] + deleteCnt;
                }

                stack[++idx] = new Pair(now, i);
            }
        }

        int tmp = 0;
        while (idx > 0) {
            cnt[stack[idx].idx] = cnt[stack[idx].idx] + tmp++;
            idx--;
        }

        //bw.write(Arrays.toString(cnt) + "\n");

        long answer = 0;
        for (int i = 0; i < n; i++) {
            answer += cnt[i];
        }
        bw.write(answer + "");
        bw.flush();
    }
}
