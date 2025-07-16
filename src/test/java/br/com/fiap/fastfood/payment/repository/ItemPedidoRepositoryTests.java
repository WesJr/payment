package br.com.fiap.fastfood.payment.repository;

import br.com.fiap.fastfood.payment.model.ItemPedido;
import br.com.fiap.fastfood.payment.model.Pedido;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class ItemPedidoRepositoryTests {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ItemRepository itemPedidoRepository;

    @Test
    void testSaveAndFindItemPedido() {
        Pedido pedido = new Pedido();
        pedido.setExternalReference("EXT-123");
        pedido.setTitle("Pedido Teste");
        pedido.setDescription("Descrição do Pedido");
        pedido.setNotificationUrl("http://callback.com");
        pedido.setTotalAmount(150.50);
        Pedido savedPedido = pedidoRepository.save(pedido);

        // Cria ItemPedido vinculado
        ItemPedido item = new ItemPedido();
        item.setSkuNumber("SKU-999");
        item.setCategory("Games");
        item.setTitle("Controle PS5");
        item.setDescription("Controle sem fio");
        item.setUnitPrice(new BigDecimal("500.00"));
        item.setQuantity(1);
        item.setTotalAmount(new BigDecimal("500.00"));
        item.setPedido(savedPedido);

        ItemPedido savedItem = itemPedidoRepository.save(item);

        assertThat(savedItem.getId()).isNotNull();
        assertThat(savedItem.getPedido()).isNotNull();
        assertThat(savedItem.getPedido().getId()).isEqualTo(savedPedido.getId());

        ItemPedido found = itemPedidoRepository.findById(savedItem.getId()).orElse(null);

        assertThat(found).isNotNull();
        Assertions.assertNotNull(found);
        assertThat(found.getSkuNumber()).isEqualTo("SKU-999");
        assertThat(found.getPedido().getExternalReference()).isEqualTo("EXT-123");
    }
}
