package day3.helpers;

import java.util.ArrayList;

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
}
