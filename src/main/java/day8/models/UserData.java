package day8.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserData {
  @SerializedName("data")
  private List<UserDataItem> userData;
}
