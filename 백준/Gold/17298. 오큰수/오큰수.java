import java.io.*;
import java.util.*;

class Pair {
    int idx;
    int value;

    public Pair(final int idx, final int value) {
        this.idx = idx;
        this.value = value;
    }
}

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(java.lang.System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(java.lang.System.out));

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());

        String[] strings = br.readLine().split(" ");
        Pair[] array = new Pair[n + 1];
        for (int i = 0; i < strings.length; i++) {
            array[i] = new Pair(i, Integer.parseInt(strings[i]));
        }

        Pair[] stack = new Pair[n + 1];
        int index = 0;

        int[] answer = new int[n + 1];
        for (int i = 0; i < strings.length; i++) {
            answer[i] = -1;
        }

        for (int i = 0; i < strings.length; i++) {
            if (index == 0) {
                stack[++index] = array[i];
                continue;
            }

            Pair top = stack[index]; // top = (3,4)
            int num = array[i].value; // num = 8

            if (top.value < num) {
                while (true) {
                    answer[top.idx] = num;
                    index--;
                    top = stack[index];
                    if (index == 0 || top.value >= num) {
                        break;
                    }
                }
            }

            stack[++index] = array[i];
        }

        for (int i = 0; i < strings.length; i++) {
            bw.write(answer[i] + " ");
        }

        bw.flush();
    }
}
