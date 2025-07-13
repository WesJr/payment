package br.com.fiap.fastfood.payment.service;

import br.com.fiap.fastfood.payment.model.ItemPedido;
import br.com.fiap.fastfood.payment.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public List<ItemPedido> saveAll(List<ItemPedido> itens) {

        return repository.saveAll(itens);
    }
}
