import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(java.lang.System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(java.lang.System.out));

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];

        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        int index = 1;
        int start = 1;
        int[] stack = new int[100_001];

        boolean flag = true;
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int num = list[i];
            if (stack[index - 1] > num) {
                flag = false;
                break;
            }
            while (stack[index - 1] != num) {
                stack[index] = start;
                start++;
                index++;
                answer.append("+\n");
            }
            stack[index - 1] = 0;
            index--;
            answer.append("-\n");
        }

        if (flag) {
            bw.write(answer.toString());
        } else {
            bw.write("NO");
        }
        bw.flush();
    }
}
