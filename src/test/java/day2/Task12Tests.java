package day2;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import day2.helpers.MainHelper;
import org.junit.jupiter.api.Test;

public class Task12Tests {
  private static final String STR = "test test";

  @Test
  void replaceTest() {
    assertThat(MainHelper.strReplace(STR, "test", "***"), is("*** ***"));
    assertThat(MainHelper.strReplace(STR, " ", ""), is("testtest"));
  }

  @Test
  void cutStringTest() {
    assertThat(MainHelper.cutString(STR, 3), is("tes..."));
    assertThat(MainHelper.cutString(STR, 9), is("test test"));
    assertThat(MainHelper.cutString(STR, 10), is("test test"));
  }
}
