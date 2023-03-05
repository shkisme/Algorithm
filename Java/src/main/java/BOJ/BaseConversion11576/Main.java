package BOJ.BaseConversion11576;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

  static int A;
  static int B;

  static int m;

  static List<Integer> integers;

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
    String s = br.readLine();
    String[] s1 = s.split(" ");
    A = Integer.parseInt(s1[0]);
    B = Integer.parseInt(s1[1]);
    m = Integer.parseInt(br.readLine());
    integers = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt)
        .collect(Collectors.toList());
  }

  private static void solve() {

  }

  private static void print(BufferedWriter bw) {

  }


}
