package br.com.fiap.fastfood.payment.service;

import br.com.fiap.fastfood.payment.model.Endereco;
import br.com.fiap.fastfood.payment.model.Loja;
import br.com.fiap.fastfood.payment.proxy.LojaProxy;
import br.com.fiap.fastfood.payment.repository.LojaRepository;
import br.com.fiap.fastfood.payment.request.LojaRequest;
import br.com.fiap.fastfood.payment.response.LojaResponse;
import br.com.fiap.fastfood.payment.response.LojaResponsePaginada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LojaService {

    @Autowired
    LojaProxy proxy;

    @Autowired
    LojaRepository repository;

    @Autowired
    EnderecoService enderecoService;

    public LojaResponse criarLoja(String userId, LojaRequest lojaRequest) {

        Endereco endereco = new Endereco();
        endereco.setStateName(lojaRequest.getLocation().getStreetName());
        endereco.setStreetNumber(lojaRequest.getLocation().getStreetNumber());
        endereco.setCityName(lojaRequest.getLocation().getCityName());
        endereco.setStateName(lojaRequest.getLocation().getStateName());
        endereco.setReference(lojaRequest.getLocation().getReference());

        Endereco endereco1 = enderecoService.save(endereco);

        Loja loja = new Loja();
        loja.setName(lojaRequest.getName());
        loja.setDateCreated(loja.getDateCreated());
        loja.setExternalId(loja.getExternalId());
        loja.setEndereco(endereco1);

        repository.save(loja);

        return proxy.criarLoja(userId, lojaRequest);
    }

    public LojaResponsePaginada buscarLojas(String userId, String externalId) {
        return proxy.buscarLojas(userId, externalId);
    }

    public LojaResponse obterLoja(String id) {
        return proxy.obterLoja(id);
    }

    public Loja getLojaByExternalId(String externalId) {
        return repository.findByExternalId(externalId);
    }
}
