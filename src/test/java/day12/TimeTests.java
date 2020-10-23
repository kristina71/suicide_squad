package day12;

import day12.helpers.TimeHelper;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TimeTests {
    @Test
    public void timeTest() {
        String startTime = "10:30";
        String endTime = "15:40";

        String timeStr = TimeHelper.time(startTime, endTime);
        assertThat(timeStr, is("5:10"));
    }

    @Test
    public void endTimeLessThanStartTimeTest() {
        String startTime = "15:30";
        String endTime = "11:40";

        String timeStr = TimeHelper.time(startTime, endTime);
        assertThat(timeStr, is("20:10"));
    }

    @Test
    public void endTimeEqualToStartTimeTest() {
        String startTime = "15:30";
        String endTime = "15:30";

        String timeStr = TimeHelper.time(startTime, endTime);
        assertThat(timeStr, is("0:0"));
    }

    @Test
    public void endMinutesLessThanStartMinutesTest() {
        String startTime = "15:30";
        String endTime = "15:20";

        String timeStr = TimeHelper.time(startTime, endTime);
        assertThat(timeStr, is("23:50"));
    }
}
