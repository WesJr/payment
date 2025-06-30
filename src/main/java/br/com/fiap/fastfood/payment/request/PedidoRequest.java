package br.com.fiap.fastfood.payment.request;

import br.com.fiap.fastfood.payment.response.*;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PedidoRequest {

    @JsonProperty("type")
    private String type;

    @JsonProperty("total_amount")
    @JsonAlias("totalAmount")
    private String totalAmount;

    @JsonProperty("description")
    private String description;

    @JsonProperty("external_reference")
    @JsonAlias("external_reference")
    private String externalReference;

    @JsonProperty("expiration_time")
    @JsonAlias("expiration_time")
    private String expirationTime;

    @JsonProperty("marketplace_fee")
    @JsonAlias("marketplace_fee")
    private String marketplaceFee;

    @JsonProperty("integration_data")
    @JsonAlias("integration_data")
    private IntegrationData integrationData;

    @JsonProperty("config")
    @JsonAlias("config")
    private Config config;

    @JsonProperty("transactions")
    @JsonAlias("transactions")
    private Transactions transactions;

    @JsonProperty("taxes")
    @JsonAlias("taxes")
    private Taxes taxes;

    @JsonProperty("items")
    @JsonAlias("items")
    private List<Item> items;

    @JsonProperty("discounts")
    @JsonAlias("discounts")
    private Discounts discounts;
}
