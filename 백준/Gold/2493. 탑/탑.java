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

        String[] strings = br.readLine().split(" ");

        Pair[] stack = new Pair[500_001];
        int idx = 0;
        int[] answer = new int[n];
        boolean[] exist = new boolean[n];

        for (int i = 0; i < n; i++) {
            int parseInt = Integer.parseInt(strings[i]);

            if (idx == 0) {
                answer[0] = 0;
                stack[++idx] = new Pair(parseInt, i);
                continue;
            }

            if (stack[idx].value < parseInt) {
                while (true) {
                    if (idx == 0) {
                        break;
                    }
                    if (stack[idx].value > parseInt) {
                        answer[i] = stack[idx].idx;
                        exist[i] = true;
                        break;
                    }
                    idx--;
                }
                stack[++idx] = new Pair(parseInt, i);
            } else {
                answer[i] = stack[idx].idx;
                exist[i] = true;
                stack[++idx] = new Pair(parseInt, i);
            }
        }
        for (int i = 0; i < n; i++) {
            if (!exist[i]) {
                bw.write(answer[i] + " ");
            } else {
                bw.write(answer[i] + 1 + " ");
            }
        }
        bw.flush();
    }
}
