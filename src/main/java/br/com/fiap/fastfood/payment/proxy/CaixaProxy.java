package br.com.fiap.fastfood.payment.proxy;

import br.com.fiap.fastfood.payment.configuration.MercadoPagoAuthConfiguration;
import br.com.fiap.fastfood.payment.resources.CaixaRequest;
import br.com.fiap.fastfood.payment.response.CaixaResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "CaixaProxy", url = "https://api.mercadopago.com", configuration = MercadoPagoAuthConfiguration.class)
public interface CaixaProxy {

    @PostMapping("/pos")
    CaixaResponse criarCaixa(@RequestBody CaixaRequest request);
}
