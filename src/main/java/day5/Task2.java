package day5;

import day5.helpers.ScanHelper;
import day5.helpers.TextHelper;
import java.util.Scanner;

public class Task2 {
  public static void main(String[] args) throws Exception {
    final Scanner in = new Scanner(System.in);
    final String str = ScanHelper.scanText(in);
    final String salt = ScanHelper.scanText(in);
    in.close();

    System.out.println(String.format("Hash: %s", TextHelper.convertToMd5(str, salt)));
  }
}
