package day1.helpers;

import static io.restassured.RestAssured.given;

import day1.models.WorldTimeResponse;
import io.restassured.http.ContentType;

public class MainHelper {
  public static String getTextResultByHour(String name, int hour) throws Exception {
    if (hour >= 0 && hour < 5) return String.format("Доброй ночи, %s", name);
    else if (hour >= 5 && hour < 10) return String.format("Доброе утро, %s", name);
    else if (hour >= 10 && hour < 17) return String.format("Добрый день, %s", name);
    else if (hour >= 17 && hour <= 23) return String.format("Добрый вечер, %s", name);
    else throw new Exception("Invalid time");
  }

  public static void checkName(String name) throws Exception {
    if (!name.equals(PropertyLoader.getProperties("name"))) throw new Exception("Access denied");
  }

  public static String getTimeZoneByCity(String timezone) {
    return given()
        .contentType(ContentType.JSON)
        .when()
        .get(String.format("http://worldtimeapi.org/api/timezone/%s", timezone))
        .getBody()
        .as(WorldTimeResponse.class)
        .getTimezone();
  }
}
