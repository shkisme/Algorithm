import java.io.*;
import java.util.*;

class Pair {
    int x, y;

    public Pair(final int x, final int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(java.lang.System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(java.lang.System.out));

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String string = br.readLine();

            char[] stack1 = new char[string.length() + 1];
            char[] stack2 = new char[string.length() + 1];
            int idx1 = 0;
            int idx2 = 0;

            for (int j = 0; j < string.length(); j++) {
                char charAt = string.charAt(j);

                if (charAt == '<') {
                    if (idx1 == 0) {
                        continue;
                    }
                    stack2[++idx2] = stack1[idx1--];
                } else if (charAt == '>') {
                    if (idx2 == 0) {
                        continue;
                    }
                    stack1[++idx1] = stack2[idx2--];
                } else if (charAt == '-') {
                    if (idx1 == 0) {
                        continue;
                    }
                    idx1--;
                } else {
                    stack1[++idx1] = charAt;
                }
            }

            while (idx2 > 0) {
                stack1[++idx1] = stack2[idx2--];
            }

            for (int j = 1; j < idx1 + 1; j++) {
                bw.write(stack1[j] + "");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
