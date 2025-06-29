package br.com.fiap.fastfood.payment.resources;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class LojaRequest {

    @JsonProperty("name")
    @JsonAlias("name")
    private String name;

    @JsonProperty("business_hours")
    @JsonAlias("business_hours")
    private Map<String, List<TimeRange>> businessHours;

    @JsonProperty("external_id")
    @JsonAlias("external_id")
    private String externalId;

    @JsonProperty("location")
    @JsonAlias("location")
    private Location location;
}
