import static java.lang.System.in;
import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.List;

public class Main {


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

    int[] nums = new int[1000001];
    nums[2] = 1;
    nums[3] = 1;

    int input = Integer.parseInt(br.readLine());

    for (int i = 4; i <= input; i++) {
      if (i % 2 == 0 && i % 3 == 0) {
        int n1 = nums[i / 2] + 1;
        int n2 = nums[i / 3] + 1;
        int n3 = nums[i - 1] + 1;

        nums[i] = List.of(n1, n2, n3).stream()
            .min(Comparator.naturalOrder())
            .orElse(null);
      } else if (i % 2 == 0) {
        nums[i] = nums[i / 2] < nums[i - 1] ? nums[i / 2] + 1 : nums[i - 1] + 1;
      } else if (i % 3 == 0) {
        nums[i] = nums[i / 3] < nums[i - 1] ? nums[i / 3] + 1 : nums[i - 1] + 1;
      } else {
        nums[i] = nums[i - 1] + 1;
      }
    }

    bw.write(String.valueOf(nums[input]));

    bw.flush();
    br.close();
    bw.close();
  }
}