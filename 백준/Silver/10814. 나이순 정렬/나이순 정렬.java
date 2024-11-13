import java.io.*;
import java.util.*;

class Pair {
    int age;
    String name;

    public Pair(final int age, final String name) {
        this.age = age;
        this.name = name;
    }
}

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(java.lang.System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(java.lang.System.out));

    static Pair[] arr;
    static Pair[] tmp = new Pair[100_001];

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            String[] strings = br.readLine().split(" ");
            arr[i] = new Pair(Integer.parseInt(strings[0]), strings[1]);
        }

        mergeSort(0, n);
        for (int i = 0; i < n; i++) {
            bw.write(arr[i].age + " " + arr[i].name + "\n");
        }
        bw.flush();
    }

    public static void mergeSort(int start, int end) {
        if (end == start + 1) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(start, mid);
        mergeSort(mid, end);
        merge(start, end);
    }

    public static void merge(int start, int end) {
        int mid = (start + end) / 2;
        int lidx = start;
        int ridx = mid;

        for (int i = start; i < end; i++) {
            if (ridx == end) {
                tmp[i] = arr[lidx++];
            } else if (lidx == mid) {
                tmp[i] = arr[ridx++];
            } else if (arr[lidx].age <= arr[ridx].age) {
                tmp[i] = arr[lidx++];
            } else {
                tmp[i] = arr[ridx++];
            }
        }

        for (int i = start; i < end; i++) {
            arr[i] = tmp[i];
        }
    }
}
