package br.com.fiap.fastfood.payment.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymensMethod {

    @JsonProperty("new_total_amount")
    @JsonAlias("new_total_amount")
    private String newTotalAmount;

    @JsonProperty("type")
    @JsonAlias("type")
    private String type;
}
