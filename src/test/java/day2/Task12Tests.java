package day2;

import day2.helpers.MainHelper;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Task12Tests {
    @Test
    void replaceTest(){
        assertThat(MainHelper.strReplace("test test","test", "***"), is("*** ***"));
        assertThat(MainHelper.strReplace("test test"," ", ""), is("testtest"));
    }

    @Test
    void cutStringTest(){
        assertThat(MainHelper.cutString("test test",3), is("tes..."));
        assertThat(MainHelper.cutString("test test",9), is("test test"));
        assertThat(MainHelper.cutString("test test",10), is("test test"));
    }
}
