package PNU_Algorithm.deck;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Deck {

  static int N;
  static int sum = 0;

  static int count = 0;

  static int flag = 1;

  public static void main(String[] args) throws IOException {
    /*
    01.inp -> 3, 6 (O)
    02.inp -> 56 (O)
    03.inp -> 24, 56
     */
    String resourcePath = "src/main/resources/";
    File file = new File(resourcePath + "PNU_Algorithm/deck/03.inp");
    Scanner scanner1 = new Scanner(file.getAbsoluteFile(), StandardCharsets.UTF_8);

    inputFirst(scanner1);
    scanner1.close();
    Scanner scanner2 = new Scanner(file.getAbsoluteFile(), StandardCharsets.UTF_8);
    scanner2.nextLine();
    inputSecond(scanner2);
    scanner2.close();
    print();
  }

  private static void inputFirst(Scanner scanner){
    N = Integer.parseInt(scanner.nextLine());
    for (int i = 1; i <= N; i++) {
      sum += i;
    }
    while (scanner.hasNext()) {
      int card = Integer.parseInt(scanner.nextLine());
      count++;
      sum -= card;
    }
  }

  private static void inputSecond(Scanner scanner) {
    if (count == N - 2) {
      while (scanner.hasNextLine()) {
        int card = Integer.parseInt(scanner.nextLine());
        if (card == flag) {
          System.out.println("card = " + card);
          System.out.println("flag = " + flag);
          flag++;
        }
      }
    }
  }

  private static void print() {
    if (count == N - 1) {
      System.out.println(sum);
    } else {
      System.out.println(flag);
      System.out.println(sum - flag);
    }
  }
}
