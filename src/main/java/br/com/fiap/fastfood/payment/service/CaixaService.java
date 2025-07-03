package br.com.fiap.fastfood.payment.service;

import br.com.fiap.fastfood.payment.model.Caixa;
import br.com.fiap.fastfood.payment.model.Loja;
import br.com.fiap.fastfood.payment.proxy.CaixaProxy;
import br.com.fiap.fastfood.payment.repository.CaixaRepository;
import br.com.fiap.fastfood.payment.repository.LojaRepository;
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

    public CaixaResponse createCaixa(CaixaRequest request) {
        Caixa caixa = new Caixa();

        caixa.setName(request.getName());
        caixa.setFixedAmout(request.isFixedAmout());
        caixa.setExternalId(request.getExternalId());
        caixa.setCategory(request.getCategory());

        repository.save(caixa);
        return proxy.criarCaixa(request);
    }

    public CaixaResponse getCaixaById(String id) {
        return proxy.getCaixaById(id);
    }
}
