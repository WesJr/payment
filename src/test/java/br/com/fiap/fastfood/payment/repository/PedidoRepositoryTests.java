package br.com.fiap.fastfood.payment.repository;

import br.com.fiap.fastfood.payment.model.Pedido;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class PedidoRepositoryTests {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Test
    void testSaveAndFind() {
        Pedido pedido = new Pedido();
        pedido.setExternalReference("EXT-789");
        pedido.setTitle("Pedido Persistência");
        pedido.setDescription("Teste de salvamento");
        pedido.setNotificationUrl("http://notify.test");
        pedido.setTotalAmount(300.00);

        Pedido saved = pedidoRepository.save(pedido);

        assertThat(saved.getId()).isNotNull();

        Pedido found = pedidoRepository.findById(saved.getId()).orElse(null);
        assertThat(found).isNotNull();
        assertThat(found.getExternalReference()).isEqualTo("EXT-789");
        assertThat(found.getTitle()).isEqualTo("Pedido Persistência");
    }
}
