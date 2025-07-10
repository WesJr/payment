package br.com.fiap.fastfood.payment.service;

import br.com.fiap.fastfood.payment.model.Caixa;
import br.com.fiap.fastfood.payment.proxy.CaixaProxy;
import br.com.fiap.fastfood.payment.repository.CaixaRepository;
import br.com.fiap.fastfood.payment.request.CaixaRequest;
import br.com.fiap.fastfood.payment.response.CaixaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaixaService {

    @Autowired
    CaixaProxy proxy;

    @Autowired
    CaixaRepository repository;

    @Autowired
    LojaService lojaService;

    public CaixaResponse createCaixa(CaixaRequest request) {
        Caixa caixa = new Caixa();

        caixa.setName(request.getName());
        caixa.setFixedAmout(request.isFixedAmout());
        caixa.setExternalId(request.getExternalId());
        caixa.setCategory(request.getCategory());
        caixa.setLoja(lojaService.getLojaByExternalId(request.getExternalStoreId()));

        repository.save(caixa);
        return proxy.criarCaixa(request);
    }

    public CaixaResponse getCaixaById(String id) {
        return proxy.getCaixaById(id);
    }
}
