package br.com.fiap.fastfood.payment.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TypeResponse {

    @JsonAlias("qr_data")
    @JsonProperty("qr_data")
    private String qrData;
}
