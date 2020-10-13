package day2;

import com.google.gson.Gson;
import day2.helpers.MainHelper;
import day2.helpers.ScanHelper;
import day2.models.TextInfo;
import helpers.PropertyLoader;
import java.util.Scanner;

public class Task12 {
  public static void main(String[] args) throws Exception {
    final Scanner in = new Scanner(System.in);
    final String str = ScanHelper.scanText(in);
    final Integer limit = ScanHelper.scanLimit(in);
    in.close();

    MainHelper.checkLimit(limit);
    final Integer textLength = MainHelper.getStrLength(str);
    final String textWithoutBackSpaces = MainHelper.strReplace(str, " ", "");

    System.out.println(String.format("Text length: %d", textLength));
    System.out.println(String.format("Text without backspaces: %s", textWithoutBackSpaces));

    if (textLength > limit)
      System.out.println(String.format("Text is longer than %d", textLength - limit));

    if (textLength % 2 == 0) System.out.println("This is even number");
    else System.out.println("This is odd number");

    String[] forbiddenWords = PropertyLoader.getProperties("forbidden_words").split(",");
    String pureText = str;
    for (String word : forbiddenWords) {
      pureText = MainHelper.strReplace(pureText, word, "***");
    }

    TextInfo obj =
        TextInfo.builder()
            .length(textLength)
            .pureLength(textWithoutBackSpaces.length())
            .originText(str)
            .pureText(pureText)
            .pureShortText(MainHelper.cutString(str, limit))
            .build();

    System.out.println(new Gson().toJson(obj));
  }
}
