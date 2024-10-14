import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(java.lang.System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(java.lang.System.out));

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String string = br.readLine();
            int index = 0;
            boolean isVps = true;
            for (int j = 0; j < string.length(); j++) {
                if (string.charAt(j) == '(') {
                    index++;
                } else {
                    if (index == 0) {
                        isVps = false;
                        break;
                    }
                    index--;
                }
            }
            if (index != 0 || !isVps) {
                bw.write("NO\n");
            } else {
                bw.write("YES\n");
            }
        }
        bw.flush();
    }
}
