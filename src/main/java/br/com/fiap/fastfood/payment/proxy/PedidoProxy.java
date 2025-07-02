package br.com.fiap.fastfood.payment.proxy;

import br.com.fiap.fastfood.payment.configuration.MercadoPagoAuthConfiguration;
import br.com.fiap.fastfood.payment.request.PedidoRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "PedidoProxy", url = "https://api.mercadopago.com", configuration = MercadoPagoAuthConfiguration.class)
public interface PedidoProxy {

    @PutMapping("instore/qr/seller/collectors/{user_id}/stores/{external_store_id}/pos/{external_pos_id}/orders")
    void criarPedido(@RequestBody PedidoRequest pedidoRequest,
                     @PathVariable("user_id") String userId,
                     @PathVariable("external_store_id")String lojaId,
                     @PathVariable("external_pos_id") String caixaId);
}
