import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(java.lang.System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(java.lang.System.out));

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] arrays = new int[10_001];
        int index = 0;

        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            String order = inputs[0];

            if (order.equals("push")) {
                int num = Integer.parseInt(inputs[1]);
                arrays[++index] = num;
            } else if (order.equals("top")) {
                if (index == 0) {
                    bw.write("-1\n");
                    continue;
                }
                bw.write(arrays[index] + "\n");
            } else if (order.equals("size")) {
                bw.write(index + "\n");
            } else if (order.equals("pop")) {
                if (index == 0) {
                    bw.write("-1\n");
                    continue;
                }
                bw.write(arrays[index] + "\n");
                index--;
            } else if (order.equals("empty")) {
                if (index == 0) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            }
        }
        bw.flush();
    }
}
