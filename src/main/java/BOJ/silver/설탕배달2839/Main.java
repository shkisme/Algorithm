package BOJ.silver.설탕배달2839;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  static int N, answer, q_divideByFive, r_divideByFive;

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
    q_divideByFive = N / 5; // 몫
    r_divideByFive = N % 5; // 나머지
  }

  private static void solve() {
    if (r_divideByFive == 0) { // 5 로 나누어 떨어지면, 바로 정답이다.
      answer = q_divideByFive;
      return;
    }

    while (true) {
      if ((N - q_divideByFive * 5) % 3 == 0) { // 나머지 금액이 3로 나누어 떨어진다면,
        answer = q_divideByFive + ((N - q_divideByFive * 5) / 3);
        break;
      }
      if (q_divideByFive == 0) { // 나머지 금액이 3로 나누어 떨어지지 않으면서, 더 감소시킬 5원이 없다면, 거슬러줄 수 없다.
        answer = -1;
        break;
      }
      q_divideByFive--; // 5 원 동전의 개수를 1 감소시킨다.
    }
  }

  private static void print(BufferedWriter bw) throws IOException {
    bw.write(String.valueOf(answer));
  }


}
