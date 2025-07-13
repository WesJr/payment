package br.com.fiap.fastfood.payment.request;

import br.com.fiap.fastfood.payment.response.SponsorRequest;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PedidoRequest {

    @JsonProperty("external_reference")
    @JsonAlias({"external_reference"})
    private String externalReference;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("notification_url")
    @JsonAlias({"notification_url"})
    private String notificationUrl;

    @JsonProperty("total_amount")
    @JsonAlias({"total_amount"})
    private double totalAmount;

    @JsonProperty("items")
    @JsonAlias("items")
    private List<ItemPedidoRequest> items;

    @JsonProperty("cash_out")
    @JsonAlias("cash_out")
    private CashOutRequest cashOut;

    @JsonProperty("sponsor")
    private SponsorRequest sponsor;
}
