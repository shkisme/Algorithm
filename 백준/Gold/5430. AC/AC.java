import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(java.lang.System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(java.lang.System.out));

    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());

            String string = br.readLine();
            String[] strings = string.substring(1, string.length() - 1).split(",");

            Deque<Integer> dq = new ArrayDeque<>();
            for (int j = 0; j < n; j++) {
                dq.addLast(Integer.parseInt(strings[j]));
            }

            boolean flag = false;
            boolean reverse = false;

            for (int j = 0; j < p.length(); j++) {
                char charAt = p.charAt(j);
                if (charAt == 'R') {
                    reverse = !reverse;
                } else if (charAt == 'D') {
                    if (dq.isEmpty()) {
                        bw.write("error\n");
                        flag = true;
                        break;
                    }

                    if (reverse) {
                        dq.pollLast();
                    } else {
                        dq.pollFirst();
                    }
                }
            }

            if (!flag) {
                if (reverse) {
                    StringBuilder answer = new StringBuilder("[");
                    int size = dq.size();
                    for (int j = 0; j < size; j++) {
                        answer.append(dq.pollLast());
                        if (j != size - 1) {
                            answer.append(",");
                        }
                    }
                    answer.append("]\n");
                    bw.write(String.valueOf(answer));
                } else {
                    StringBuilder answer = new StringBuilder("[");
                    int size = dq.size();
                    for (int j = 0; j < size; j++) {
                        answer.append(dq.pollFirst());
                        if (j != size - 1) {
                            answer.append(",");
                        }
                    }
                    answer.append("]\n");
                    bw.write(String.valueOf(answer));
                }
            }
        }
        bw.flush();
    }
}
