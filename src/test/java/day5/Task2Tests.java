package day5;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import day5.helpers.DataHelper;
import day5.helpers.TextHelper;
import day5.models.DataText;
import day5.models.DataTextItem;
import java.util.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Task2Tests {

  @BeforeAll
  public static void beforeTests() {
    // delete files
  }

  @Test
  public void compareStrTest() {
    final String hash = "41036eebc46226948b717ff46391bf8a";
    final String str = "test";
    final String salt = "salt";

    assertThat(TextHelper.convertToMd5(str, salt), is(hash));
  }

  @Test
  public void compareStrNegativeTest() {
    final String hash = "41036eebc46226948b717ff46391bf8a";
    final String str = "test1";
    final String salt = "salt";

    assertThat(TextHelper.convertToMd5(str, salt), not(hash));
  }

  @Test
  public void compareWithEmptyStrTest() {
    final String hash = "154904654c97b006a7d6e83149fac932";
    final String str = "";
    final String salt = "salt";

    assertThat(TextHelper.convertToMd5(str, salt), is(hash));
  }

  @Test
  public void compareStrWithEmptyStrAndSaltTest() {
    final String hash = "cfcd208495d565ef66e7dff9f98764da";
    final String str = "";
    final String salt = "";

    assertThat(TextHelper.convertToMd5(str, salt), is(hash));
  }

  @Test
  public void putDataIntoFileAndGetContentTest() throws Exception {
    final String hash = "154904654c97b006a7d6e83149fac932";
    final String str = "";
    final String salt = "salt";

    final String hash1 = "41036eebc46226948b717ff46391bf8a";
    final String str1 = "test1";
    final String salt1 = "salt1";

    DataText dataText =
        DataText.builder()
            .item(DataTextItem.builder().hash(hash).salt(salt).text(str).build())
            .item(DataTextItem.builder().hash(hash1).salt(salt1).text(str1).build())
            .build();

    String jsonText = TextHelper.convertStrToJsonStr(dataText);
    DataHelper.filePutContent(jsonText);

    String content = DataHelper.fileGetContent();

    DataTextItem dataTextByHash = TextHelper.findDataTextByHash(content, hash1);

    assertThat(dataTextByHash.getHash(), is(hash1));
    assertThat(dataTextByHash.getSalt(), is(salt1));
    assertThat(dataTextByHash.getText(), is(str1));
  }
}
