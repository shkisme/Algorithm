import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int one = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String[] reads = br.readLine().split(" ");
        int A = Integer.parseInt(reads[0]);
        int B = Integer.parseInt(reads[1]);
        int C = Integer.parseInt(reads[2]);

        one = A % C;
        System.out.println(fun(A, B, C));
    }

    private static long fun(int a, int b, int c) {
        if (b == 1) {
            return one;
        }
        if (b % 2 == 0) {
            long tmp = fun(a, b / 2, c);
            return (tmp * tmp) % c;
        }
        return (fun(a, b - 1, c) * one) % c;
    }
}
