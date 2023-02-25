package PNU_Data_Structure.log;

import PNU_Data_Structure.nanobot.Nanobot;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws IOException {
    File inputFile = new File(
        "src/main/resources/PNU_Data_Structure/" + "log" + "/Public_Data/" + "sp1"
            + ".inp"); // 문제 파일
    Scanner scanner = new Scanner(inputFile.getAbsoluteFile(), StandardCharsets.UTF_8);
    Log log = new Log();
    log.run(scanner);
    log.print();

    scanner.close();
  }
}
