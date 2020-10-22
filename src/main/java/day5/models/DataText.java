package day5.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

@Builder
@Getter
@AllArgsConstructor
public class DataText {
  @Singular("item")
  @SerializedName("data")
  List<DataTextItem> data;
}
