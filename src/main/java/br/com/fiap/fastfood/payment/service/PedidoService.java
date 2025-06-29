package br.com.fiap.fastfood.payment.service;

import br.com.fiap.fastfood.payment.proxy.PedidoProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    PedidoProxy proxy;

    public PedidoResponse criarPedido(PedidoRequest request) {
        return proxy.criarPedido(request);
    }
}
