package day3.helpers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainHelper {
  public static ArrayList<String> rebuildArray(ArrayList<String> arrayList) {
    ArrayList<String> newArray = new ArrayList<>();
    for (String lineItem : arrayList) {
      lineItem = lineItem.trim();
      lineItem = lineItem.replaceAll("[\\s]{2,}", " ");
      String[] words = lineItem.split(" ");
      for (String word : words) newArray.add(word);
    }
    System.out.println(newArray);
    return newArray;
  }

  public static String analyzeText(String str, Integer maxAmount) throws Exception {
    if (str.length() < 1) throw new Exception("Empty text!!");

    final JsonObject jsonObject = new JsonObject();

    str = str.toLowerCase().trim();
    str = str.replaceAll("[~!@#$%^&*(){}_+:\"<>?,./;']", " ");
    str = str.replaceAll("[\\s]{2,}", " ");

    System.out.println(str);
    String[] words = str.split(" ");
    for (String word : words) {
      int frequency = Collections.frequency(Arrays.asList(words), word);
      if (frequency >= maxAmount) {
        jsonObject.addProperty(word, frequency);
      }
    }
    String json = new Gson().toJson(jsonObject);
    System.out.println(json);
    return json;
  }
}
