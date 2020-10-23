package day8;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import day8.helpers.Users;
import day8.models.UserDataItem;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task1 {

  @Test
  @DisplayName("A user can find data by country")
  public void findDataByCountryTest() {
    Users users = new Users();
    Stream<UserDataItem> content = users.parseJson();
    String country = "USA";
    List<UserDataItem> data = users.findDataByCountry(content, country);
    for (UserDataItem value : data) {
      assertThat(value.getCounty(), is(country));
    }
  }

  @Test
  @DisplayName("A user can find data by age")
  public void findDataByAgeTest() {
    Users users = new Users();
    Stream<UserDataItem> content = users.parseJson();
    Integer age = 29;
    List<UserDataItem> data = users.findDataByAge(content, age);
    for (UserDataItem value : data) {
      assertThat(value.getAge(), is(age));
    }
  }

  @Test
  @DisplayName("A user can find data by greater than age ")
  public void findDataByGreaterThanAgeTest() {
    Users users = new Users();
    Stream<UserDataItem> content = users.parseJson();
    Integer age = 29;
    List<UserDataItem> data = users.findDataByGreaterThanAge(content, age);
    for (UserDataItem value : data) {
      assertThat(value.getAge(), greaterThan(age));
    }
  }

  @Test
  @DisplayName("A user can find data by less than or equal to age")
  public void findDataByLessThanOrEqualToAgeTest() {
    Users users = new Users();
    Stream<UserDataItem> content = users.parseJson();
    Integer age = 29;
    List<UserDataItem> data = users.findDataByLessThanOrEqualToAge(content, age);
    for (UserDataItem value : data) {
      assertThat(value.getAge(), lessThanOrEqualTo(age));
    }
  }

  @Test
  @DisplayName("A user can find data by teen")
  public void findDataByTeenTest() {
    Users users = new Users();
    Stream<UserDataItem> content = users.parseJson();
    Boolean teen = true;
    List<UserDataItem> data = users.findDataByTeen(content, teen);
    for (UserDataItem value : data) {
      assertThat(value.getIsTeen(), is(true)); // or use assertTrue
    }
  }
}
