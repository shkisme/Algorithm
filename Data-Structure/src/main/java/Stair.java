import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Stair {

  public static void main(String[] args) {
    String resourcePath = "src/main/resources/";
    File file = new File(resourcePath + "HW1_Public_Data/01.inp");
    try (Scanner scanner = new Scanner(file.getAbsoluteFile(), StandardCharsets.UTF_8)) {
      while (scanner.hasNext()) {
        System.out.println(scanner.nextLine());
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
