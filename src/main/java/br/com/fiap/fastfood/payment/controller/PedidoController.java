package br.com.fiap.fastfood.payment.controller;

import br.com.fiap.fastfood.payment.response.PedidoResponse;
import br.com.fiap.fastfood.payment.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    PedidoService service;

    @PostMapping("criar")
    private PedidoResponse criarPedido(PedidoRequest request) {
        return service.criarPedido(request);
    }
}
