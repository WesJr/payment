package br.com.fiap.fastfood.payment.controller;

import br.com.fiap.fastfood.payment.request.PedidoRequest;
import br.com.fiap.fastfood.payment.response.PedidoQrCodeResponse;
import br.com.fiap.fastfood.payment.response.PedidoResponse;
import br.com.fiap.fastfood.payment.service.PedidoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PutMapping("criar/user/{user_id}/loja/{external_store_id}/caixa/{external_pos_id}/orders")
    public PedidoQrCodeResponse criarPedido(@RequestBody PedidoRequest request,
                                            @PathVariable("user_id") String userId,
                                            @PathVariable("external_store_id") String lojaId,
                                            @PathVariable("external_pos_id") String caixaId) {
        return service.criarPedido(request, userId, lojaId, caixaId);
    }

    @GetMapping("obter/user/{user_id}/caixa/{external_pos_id}/orders")
    public PedidoResponse obterPedidos(@PathVariable("user_id") String userId,
                                             @PathVariable("external_pos_id") String caixaId){
        return service.obterPedidos(userId, caixaId);
    }
}
