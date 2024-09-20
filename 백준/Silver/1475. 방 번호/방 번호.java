import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(java.lang.System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(java.lang.System.out));

    public static void main(String[] args) throws Exception {
        int[] numbers = new int[10];

        int n = Integer.parseInt(br.readLine());
        String toStr = String.valueOf(n);

        for (int i = 0; i < toStr.length(); i++) {
            int num = toStr.charAt(i) - '0';
            if (num == 9 || num == 6) {
                if (numbers[9] > numbers[6]) {
                    numbers[6]++;
                } else {
                    numbers[9]++;
                }
            } else {
                numbers[num]++;
            }
        }

        Arrays.sort(numbers);
        bw.write(numbers[9] + "");
        bw.flush();
    }
}
