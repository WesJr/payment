package br.com.fiap.fastfood.payment.service;

import br.com.fiap.fastfood.payment.model.ItemPedido;
import br.com.fiap.fastfood.payment.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository repository;

    public List<ItemPedido> saveAll(List<ItemPedido> itens) {

        return repository.saveAll(itens);
    }
}
