package br.com.fiap.fastfood.payment.service;

import br.com.fiap.fastfood.payment.proxy.PedidoProxy;
import br.com.fiap.fastfood.payment.request.PedidoRequest;
import br.com.fiap.fastfood.payment.response.PedidoQrCodeResponse;
import br.com.fiap.fastfood.payment.response.PedidoResponse;
import br.com.fiap.fastfood.payment.response.PedidoResponseList;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    PedidoProxy proxy;

    public PedidoQrCodeResponse criarPedido(PedidoRequest request, String userId, String lojaId, String caixaId) {
        proxy.criarPedido(request, userId, lojaId, caixaId);
        return proxy.criarPedidoQrCode(request,userId, caixaId);
    }

    public PedidoResponse obterPedidos(String userId, String caixaId) {
        return proxy.obterPedidos(userId, caixaId);
    }
}
