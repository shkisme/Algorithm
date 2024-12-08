import java.io.*;
import java.util.LinkedList;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        String[] strings = br.readLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);

        strings = br.readLine().split(" ");
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }

        LinkedList<Integer> dq = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            dq.addLast(i);
        }

        int cnt = 0;

        for (int i = 0; i < m; i++) {
            int target = dq.indexOf(arr[i]);
            int mid;

            if (dq.size() % 2 == 0) {
                mid = dq.size() / 2 - 1;
            } else {
                mid = dq.size() / 2;
            }

            if (target <= mid) {
                for (int j = 0; j < target; j++) {
                    Integer num = dq.pollFirst();
                    dq.addLast(num);
                    cnt++;
                }
            } else {
                for (int j = 0; j < dq.size() - target; j++) {
                    Integer num = dq.pollLast();
                    dq.addFirst(num);
                    cnt++;
                }
            }
            dq.pollFirst();
        }
        bw.write(cnt + "");
        bw.flush();
    }
}
