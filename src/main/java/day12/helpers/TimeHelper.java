package day12.helpers;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class TimeHelper {
    public static String time(String startTime, String endTime){
        LocalTime localTime =LocalTime.parse(startTime);
        LocalTime localEndTime = LocalTime.parse(endTime);

        if (localEndTime.getHour()<localTime.getHour())
            localEndTime = localEndTime.plus(24, ChronoUnit.HOURS);

         LocalTime finalTime = localEndTime.minusHours(localTime.getHour()).minusMinutes(localTime.getMinute());
        return finalTime.getHour() + ":" + finalTime.getMinute();
    }
}
