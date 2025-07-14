package br.com.fiap.fastfood.payment.service;

import br.com.fiap.fastfood.payment.model.Pedido;
import br.com.fiap.fastfood.payment.proxy.PedidoProxy;
import br.com.fiap.fastfood.payment.repository.ItemRepository;
import br.com.fiap.fastfood.payment.repository.PedidoRepository;
import br.com.fiap.fastfood.payment.request.ItemPedidoRequest;
import br.com.fiap.fastfood.payment.request.PedidoRequest;
import br.com.fiap.fastfood.payment.response.PedidoQrCodeResponse;
import br.com.fiap.fastfood.payment.response.PedidoResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class PedidoServiceTest {

    @Test
    void testCriarPedido() {
        PedidoProxy proxy = Mockito.mock(PedidoProxy.class);
        PedidoRepository pedidoRepository = Mockito.mock(PedidoRepository.class);
        ItemRepository itemRepository = Mockito.mock(ItemRepository.class);

        PedidoService pedidoService = new PedidoService(proxy, pedidoRepository, itemRepository);

        PedidoRequest request = getPedidoRequest();

        PedidoQrCodeResponse qrCodeResponse = new PedidoQrCodeResponse();
        qrCodeResponse.setQrData("QR-DATA-123");
        qrCodeResponse.setInStoreOrderId("ORDER-456");

        Mockito.when(proxy.criarPedidoQrCode(request, "USER1", "CAIXA1")).thenReturn(qrCodeResponse);

        PedidoQrCodeResponse result = pedidoService.criarPedido(request, "USER1", "LOJA1", "CAIXA1");

        assertThat(result.getQrData()).isEqualTo("QR-DATA-123");
        assertThat(result.getInStoreOrderId()).isEqualTo("ORDER-456");

        Mockito.verify(pedidoRepository).save(any(Pedido.class));
        Mockito.verify(itemRepository).saveAll(any());
        Mockito.verify(proxy).criarPedido(request, "USER1", "LOJA1", "CAIXA1");
        Mockito.verify(proxy).criarPedidoQrCode(request, "USER1", "CAIXA1");
    }

    private static PedidoRequest getPedidoRequest() {
        ItemPedidoRequest item1 = new ItemPedidoRequest();
        item1.setSkuNumber("SKU-1");
        item1.setCategory("Eletrônicos");
        item1.setTitle("Headphone");
        item1.setDescription("Fone sem fio");
        item1.setUnitPrice(new BigDecimal("200.00"));
        item1.setQuantity(1);
        item1.setTotalAmount(new BigDecimal("200.00"));

        PedidoRequest request = new PedidoRequest();
        request.setExternalReference("EXT-123");
        request.setTitle("Pedido Teste");
        request.setDescription("Descrição teste");
        request.setNotificationUrl("http://callback.com");
        request.setTotalAmount(200.00);
        request.setItems(List.of(item1));
        return request;
    }

    @Test
    void testObterPedidos() {
        PedidoProxy proxy = Mockito.mock(PedidoProxy.class);
        PedidoRepository pedidoRepository = Mockito.mock(PedidoRepository.class);
        ItemRepository itemRepository = Mockito.mock(ItemRepository.class);

        PedidoService pedidoService = new PedidoService(proxy, pedidoRepository, itemRepository);

        PedidoResponse response = new PedidoResponse();
        response.setExternalReference("EXT-ABC");

        Mockito.when(proxy.obterPedidos("USER2", "CAIXA2")).thenReturn(response);

        PedidoResponse result = pedidoService.obterPedidos("USER2", "CAIXA2");

        assertThat(result.getExternalReference()).isEqualTo("EXT-ABC");

        Mockito.verify(proxy).obterPedidos("USER2", "CAIXA2");
    }
}
