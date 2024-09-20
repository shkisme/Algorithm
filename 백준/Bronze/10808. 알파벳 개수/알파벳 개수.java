import static java.lang.System.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

    public static void main(String[] args) throws Exception {
        int[] alphabets = new int[26];
        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            char charAt = input.charAt(i);
            alphabets[charAt - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            bw.write(alphabets[i] + " ");
        }

        bw.flush();
    }
}
