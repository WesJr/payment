package br.com.fiap.fastfood.payment.proxy;

import br.com.fiap.fastfood.payment.configuration.MercadoPagoAuthConfiguration;
import br.com.fiap.fastfood.payment.request.LojaRequest;
import br.com.fiap.fastfood.payment.response.LojaResponse;
import br.com.fiap.fastfood.payment.response.LojaResponsePaginada;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "LojaProxy", url = "https://api.mercadopago.com", configuration = MercadoPagoAuthConfiguration.class)
public interface LojaProxy {

    @PostMapping("/users/{user_id}/stores")
    LojaResponse criarLoja(@PathVariable("user_id") String userId, @RequestBody LojaRequest lojaRequest);

    @GetMapping("users/{user_id}/stores/search")
    LojaResponsePaginada buscarLojas(@PathVariable("user_id") String userId, @RequestParam(value = "external_id", required = false) String externalId);
}
