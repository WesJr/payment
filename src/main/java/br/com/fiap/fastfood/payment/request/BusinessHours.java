package br.com.fiap.fastfood.payment.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BusinessHours {

    @JsonProperty("monday")
    @JsonAlias("monday")
    private List<TimeRange> monday;

    @JsonProperty("tuesday")
    @JsonAlias("tuesday")
    private List<TimeRange> tuesday;

    @JsonProperty("wednesday")
    @JsonAlias("wednesday")
    private List<TimeRange> wednesday;

    @JsonProperty("thursday")
    @JsonAlias("thursday")
    private List<TimeRange> thursday;

    @JsonProperty("friday")
    @JsonAlias("friday")
    private List<TimeRange> friday;

    @JsonProperty("saturday")
    @JsonAlias("saturday")
    private List<TimeRange> saturday;

    @JsonProperty("sunday")
    @JsonAlias("sunday")
    private List<TimeRange> sunday;
}
