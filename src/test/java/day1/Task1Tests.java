package day1;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import day1.helpers.MainHelper;
import helpers.PropertyLoader;
import org.junit.jupiter.api.Test;

public class Task1Tests {

  private static String NAME = PropertyLoader.getProperties("name");

  @Test
  void goodNightTest() throws Exception {
    assertThat(MainHelper.getTextResultByHour(NAME, 0), is(String.format("Доброй ночи, %s", NAME)));
    assertThat(MainHelper.getTextResultByHour(NAME, 4), is(String.format("Доброй ночи, %s", NAME)));
  }

  @Test
  void goodMorningTest() throws Exception {
    assertThat(MainHelper.getTextResultByHour(NAME, 5), is(String.format("Доброе утро, %s", NAME)));
    assertThat(MainHelper.getTextResultByHour(NAME, 9), is(String.format("Доброе утро, %s", NAME)));
  }

  @Test
  void goodAfternoonTest() throws Exception {
    assertThat(
        MainHelper.getTextResultByHour(NAME, 10), is(String.format("Добрый день, %s", NAME)));
    assertThat(
        MainHelper.getTextResultByHour(NAME, 16), is(String.format("Добрый день, %s", NAME)));
  }

  @Test
  void goodEveningTest() throws Exception {
    assertThat(
        MainHelper.getTextResultByHour(NAME, 17), is(String.format("Добрый вечер, %s", NAME)));
    assertThat(
        MainHelper.getTextResultByHour(NAME, 23), is(String.format("Добрый вечер, %s", NAME)));
  }
}
