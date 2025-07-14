package br.com.fiap.fastfood.payment.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PedidoTests {

    @Test
    void testGettersAndSetters() {
        Pedido pedido = new Pedido();
        pedido.setId(1L);
        pedido.setExternalReference("EXT-123");
        pedido.setTitle("Pedido Teste");
        pedido.setDescription("Descrição do Pedido");
        pedido.setNotificationUrl("http://callback.com");
        pedido.setTotalAmount(150.50);

        assertEquals(1, pedido.getId());
        assertEquals("EXT-123", pedido.getExternalReference());
        assertEquals("Pedido Teste", pedido.getTitle());
        assertEquals("Descrição do Pedido", pedido.getDescription());
        assertEquals("http://callback.com", pedido.getNotificationUrl());
        assertEquals(150.50, pedido.getTotalAmount());
    }

    @Test
    void testConstructorAndToString() {
        Pedido pedido = new Pedido(1L,"EXT-456", "Outro Pedido", "Outra descrição", "http://notify.com", 200.0);

        assertEquals("EXT-456", pedido.getExternalReference());
        assertTrue(pedido.toString().contains("Outro Pedido"));
    }

    @Test
    void testEqualsAndHashCode() {
        Pedido p1 = new Pedido(1L,"EXT-1", "Pedido 1", "Desc", "http://url", 50.0);
        Pedido p2 = new Pedido(2L,"EXT-1", "Pedido 1", "Desc", "http://url", 50.0);

        assertNotEquals(p1, p2);
        assertNotEquals(p1.hashCode(), p2.hashCode());
    }

}
