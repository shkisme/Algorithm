package BOJ.가장긴증가하는부분수열14002;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

  static int N;

  static int[] sequence;

  static int[] save = new int[1001];

  static int length = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    input(br);
    solve();
    print(bw);

    bw.flush();
    br.close();
    bw.close();
  }

  private static void input(BufferedReader br) throws IOException {
    N = Integer.parseInt(br.readLine());
    sequence = new int[N];
    String[] s = br.readLine().split(" ");
    for (int i = 0; i < s.length; i++) {
      sequence[i] = Integer.parseInt(s[i]);
    }
  }

  private static void solve() {
    for (int s : sequence){
      if (save[s] == 0){
        save[s] = 1;
      }
    }
  }

  private static void print(BufferedWriter bw) {
    List<Integer> list = new ArrayList<>();
    for (int i = 1; i <= 1000; i++){
      if (save[i] == 1){
        length++;
        list.add(i);
      }
    }
    System.out.println(length);
    for (int i : list){
      System.out.print(i + " ");
    }
  }
}
