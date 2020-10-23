package day8.models;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDataItem {
  @SerializedName("id")
  private Integer id;

  @SerializedName("name")
  private String name;

  @SerializedName("fname")
  private String fname;

  @SerializedName("county")
  private String county;

  @SerializedName("age")
  private Integer age;

  @SerializedName("is_teen")
  private Boolean isTeen;
}
