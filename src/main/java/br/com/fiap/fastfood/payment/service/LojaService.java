package br.com.fiap.fastfood.payment.service;

import br.com.fiap.fastfood.payment.proxy.LojaProxy;
import br.com.fiap.fastfood.payment.request.LojaRequest;
import br.com.fiap.fastfood.payment.response.LojaResponse;
import br.com.fiap.fastfood.payment.response.LojaResponsePaginada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LojaService {

    @Autowired
    LojaProxy proxy;

    public LojaResponse criarLoja(String userId, LojaRequest lojaRequest) {
        return proxy.criarLoja(userId, lojaRequest);
    }

    public LojaResponsePaginada buscarLojas(String userId) {
        return proxy.buscarLojas(userId);
    }
}
