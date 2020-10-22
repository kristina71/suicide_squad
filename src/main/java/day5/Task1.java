package day5;

import day5.helpers.ScanHelper;
import day5.helpers.TextHelper;
import java.util.Scanner;

public class Task1 {
  public static void main(String[] args) throws Exception {
    final Scanner in = new Scanner(System.in);
    final String str = ScanHelper.scanText(in);
    in.close();

    String encryptStr = TextHelper.encryptText(str);
    System.out.println(String.format("Encrypt string is: %s", encryptStr));

    String decryptText = TextHelper.decryptText(encryptStr);
    System.out.println(String.format("Decrypt string is: %s", decryptText));
  }
}
