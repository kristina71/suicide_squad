package day8.helpers;

import com.google.gson.Gson;
import day8.models.UserDataItem;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Users {
  public Stream<UserDataItem> parseJson() {
    String content = DataHelper.fileGetContent();
    UserDataItem[] extractDataText = new Gson().fromJson(content, UserDataItem[].class);
    return Arrays.stream(extractDataText);
  }

  public List<UserDataItem> findDataByCountry(Stream<UserDataItem> extractDataText, String county) {
    return extractDataText.filter(v -> v.getCounty().equals(county)).collect(Collectors.toList());
  }

  public List<UserDataItem> findDataByAge(Stream<UserDataItem> extractDataText, Integer age) {
    return extractDataText.filter(v -> v.getAge().equals(age)).collect(Collectors.toList());
  }

  public List<UserDataItem> findDataByGreaterThanAge(
      Stream<UserDataItem> extractDataText, Integer age) {
    return extractDataText.filter(v -> v.getAge() > age).collect(Collectors.toList());
  }

  public List<UserDataItem> findDataByLessThanOrEqualToAge(
      Stream<UserDataItem> extractDataText, Integer age) {
    return extractDataText.filter(v -> v.getAge() <= age).collect(Collectors.toList());
  }

  public List<UserDataItem> findDataByTeen(Stream<UserDataItem> extractDataText, Boolean teen) {
    return extractDataText.filter(v -> v.getIsTeen().equals(teen)).collect(Collectors.toList());
  }

  private static <T> Predicate<T> combineFilters(Predicate<T>... predicates) {
    Predicate<T> p = Stream.of(predicates).reduce(x -> true, Predicate::and);
    return p;
  }

  private static <T> Predicate<T> reduceFilters(Predicate<T>... predicates) {
    Predicate<T> p = Stream.of(predicates).reduce(x -> true, Predicate::or);
    return p;
  }

  public List<UserDataItem> findAdult(Stream<UserDataItem> extractDataText) {
    return extractDataText
        .filter(
                reduceFilters(
                combineFilters(v -> v.getAge() >= 18, v -> v.getCounty().equals("Russia")),
                combineFilters(v -> v.getAge() >= 20, v -> v.getCounty().equals("Japan")),
                combineFilters(v -> v.getAge() >= 21, v -> v.getCounty().equals("USA")),
                combineFilters(v -> v.getAge() >= 20, v -> v.getCounty().equals("Thailand"))))
        .collect(Collectors.toList());
  }

  public List<UserDataItem> findBrokenData(Stream<UserDataItem> extractDataText) {
    return extractDataText
        .filter(
                reduceFilters(
                combineFilters(
                    v -> v.getAge() >= 18,
                    v -> v.getCounty().equals("Russia"),
                    v -> v.getIsTeen().equals(false)),
                combineFilters(
                    v -> v.getAge() >= 20,
                    v -> v.getCounty().equals("Japan"),
                    v -> v.getIsTeen().equals(false)),
                combineFilters(
                    v -> v.getAge() >= 21,
                    v -> v.getCounty().equals("USA"),
                    v -> v.getIsTeen().equals(false)),
                combineFilters(
                    v -> v.getAge() >= 20,
                    v -> v.getCounty().equals("Thailand"),
                    v -> v.getIsTeen().equals(false))))
        .collect(Collectors.toList());
  }
}
