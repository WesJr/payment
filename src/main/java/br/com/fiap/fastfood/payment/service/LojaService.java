package br.com.fiap.fastfood.payment.service;

import br.com.fiap.fastfood.payment.proxy.LojaProxy;
import br.com.fiap.fastfood.payment.resources.LojaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LojaService {

    @Autowired
    LojaProxy proxy;

    public LojaRequest criarLoja(String userId, LojaRequest lojaRequest) {
        return proxy.criarLoja(userId, lojaRequest);
    }
}
