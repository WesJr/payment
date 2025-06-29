package br.com.fiap.fastfood.payment.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Discounts {

    @JsonProperty("payment_methods")
    @JsonAlias("payment_methods")
    private List<PaymensMethod> paymensMethods;
}
