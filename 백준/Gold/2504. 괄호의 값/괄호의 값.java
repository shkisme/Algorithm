import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(java.lang.System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(java.lang.System.out));

    public static void main(String[] args) throws Exception {
        String string = br.readLine();

        char[] stack = new char[50];
        int idx = 0;

        int answer = 0;
        int cur = 1;

        for (int i = 0; i < string.length(); i++) {
            char charAt = string.charAt(i);
            if (charAt == '(') {
                stack[++idx] = charAt;
                cur *= 2;
            } else if (charAt == '[') {
                stack[++idx] = charAt;
                cur *= 3;
            } else if (charAt == ')') {
                if (idx == 0 || stack[idx] != '(') {
                    answer = 0;
                    break;
                }

                if (string.charAt(i - 1) == '(') {
                    answer += cur;
                }
                idx--;
                cur /= 2;
            } else if (charAt == ']') {
                if (idx == 0 || stack[idx] != '[') {
                    answer = 0;
                    break;
                }

                if (string.charAt(i - 1) == '[') {
                    answer += cur;
                }
                idx--;
                cur /= 3;
            }
        }
        if (idx != 0) {
            bw.write("0");
        } else {
            bw.write(answer + "");
        }
        bw.flush();
    }
}
