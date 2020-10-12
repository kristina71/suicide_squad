package day1.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WorldTimeResponse {
    @JsonProperty("abbreviation")
    private String abbreviation;

    @JsonProperty("client_ip")
    private String clientIp;

    @JsonProperty("datetime")
    private String datetime;

    @JsonProperty("day_of_week")
    private Integer dayOfWeek;

    @JsonProperty("day_of_year")
    private Integer dayOfYear;

    @JsonProperty("dst")
    private Boolean dst;

    @JsonProperty("dst_from")
    private String dstFrom;

    @JsonProperty("dst_offset")
    private Integer dstOffset;

    @JsonProperty("dst_until")
    private String dstUntil;

    @JsonProperty("raw_offset")
    private Integer rawOffset;

    @JsonProperty("timezone")
    private String timezone;

    @JsonProperty("unixtime")
    private Integer unixtime;

    @JsonProperty("utc_datetime")
    private String utcDatetime;

    @JsonProperty("utc_offset")
    private String utcOffset;

    @JsonProperty("week_number")
    private Integer weekNumber;

    @JsonProperty("timezone")
    public String getTimezone() {
        return timezone;
    }
}
