package br.com.fiap.fastfood.payment.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoQrCodeResponse {

    @JsonProperty("qr_data")
    @JsonAlias("qr_data")
    private String qrData;

    @JsonProperty("in_store_order_id")
    @JsonAlias("in_store_order_id")
    private String inStoreOrderId;
}
