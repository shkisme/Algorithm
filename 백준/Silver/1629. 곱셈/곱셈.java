import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(java.lang.System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(java.lang.System.out));

    static long c;

    public static void main(String[] args) throws Exception {
        String[] strings = br.readLine().split(" ");
        long a = Integer.parseInt(strings[0]);
        long b = Integer.parseInt(strings[1]);
        c = Integer.parseInt(strings[2]);

        bw.write(myPow(a, b) + "");
        bw.flush();
    }

    private static long myPow(final long a, final long exponent) {
        if (exponent == 1) { // 지수가 1일 경우.
            return a % c;
        }

        long temp = myPow(a, exponent / 2);
        if (exponent % 2 == 1) { // 지수가 홀수일경우.
            return (temp * temp % c) * a % c;
        }
        return temp * temp % c;
    }
}
