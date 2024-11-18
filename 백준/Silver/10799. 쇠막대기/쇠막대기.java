import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(java.lang.System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(java.lang.System.out));

    public static void main(String[] args) throws Exception {
        String string = br.readLine();

        char[] stack = new char[100_001];
        int idx = 0;

        int answer = 0;

        for (int i = 0; i < string.length(); i++) {
            char charAt = string.charAt(i);
            if (charAt == '(') {

                stack[++idx] = charAt;
                answer++;

            } else if (charAt == ')') {
                if (string.charAt(i - 1) == '(') {
                    answer--;
                    idx--;

                    answer += idx;
                } else {
                    idx--;
                }
            }
        }
        bw.write(answer + "");
        bw.flush();
    }
}
