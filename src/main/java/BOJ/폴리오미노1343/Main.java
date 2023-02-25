package BOJ.폴리오미노1343;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

  static String board;

  static List<String> strings = new ArrayList<>();

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
    board = br.readLine();
  }

  private static void solve() {
    List<String> split1 = Arrays.stream(board.split("\\.")).filter(s -> s.contains("X"))
        .collect(toList());
    List<String> split2 = Arrays.stream(board.split("X")).filter(s -> s.contains("."))
        .collect(toList());

    if (split1.isEmpty()) {
      for (String str : split2) {
        System.out.println(str);
      }
      return;
    }

    for (int i = 0; i < split2.size(); ++i) {
      strings.add(split1.get(i));
      strings.add(split2.get(i));
    }
    if (split1.size() != 1) {
      strings.add(split1.get(split1.size() - 1));
    }
    if (split1.size() == 1 && split2.isEmpty()) {
      strings.add(split1.get(0));
    }

    if (isOddLengthIn(strings)) {
      System.out.print(-1);
    } else {
      for (String s : strings) {
        if (s.contains(".")) {
          System.out.print(s);
        } else if (s.length() == 2) {
          System.out.print(s.replace("X", "B"));
        } else if (s.length() % 4 == 0) {
          System.out.print(s.replace("X", "A"));
        } else {
          int lengthA = (s.length() / 4) * 4;
          int lengthB = s.length() - lengthA;
          for (int i = 0; i < lengthA; ++i) {
            System.out.print("A");
          }
          for (int i = 0; i < lengthB; ++i) {
            System.out.print("B");
          }
        }
      }
    }
  }

  private static boolean isOddLengthIn(List<String> strings) {
    for (String s : strings) {
      if (s.length() % 2 != 0 && !s.contains(".")) {
        return true;
      }
    }
    return false;
  }

  private static void print(BufferedWriter bw) throws IOException {

  }


}
