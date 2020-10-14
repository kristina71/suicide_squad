package day3;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import day3.helpers.MainHelper;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class Task1Tests {
  @Test
  void rebuildArrayTest() {
    ArrayList<String> arrayList = new ArrayList<>();
    arrayList.add("apple banana");
    arrayList.add("orange");
    arrayList.add("banana");
    arrayList.add("kiwi strawberry blueberry");
    ArrayList<String> resultArray = MainHelper.rebuildArray(arrayList);

    ArrayList<String> actualArray =
        new ArrayList<>(
            Arrays.asList(
                "apple", "banana", "orange", "banana", "kiwi", "strawberry", "blueberry"));

    assertThat(resultArray, is(actualArray));
  }

  @Test
  void rebuildArrayWithBackSpacesTest() {
    ArrayList<String> arrayList = new ArrayList<>();
    arrayList.add("apple banana  ");
    arrayList.add("  orange");
    arrayList.add("banana    ");
    arrayList.add("kiwi     strawberry       blueberry");
    ArrayList<String> resultArray = MainHelper.rebuildArray(arrayList);

    ArrayList<String> actualArray =
        new ArrayList<>(
            Arrays.asList(
                "apple", "banana", "orange", "banana", "kiwi", "strawberry", "blueberry"));

    assertThat(resultArray, is(actualArray));
  }

  @Test
  void rebuildEmptyArrayTest() {
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayList<String> resultArray = MainHelper.rebuildArray(arrayList);

    assertThat(resultArray, empty());
  }
}
