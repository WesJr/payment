package br.com.fiap.fastfood.payment.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationRequest {

    @JsonProperty("street_number")
    @JsonAlias({"street_number"})
    private String streetNumber;

    @JsonProperty("street_name")
    @JsonAlias({"street_name"})
    private String streetName;

    @JsonProperty("city_name")
    @JsonAlias({"city_name"})
    private String cityName;

    @JsonProperty("state_name")
    @JsonAlias({"state_name"})
    private String stateName;

    @JsonProperty("latitude")
    private double latitude;

    @JsonProperty("longitude")
    private double longitude;

    @JsonProperty("reference")
    private String reference;
}
