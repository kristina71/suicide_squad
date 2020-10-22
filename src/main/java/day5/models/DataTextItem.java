package day5.models;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class DataTextItem {
  @SerializedName("text")
  private String text;

  @SerializedName("hash")
  private String hash;

  @SerializedName("salt")
  private String salt;
}
