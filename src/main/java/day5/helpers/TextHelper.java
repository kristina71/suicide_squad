package day5.helpers;

import com.google.gson.Gson;
import day5.models.DataText;
import day5.models.DataTextItem;
import java.util.*;
import org.apache.commons.codec.digest.DigestUtils;

public class TextHelper {
  public static String decryptText(String str) throws Exception {
    return createNewStr(str, "next");
  }

  public static String encryptText(String str) throws Exception {
    return createNewStr(str, "prev");
  }

  private static String createNewStr(String str, String action) throws Exception {
    str = checkStrAndDeleteBadSymbols(str);

    StringJoiner joiner = new StringJoiner("");
    for (String letter : str.split("")) {
      joiner.add(replaceLetter(letter, action));
    }
    return joiner.toString();
  }

  private static String replaceLetter(String letter, String action) throws Exception {
    boolean characterCase = Character.isLowerCase(letter.charAt(0));

    HashMap<Integer, String> alphabet = initAlphabet();

    if (action.equals("prev")) letter = replaceToPreviousCharacter(letter, alphabet);
    else letter = replaceToNextCharacter(letter, alphabet);

    if (letter.equals("")) throw new Exception("Cannot find letter in alphabet");

    if (!characterCase) return letter.toLowerCase();
    else return letter.toUpperCase();
  }

  private static String replaceToNextCharacter(String letter, HashMap<Integer, String> alphabet) {
    String resultLetter = "";

    for (int i = 0; i < alphabet.size(); i++) {
      if (letter.equalsIgnoreCase(alphabet.get(i))) {
        if (letter.equalsIgnoreCase(alphabet.get(alphabet.size() - 1)))
          resultLetter = String.valueOf(alphabet.get(0));
        else resultLetter = String.valueOf(alphabet.get(i + 1));
      }
    }
    return resultLetter;
  }

  private static String replaceToPreviousCharacter(
      String letter, HashMap<Integer, String> alphabet) {
    String resultLetter = "";

    for (int i = 0; i < alphabet.size(); i++) {
      if (letter.equalsIgnoreCase(alphabet.get(i))) {
        if (letter.equalsIgnoreCase(alphabet.get(0)))
          resultLetter = String.valueOf(alphabet.get(alphabet.size() - 1));
        else resultLetter = String.valueOf(alphabet.get(i - 1));
      }
    }
    return resultLetter;
  }

  private static String checkStrAndDeleteBadSymbols(String str) throws Exception {
    str = str.replaceAll("([^a-zA-Z]+)+", "");
    if (str.length() < 1) throw new Exception("Empty string");
    else return str;
  }

  public static String convertToMd5(String str, String salt) {
    return DigestUtils.md5Hex(str + createSaltByTextLength(str, salt));
  }

  public static String convertStrToJsonStr(DataText dataText) {
    return new Gson().toJson(dataText);
  }

  public static String createSaltByTextLength(String str, String salt) {
    return salt + str.length();
  }

  private static HashMap<Integer, String> initAlphabet() {
    HashMap<Integer, String> alphabet = new HashMap<>();
    int j = 0;
    for (char i = 'a'; i <= 'z'; i++) {
      alphabet.put(j++, String.valueOf(i));
    }
    return alphabet;
  }

  public static DataTextItem findDataTextByHash(String content, String hash) throws Exception {
    DataText extractDataText = new Gson().fromJson(content, DataText.class);
    return extractDataText.getData().stream()
        .filter(v -> v.getHash().equals(hash))
        .findFirst()
        .orElseThrow(() -> new Exception(String.format("Cannot find hash %s", hash)));
  }
}
