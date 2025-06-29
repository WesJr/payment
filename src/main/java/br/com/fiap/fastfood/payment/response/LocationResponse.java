package br.com.fiap.fastfood.payment.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationResponse {

    @JsonProperty("address_line")
    @JsonAlias({"address_line"})
    private String addressLine;

    @JsonProperty("reference")
    @JsonAlias({"reference"})
    private String reference;

    @JsonProperty("latitude")
    private double latitude;

    @JsonProperty("longitude")
    private double longitude;
}
