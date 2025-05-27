package br.com.fiap.fastfood.payment.resources;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {

    @JsonProperty("address_line")
    @JsonAlias("address_line")
    private String addressLine;

    @JsonProperty("latitude")
    @JsonAlias("latitude")
    private double latitude;

    @JsonProperty("longitude")
    @JsonAlias("longitude")
    private double longitude;

    @JsonProperty("reference")
    @JsonAlias("reference")
    private String reference;
}
