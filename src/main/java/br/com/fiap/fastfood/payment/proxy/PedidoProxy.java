package br.com.fiap.fastfood.payment.proxy;

import br.com.fiap.fastfood.payment.configuration.MercadoPagoAuthConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PedidoProxy", url = "https://api.mercadopago.com", configuration = MercadoPagoAuthConfiguration.class)
public interface PedidoProxy {

    @PostMapping("v1/orders")
    PedidoResponse criarPedido(@RequestBody PedidoRequest pedidoRequest);
}
