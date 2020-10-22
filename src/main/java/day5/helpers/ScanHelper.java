package day5.helpers;

import java.util.Scanner;

public class ScanHelper {
  public static String scanText(Scanner in) {
    System.out.printf("Enter your string");
    final String str = in.nextLine();
    System.out.printf("Your string is: %s \n", str);
    return str;
  }
}
