package day2.helpers;

public class MainHelper {
  public static void checkLimit(Integer number) throws Exception {
    if (number < 1)
      throw new Exception(String.format("Number should be > 1 , actual number is %d", number));
  }

  public static void checkString(String text) throws Exception {
    if (text.length() < 1)
      throw new Exception(
          String.format("Text length should be > 1 , actual text length is %d", text.length()));
  }

  public static String cutString(String str, Integer limit) {
    String subStr =
        str.codePointCount(0, str.length()) > limit
            ? str.substring(0, str.offsetByCodePoints(0, limit)) + "..."
            : str;
    return subStr;
  }

  public static String strReplace(String str, String from, String to) {
    return str.replace(from, to);
  }
}
