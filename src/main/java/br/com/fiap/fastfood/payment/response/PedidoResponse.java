package br.com.fiap.fastfood.payment.response;

import br.com.fiap.fastfood.payment.request.ItemPedidoRequest;
import br.com.fiap.fastfood.payment.request.CashOutRequest;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoResponse {

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
    private BigDecimal totalAmount;

    @JsonProperty("expiration_date")
    @JsonAlias("expiration_date")
    private String expirationDate;

    @JsonProperty("items")
    @JsonAlias("items")
    private List<ItemPedidoRequest> items;

    @JsonProperty("cash_out")
    @JsonAlias("cash_out")
    private CashOutRequest cashOut;

    @JsonProperty("sponsor")
    private SponsorRequest sponsor;
}
