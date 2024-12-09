import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(java.lang.System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(java.lang.System.out));

    static int L, C;
    static char[] arr;
    static char[] tmp;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        String[] strings = br.readLine().split(" ");
        L = Integer.parseInt(strings[0]);
        C = Integer.parseInt(strings[1]);

        arr = new char[C];
        tmp = new char[C];
        visit = new boolean[C];
        strings = br.readLine().split(" ");
        for (int i = 0; i < C; i++) {
            arr[i] = strings[i].charAt(0);
        }

        Arrays.sort(arr);
        backtracking(0, 0);
        bw.flush();
    }

    private static void backtracking(final int num, int start) throws IOException {
        if (num == L) {
            int cntVowels = 0;
            int cntConsonants = 0;
            for (int i = 0; i < L; i++) {
                if (isVowel(tmp[i])) {
                    cntVowels++;
                }
                if (isConsonant(tmp[i])) {
                    cntConsonants++;
                }
            }
            if (cntVowels == 0 || cntConsonants < 2) {
                return;
            }
            for (int i = 0; i < L; i++) {
                bw.write(tmp[i] + "");
            }
            bw.write("\n");
            return;
        }

        for (int i = start; i < C; i++) {
            if (!visit[i]) {
                visit[i] = true;
                tmp[num] = arr[i];
                backtracking(num + 1, i);
                visit[i] = false;
            }
        }
    }

    private static boolean isConsonant(final char c) {
        return !(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }

    private static boolean isVowel(final char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
