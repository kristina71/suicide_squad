package day12.helpers;

import day12.exceptions.BadFormatException;
import day12.exceptions.BadHourException;
import day12.exceptions.BadMinuteException;
import day12.exceptions.BadNumberException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class TimeHelper {
  public static String time(String startTime, String endTime) {
    checkFormat(startTime);
    checkFormat(endTime);

    LocalTime localTime = LocalTime.parse(startTime);
    LocalTime localEndTime = LocalTime.parse(endTime);

    if (localEndTime.getHour() < localTime.getHour())
      localEndTime = localEndTime.plus(24, ChronoUnit.HOURS);

    LocalTime finalTime =
        localEndTime.minusHours(localTime.getHour()).minusMinutes(localTime.getMinute());

    return finalTime.getHour() + ":" + finalTime.getMinute();
  }

  private static void checkFormat(String time) {
    time = time.trim();

    if (time.matches("(?is)/(\\d+)[\\:](\\d+)$/"))
      throw new BadFormatException(String.format("Bad format %s", time));

    String[] splitTime = time.split(":");

    try {
      if (Integer.parseInt(splitTime[0]) > 23 || Integer.parseInt(splitTime[0]) < 0)
        throw new BadHourException(String.format("Bad hour format %s", time));
    } catch (Exception e) {
      throw new BadNumberException(
          String.format("Bad hour number format %s", time), e.fillInStackTrace());
    }

    try {
      if (Integer.parseInt(splitTime[1]) > 59 || Integer.parseInt(splitTime[0]) < 0)
        throw new BadMinuteException(String.format("Bad minute format %s", time));
    } catch (Exception e) {
      throw new BadNumberException(
          String.format("Bad minute number format %s", time), e.fillInStackTrace());
    }
  }
}
