package day2;

import com.google.gson.Gson;
import day2.helpers.MainHelper;
import day2.models.TextInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task12 {
  public static void main(String[] args) throws Exception {
    System.out.printf("Enter your text");
    final Scanner in = new Scanner(System.in);
    final String str = in.nextLine();
    System.out.printf("Your text is: %s \n", str);

    System.out.printf("Enter your number");
    final Scanner in1 = new Scanner(System.in);
    final Integer limit = in1.nextInt();
    System.out.printf("Your number is: %s \n", limit);

    in1.close();
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

    List<String> forbiddenWords = new ArrayList<>();

    // TODO should create a scanner for params
    String pureText = str;
    forbiddenWords.add("test");
    forbiddenWords.add("aaaaa");
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
