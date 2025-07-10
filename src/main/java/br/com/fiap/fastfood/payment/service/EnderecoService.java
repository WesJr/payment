package br.com.fiap.fastfood.payment.service;

import br.com.fiap.fastfood.payment.model.Endereco;
import br.com.fiap.fastfood.payment.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository repository;

    public Endereco save(Endereco endereco) {
        return repository.save(endereco);
    }

}
