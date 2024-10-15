import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(java.lang.System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(java.lang.System.out));

    public static void main(String[] args) throws Exception {
        while (true) {
            String string = br.readLine();
            char[] stack = new char[101];
            int index = 0;
            if (string.equals(".")) {
                break;
            }

            boolean isBalance = true;
            for (int i = 0; i < string.length(); i++) {
                char charAt = string.charAt(i);
                if (charAt == '(') {
                    stack[++index] = '(';
                } else if (charAt == '[') {
                    stack[++index] = '[';
                } else if (charAt == ')') {
                    if (index == 0) {
                        isBalance = false;
                        break;
                    }
                    if (stack[index] == '(') {
                        index--;
                    } else if (stack[index] == '[') {
                        isBalance = false;
                        break;
                    }
                } else if (charAt == ']') {
                    if (index == 0) {
                        isBalance = false;
                        break;
                    }
                    if (stack[index] == '[') {
                        index--;
                    } else if (stack[index] == '(') {
                        isBalance = false;
                        break;
                    }
                }
            }

            if (index != 0) {
                isBalance = false;
            }

            if (isBalance) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }
        bw.flush();
    }
}
