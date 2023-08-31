package 이코테.DP;

import static java.lang.System.in;
import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.List;

public class 일로만들기 {


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(in));

    int[] nums = new int[1000001];
    nums[2] = 1;
    nums[3] = 1;

    int input = Integer.parseInt(br.readLine());

    for (int i = 4; i <= input; i++) {
      nums[i] = nums[i - 1] + 1;

      if (i % 2 == 0 && i % 3 == 0) {
        int n1 = nums[i / 2] + 1;
        int n2 = nums[i / 3] + 1;

        nums[i] = List.of(n1, n2, nums[i]).stream()
            .min(Comparator.naturalOrder())
            .orElse(null); // 세 수중에 최소값 찾기 귀찮아서 이렇게 처리하였다.
      } else if (i % 2 == 0) {
        nums[i] = Math.min(nums[i], nums[i / 2] + 1);
      } else if (i % 3 == 0) {
        nums[i] = Math.min(nums[i], nums[i / 3] + 1);
      }
    }

    out.println(nums[input]);
  }
}
