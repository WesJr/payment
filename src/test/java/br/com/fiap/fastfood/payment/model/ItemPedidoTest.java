package br.com.fiap.fastfood.payment.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemPedidoTest {

    @Test
    void testGettersAndSetters() {
        Pedido pedido = new Pedido();
        pedido.setId(1L);
        pedido.setExternalReference("EXT-123");
        pedido.setTitle("Pedido Teste");
        pedido.setDescription("Descrição do Pedido");
        pedido.setNotificationUrl("http://callback.com");
        pedido.setTotalAmount(150.50);

        ItemPedido item = new ItemPedido();
        item.setSkuNumber("SKU-001");
        item.setCategory("Eletrônicos");
        item.setTitle("Fone de Ouvido");
        item.setDescription("Fone Bluetooth");
        item.setUnitPrice(new BigDecimal("150.00"));
        item.setQuantity(2);
        item.setTotalAmount(new BigDecimal("300.00"));
        item.setPedido(pedido);

        assertEquals("SKU-001", item.getSkuNumber());
        assertEquals("Eletrônicos", item.getCategory());
        assertEquals("Fone de Ouvido", item.getTitle());
        assertEquals("Fone Bluetooth", item.getDescription());
        assertEquals(new BigDecimal("150.00"), item.getUnitPrice());
        assertEquals(2, item.getQuantity());
        assertEquals(new BigDecimal("300.00"), item.getTotalAmount());
        assertEquals(pedido, item.getPedido());
    }
}
