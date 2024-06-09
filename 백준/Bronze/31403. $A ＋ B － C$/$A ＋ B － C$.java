import static java.lang.System.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

    public static void main(String[] args) throws Exception {
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int answer1 = a + b - c;
        String tmp = a + String.valueOf(b);
        int answer2 = Integer.parseInt(tmp) - c;

        bw.write(answer1 + "\n" + answer2);
        bw.flush();
    }
}
