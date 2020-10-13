package day2;

import com.google.gson.Gson;
import day2.helpers.MainHelper;
import day2.models.TextInfo;

import java.util.Scanner;

public class Task12 {
    public static void main(String[] args) throws Exception {
        System.out.printf("Enter your text");
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.printf("Your text is : %s \n", str);

        System.out.printf("Enter your number");
        Scanner in1 = new Scanner(System.in);
        Integer limit = in1.nextInt();
        System.out.printf("Your number is : %s \n", limit);

        in1.close();
        in.close();

        MainHelper.checkLimit(limit);
        MainHelper.checkString(str);

        Integer textLength=str.length();
        String textWithoutBackSpaces=MainHelper.strReplace(str, " ","");
        String textWithoutStopWorld=MainHelper.strReplace(str, "test","***");

        System.out.println(String.format("Length - %d",textLength));
        System.out.println(String.format("Text without backspaces - %s",textWithoutBackSpaces));

        if (textLength>limit)
            System.out.println(String.format("Text is longer than %d", textLength - limit));

        if (textLength%2==0)
            System.out.println("This is even number");
        else
            System.out.println("This is odd number");

        TextInfo obj = TextInfo.builder()
                .length(textLength)
                .pureLength(textWithoutBackSpaces.length())
                .originText(str)
                .pureText(textWithoutStopWorld)
                .pureShortText(MainHelper.cutString(str, limit))
                .build();

        Gson gson = new Gson();
        String json = gson.toJson(obj);
        System.out.println(json);
    }
}
