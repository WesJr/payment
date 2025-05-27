package br.com.fiap.fastfood.payment.service;

import br.com.fiap.fastfood.payment.proxy.CaixaProxy;
import br.com.fiap.fastfood.payment.resources.CaixaRequest;
import br.com.fiap.fastfood.payment.response.CaixaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaixaService {

    @Autowired
    CaixaProxy proxy;

    public CaixaResponse createCaixa(CaixaRequest request) {
        return proxy.criarCaixa(request);
    }

    public CaixaResponse getCaixaById(String id) {
        return proxy.getCaixaById(id);
    }
}
