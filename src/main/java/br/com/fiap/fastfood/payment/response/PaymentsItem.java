package br.com.fiap.fastfood.payment.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentsItem {

    @JsonProperty("id")
    @JsonAlias("id")
    private String id;

    @JsonProperty("amount")
    @JsonAlias("amount")
    private String amount;

    @JsonProperty("status")
    @JsonAlias("status")
    private String status;

    @JsonProperty("status_detail")
    @JsonAlias("status_detail")
    private String statusDetail;
}
