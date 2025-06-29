package br.com.fiap.fastfood.payment.service;

import br.com.fiap.fastfood.payment.proxy.LojaProxy;
import br.com.fiap.fastfood.payment.resources.LojaRequest;
import br.com.fiap.fastfood.payment.response.LojaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LojaService {

    @Autowired
    LojaProxy proxy;

    public LojaResponse criarLoja(String userId, LojaRequest lojaRequest) {
        return proxy.criarLoja(userId, lojaRequest);
    }

    public Object buscarLojas(String userId) {
        return proxy.buscarLojas(userId);
    }
}
