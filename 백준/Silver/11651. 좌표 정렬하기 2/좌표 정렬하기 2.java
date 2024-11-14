import java.io.*;
import java.util.*;

class Pair {
    int x, y;

    public Pair(final int x, final int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(java.lang.System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(java.lang.System.out));

    static Pair[] arr;
    static Pair[] tmp;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        arr = new Pair[n];
        tmp = new Pair[n];
        for (int i = 0; i < n; i++) {
            String[] strings = br.readLine().split(" ");
            int x = Integer.parseInt(strings[0]);
            int y = Integer.parseInt(strings[1]);
            arr[i] = new Pair(x, y);
        }
        mergeSort(0, n);
        for (int i = 0; i < n; i++) {
            bw.write(arr[i].x + " " + arr[i].y + "\n");
        }
        bw.flush();
    }

    private static void mergeSort(final int start, final int end) {
        if (start + 1 == end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(start, mid);
        mergeSort(mid, end);
        merge(start, end);
    }

    private static void merge(int start, int end) {
        int mid = (start + end) / 2;
        int lidx = start;
        int ridx = mid;

        for (int i = start; i < end; i++) {
            if (lidx == mid) {
                tmp[i] = arr[ridx++];
            } else if (ridx == end) {
                tmp[i] = arr[lidx++];
            } else if (arr[lidx].y < arr[ridx].y) {
                tmp[i] = arr[lidx++];
            } else if (arr[lidx].y == arr[ridx].y) {
                if (arr[lidx].x < arr[ridx].x) {
                    tmp[i] = arr[lidx++];
                } else {
                    tmp[i] = arr[ridx++];
                }
            } else {
                tmp[i] = arr[ridx++];
            }
        }

        for (int i = start; i < end; i++) {
            arr[i] = tmp[i];
        }
    }
}
