package day3;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import day3.helpers.MainHelper;
import org.junit.jupiter.api.Test;

public class Task2Tests {
  @Test
  public void analyzeTextTest() throws Exception {
    final String str =
        "Ну что ж я, я найти решения правильного не смогу ж? Смогу ж конечно, я ж старательный все ж таки.";
    final Integer minCount = 2;
    String analyzeJsonText = MainHelper.analyzeText(str, minCount);
    assertThat(analyzeJsonText, is("{\"ж\":5,\"я\":3,\"смогу\":2}"));
  }

  @Test
  public void analyzeTextWithZeroMaxAmountTest() throws Exception {
    final String str =
        "Ну что ж я, я найти решения правильного не смогу ж? Смогу ж конечно, я ж старательный все ж таки. Что-то надо ж делать";
    final Integer minCount = 0;
    String analyzeJsonText = MainHelper.analyzeText(str, minCount);
    System.out.println(analyzeJsonText);
    assertThat(
        analyzeJsonText,
        is(
            "{\"ну\":1,\"что\":1,\"ж\":6,\"я\":3,\"найти\":1,\"решения\":1,\"правильного\":1,\"не\":1,\"смогу\":2,\"конечно\":1,\"старательный\":1,\"все\":1,\"таки\":1,\"что-то\":1,\"надо\":1,\"делать\":1}"));
  }
}
