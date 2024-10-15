import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(java.lang.System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(java.lang.System.out));

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String string = br.readLine();

            char[] stack = new char[100_001];
            int index = 0;

            for (int j = 0; j < string.length(); j++) {
                char charAt = string.charAt(j);
                if (charAt == 'A') {
                    if (stack[index] != 'A') {
                        stack[++index] = 'A';
                    } else if (stack[index] == 'A') {
                        index--;
                    }
                } else if (charAt == 'B') {
                    if (stack[index] != 'B') {
                        stack[++index] = 'B';
                    } else if (stack[index] == 'B') {
                        index--;
                    }
                }
            }

            if (index == 0) {
                cnt++;
            }
        }

        bw.write(cnt + "");
        bw.flush();
    }
}
