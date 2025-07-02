package br.com.fiap.fastfood.payment.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class cashOutRequest {

    @JsonProperty("amount")
    private BigDecimal amount;
}
