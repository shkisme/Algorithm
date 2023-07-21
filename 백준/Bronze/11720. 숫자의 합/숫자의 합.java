import static java.lang.System.in;
import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

    int n = Integer.parseInt(br.readLine());

    int sum = 0;

    String input = br.readLine();

    for (int i = 0; i < n; i++) {
      sum += input.charAt(i) - '0';
    }

    bw.write(String.valueOf(sum));

    bw.flush();
    br.close();
    bw.close();
  }
}