package br.com.fiap.fastfood.payment.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Config {

    @JsonProperty("qr")
    @JsonAlias("qr")
    private QrPaymentResponse qr;
}
