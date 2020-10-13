package day2.helpers;

import java.util.Scanner;

public class ScanHelper {
  public static String scanText(Scanner in) {
    System.out.printf("Enter your text");
    final String str = in.nextLine();
    System.out.printf("Your text is: %s \n", str);
    return str;
  }

  public static Integer scanLimit(Scanner in) {
    System.out.printf("Enter your number");
    final Integer limit = in.nextInt();
    System.out.printf("Your number is: %s \n", limit);
    return limit;
  }
}
