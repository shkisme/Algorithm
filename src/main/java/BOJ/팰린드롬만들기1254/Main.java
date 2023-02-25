package BOJ.팰린드롬만들기1254;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    long start = System.currentTimeMillis();
    input(br);
    solve();
    print(bw);
    long end = System.currentTimeMillis();
    System.out.printf("[time]: %2d ms", (end - start));

    bw.flush();
    br.close();
    bw.close();
  }

  private static void input(BufferedReader br) throws IOException {
  }

  private static void solve() {

  }

  private static void print(BufferedWriter bw) throws IOException {

  }


}
