import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());

        long[] fibo = new long[91];

        fibo[0] = 0;
        fibo[1] = 1;
        for (int i = 2; i <= 90; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
        bw.write(fibo[n] + "");
        bw.flush();
    }
}
