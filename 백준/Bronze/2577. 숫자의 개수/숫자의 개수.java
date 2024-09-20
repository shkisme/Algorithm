import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(java.lang.System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(java.lang.System.out));

    public static void main(String[] args) throws Exception {
        int[] numbers = new int[10];

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int mult = a * b * c;
        String toStr = String.valueOf(mult);
        for (int i = 0; i < toStr.length(); i++) {
            int dot = toStr.charAt(i) - '0';
            numbers[dot]++;
        }
        for (int i = 0; i < 10; i++) {
            bw.write(numbers[i] + "\n");
        }
        bw.flush();
    }
}
