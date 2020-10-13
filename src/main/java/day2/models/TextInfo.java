package day2.models;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class TextInfo {
    @SerializedName("length")
    private Integer length;

    @SerializedName("pure_length")
    private Integer pureLength;

    @SerializedName("origin_text")
    private String originText;

    @SerializedName("pure_text")
    private String pureText;

    @SerializedName("pure_short_text")
    private String pureShortText;
}
