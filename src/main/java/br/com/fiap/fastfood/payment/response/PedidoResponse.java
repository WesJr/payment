package br.com.fiap.fastfood.payment.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PedidoResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("user_id")
    @JsonAlias({"user_id"})
    private String userId;

    @JsonProperty("type")
    private String type;

    @JsonProperty("external_reference")
    @JsonAlias({"external_reference"})
    private String externalReference;

    @JsonProperty("description")
    private String description;

    @JsonProperty("expiration_time")
    @JsonAlias({"expiration_time"})
    private String expirationTime;

    @JsonProperty("processing_mode")
    @JsonAlias({"processing_mode"})
    private String processingMode;

    @JsonProperty("total_amount")
    @JsonAlias({"total_amount"})
    private String totalAmount;

    @JsonProperty("country_code")
    @JsonAlias({"country_code"})
    private String countryCode;

    @JsonProperty("marketplace_fee")
    @JsonAlias({"marketplace_fee"})
    private String marketplaceFee;

    @JsonProperty("integration_data")
    @JsonAlias({"integrationData"})
    private IntegrationData integrationData;

    @JsonProperty("config")
    @JsonAlias("config")
    private Config config;

    @JsonProperty("transactions")
    @JsonAlias("transactions")
    private Transactions transactions;

    @JsonProperty("taxes")
    @JsonAlias("taxes")
    private List<Taxes> taxes;

    @JsonAlias("items")
    @JsonProperty("items")
    private List<Item> items;

    @JsonProperty("discounts")
    @JsonAlias("discounts")
    private Discounts discounts;

    @JsonProperty("type_response")
    @JsonAlias("type_response")
    private TypeResponse typeResponse;
}
