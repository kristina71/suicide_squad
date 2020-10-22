package day5;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import day5.helpers.TextHelper;
import org.junit.jupiter.api.Test;

public class Task1Tests {
  @Test
  public void decryptTextTest() throws Exception {
    final String str = "AbvcbZz";
    final String expectedStr = "bCWDCaA";
    assertThat(TextHelper.decryptText(str), is(expectedStr));
  }

  @Test
  public void encryptTextTest() throws Exception {
    final String str = "bcWDCAa";
    final String expectedStr = "ABvcbzZ";
    assertThat(TextHelper.encryptText(str), is(expectedStr));
  }

  @Test
  public void encryptTextWithBadSymbolsTest() throws Exception {
    final String str = "bcWD4454*7§CAa";
    final String expectedStr = "ABvcbzZ";
    assertThat(TextHelper.encryptText(str), is(expectedStr));
  }

  @Test
  public void decryptTextWithBadSymbolsTest() throws Exception {
    final String str = "bCWDCaA";
    final String expectedStr = "CdxedBb";
    assertThat(TextHelper.decryptText(str), is(expectedStr));
  }
}
