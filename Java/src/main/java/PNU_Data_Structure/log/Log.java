package PNU_Data_Structure.log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Log {

  static Map<Long, List<Integer>> map = new HashMap<>();

  public void run(Scanner scanner) throws IOException {
    File file = new File("src/main/resources/PNU_Data_Structure/log/Public_Data/syslog.txt");
    BufferedReader br = new BufferedReader(new FileReader(file.getAbsoluteFile()));

    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String key = st.nextToken();
      String value;
      while ((value = st.nextToken()).equals("0")) {

      }
    }

    br.close();
  }

  public void print() {

  }
}
