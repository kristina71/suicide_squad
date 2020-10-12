package day1;

import day1.helpers.MainHelper;

import java.util.Calendar;
import java.util.Scanner;
import java.util.TimeZone;

public class Task2 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String name = in.next();
        System.out.printf("Your name is : %s \n", name);

        Scanner in1 = new Scanner(System.in);
        String timezone = in1.next();
        System.out.printf("Your timezone is : %s \n", timezone);

        in1.close();
        in.close();

        MainHelper.checkName(name);

        // timezones: http://worldtimeapi.org/api/timezone
        String tz = MainHelper.getTimeZoneByCity(timezone);
        int hour = Calendar.getInstance(TimeZone.getTimeZone(tz)).get(Calendar.HOUR_OF_DAY);

        System.out.println(String.format("Current hour is %d", hour));
        System.out.println(MainHelper.getTextResultByHour(name, hour));
    }
}
