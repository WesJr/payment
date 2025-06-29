package br.com.fiap.fastfood.payment.response;

import br.com.fiap.fastfood.payment.resources.BusinessHours;
import br.com.fiap.fastfood.payment.resources.Location;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LojaResponse {

    @JsonProperty("id")
    @JsonAlias("id")
    private long id;

    @JsonProperty("name")
    @JsonAlias("name")
    private String name;

    @JsonProperty("date_created")
    @JsonAlias("date_created")
    private String dateCreated;

    @JsonProperty("business_hours")
    @JsonAlias("business_hours")
    private BusinessHours businessHours;

    @JsonProperty("location")
    @JsonAlias("location")
    private Location location;

    @JsonProperty("external_id")
    @JsonAlias("external_id")
    private String externalId;


}
