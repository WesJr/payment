package br.com.fiap.fastfood.payment.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QrPaymentResponse {

    @JsonProperty("external_pos_id")
    @JsonAlias("external_pos_id")
    private String externalPosId;

    @JsonProperty("mode")
    @JsonAlias("mode")
    private String mode;


}
