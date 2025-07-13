package br.com.fiap.fastfood.payment.service;

import br.com.fiap.fastfood.payment.model.ItemPedido;
import br.com.fiap.fastfood.payment.model.Pedido;
import br.com.fiap.fastfood.payment.proxy.PedidoProxy;
import br.com.fiap.fastfood.payment.repository.ItemRepository;
import br.com.fiap.fastfood.payment.repository.PedidoRepository;
import br.com.fiap.fastfood.payment.request.ItemPedidoRequest;
import br.com.fiap.fastfood.payment.request.PedidoRequest;
import br.com.fiap.fastfood.payment.response.PedidoQrCodeResponse;
import br.com.fiap.fastfood.payment.response.PedidoResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoProxy proxy;
    private final PedidoRepository repository;
    private final ItemRepository itemRepository;

    public PedidoService(PedidoProxy proxy, PedidoRepository repository, ItemRepository itemRepository) {
        this.proxy = proxy;
        this.repository = repository;
        this.itemRepository = itemRepository;
    }

    public PedidoQrCodeResponse criarPedido(PedidoRequest request, String userId, String lojaId, String caixaId) {

        Pedido pedido = new Pedido();
        pedido.setExternalReference(request.getExternalReference());
        pedido.setTitle(request.getTitle());
        pedido.setDescription(request.getDescription());
        pedido.setNotificationUrl(request.getNotificationUrl());
        pedido.setTotalAmount(request.getTotalAmount());

        List<ItemPedido> items = request.getItems().stream()
                .map(itemPedidoRequest -> mapToItemPedido(itemPedidoRequest, pedido)).toList();

       repository.save(pedido);
       itemRepository.saveAll(items);

        proxy.criarPedido(request, userId, lojaId, caixaId);
        return proxy.criarPedidoQrCode(request,userId, caixaId);
    }

    private ItemPedido mapToItemPedido(ItemPedidoRequest itemPedidoRequest, Pedido pedido) {
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setSkuNumber(itemPedidoRequest.getSkuNumber());
        itemPedido.setCategory(itemPedidoRequest.getCategory());
        itemPedido.setTitle(itemPedidoRequest.getTitle());
        itemPedido.setDescription(itemPedidoRequest.getDescription());
        itemPedido.setUnitPrice(itemPedidoRequest.getUnitPrice());
        itemPedido.setQuantity(itemPedidoRequest.getQuantity());
        itemPedido.setTotalAmount(itemPedidoRequest.getTotalAmount());
        itemPedido.setPedido(pedido);

        return itemPedido;
    }

    public PedidoResponse obterPedidos(String userId, String caixaId) {
        return proxy.obterPedidos(userId, caixaId);
    }
}
