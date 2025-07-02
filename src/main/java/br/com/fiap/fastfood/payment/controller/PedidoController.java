package br.com.fiap.fastfood.payment.controller;

import br.com.fiap.fastfood.payment.request.PedidoRequest;
import br.com.fiap.fastfood.payment.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    PedidoService service;

    @PutMapping("criar/user/{userId}/loja/{external_store_id}/caixa/{external_pos_id}/orders")
    public void criarPedido(@RequestBody PedidoRequest request,
                             @PathVariable("user_id") String userId,
                             @PathVariable("external_store_id") String lojaId,
                             @PathVariable("external_pos_id") String caixaId) {
        service.criarPedido(request, userId, lojaId, caixaId);
    }
}
