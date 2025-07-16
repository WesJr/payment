package br.com.fiap.fastfood.payment.controller;

import br.com.fiap.fastfood.payment.request.ItemPedidoRequest;
import br.com.fiap.fastfood.payment.request.PedidoRequest;
import br.com.fiap.fastfood.payment.response.PedidoQrCodeResponse;
import br.com.fiap.fastfood.payment.response.PedidoResponse;
import br.com.fiap.fastfood.payment.service.PedidoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PedidoController.class)
class PedidoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PedidoService pedidoService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCriarPedido() throws Exception {
        PedidoQrCodeResponse mockResponse = new PedidoQrCodeResponse("qr123", "order123");
        Mockito.when(pedidoService.criarPedido(any(PedidoRequest.class), eq("u1"), eq("s1"), eq("p1")))
                .thenReturn(mockResponse);

        PedidoRequest request = new PedidoRequest();

        mockMvc.perform(put("/pedido/criar/user/u1/loja/s1/caixa/p1/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.qr_data").value("qr123"))
                .andExpect(jsonPath("$.in_store_order_id").value("order123"));

        Mockito.verify(pedidoService).criarPedido(any(PedidoRequest.class), eq("u1"), eq("s1"), eq("p1"));
    }

    @Test
    void testObterPedidos() throws Exception {
        ItemPedidoRequest item = new ItemPedidoRequest("sku123", "Eletrônicos", "Fone", "Fone Bluetooth",
                new BigDecimal("100.00"), 1, "unidade", new BigDecimal("100.00"));

        PedidoResponse mockResponse = new PedidoResponse(
                "ext123", "Pedido Teste", "Pedido de teste",
                "http://notificacao.com", new BigDecimal("100.00"), "2025-12-31",
                Collections.singletonList(item), null, null
        );

        Mockito.when(pedidoService.obterPedidos(("u1"), ("p1"))).thenReturn(mockResponse);

        mockMvc.perform(get("/pedido/obter/user/u1/caixa/p1/orders"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.external_reference").value("ext123"))
                .andExpect(jsonPath("$.items[0].sku_number").value("sku123"));

        Mockito.verify(pedidoService).obterPedidos("u1", "p1");
    }

}
