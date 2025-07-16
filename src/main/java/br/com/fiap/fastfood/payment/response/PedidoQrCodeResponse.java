package br.com.fiap.fastfood.payment.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoQrCodeResponse {

    @JsonProperty("qr_data")
    @JsonAlias("qr_data")
    private String qrData;

    @JsonProperty("in_store_order_id")
    @JsonAlias("in_store_order_id")
    private String inStoreOrderId;
}
