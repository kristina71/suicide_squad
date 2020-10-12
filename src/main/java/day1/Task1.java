package day1;

import day1.helpers.MainHelper;

import java.util.Calendar;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String name = in.next();

        System.out.printf("Your name is : %s \n", name);
        in.close();
        MainHelper.checkName(name);

        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        System.out.println(String.format("Current hour is %d", hour));
        System.out.println(MainHelper.getTextResultByHour(name, hour));
    }
}