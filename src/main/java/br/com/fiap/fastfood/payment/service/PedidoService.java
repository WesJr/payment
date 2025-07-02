package br.com.fiap.fastfood.payment.service;

import br.com.fiap.fastfood.payment.proxy.PedidoProxy;
import br.com.fiap.fastfood.payment.request.PedidoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    PedidoProxy proxy;

    public void criarPedido(PedidoRequest request, String userId, String lojaId, String caixaId) {
        proxy.criarPedido(request, userId, lojaId, caixaId);
    }
}
