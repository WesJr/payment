package br.com.fiap.fastfood.payment.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Taxes {

    @JsonProperty("payer_condition")
    @JsonAlias("payer_condition")
    private String payerCondition;
}
