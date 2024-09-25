import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(java.lang.System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(java.lang.System.out));

    public static void main(String[] args) throws Exception {
        int k = Integer.parseInt(br.readLine());

        int[] arrays = new int[100_001];
        int index = 0;

        for (int i = 0; i < k; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                index--;
            } else {
                arrays[++index] = num;
            }
        }

        long sum = 0;

        for (int i = 1; i <= index; i++) {
            sum += arrays[i];
        }
        bw.write(sum + "");
        bw.flush();
    }
}
