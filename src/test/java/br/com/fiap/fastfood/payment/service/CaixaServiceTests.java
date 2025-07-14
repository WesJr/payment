package br.com.fiap.fastfood.payment.service;

import br.com.fiap.fastfood.payment.model.Caixa;
import br.com.fiap.fastfood.payment.model.Loja;
import br.com.fiap.fastfood.payment.proxy.CaixaProxy;
import br.com.fiap.fastfood.payment.repository.CaixaRepository;
import br.com.fiap.fastfood.payment.request.CaixaRequest;
import br.com.fiap.fastfood.payment.response.CaixaResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class CaixaServiceTests {

    @Autowired
    private CaixaService caixaService;

    @MockitoBean
    private CaixaProxy caixaProxy;

    @MockitoBean
    private CaixaRepository caixaRepository;

    @MockitoBean
    private LojaService lojaService;

    @Test
    void testCreateCaixa() {
        // Arrange
        CaixaRequest request = new CaixaRequest();
        request.setName("Caixa Teste");
        request.setFixedAmout(true);
        request.setExternalId("EXT-CAIXA-001");
        request.setCategory(1);
        request.setExternalStoreId("EXT-LOJA-001");

        Loja lojaMock = new Loja();
        lojaMock.setExternalId("EXT-LOJA-001");

        Mockito.when(lojaService.getLojaByExternalId("EXT-LOJA-001")).thenReturn(lojaMock);

        CaixaResponse proxyResponse = new CaixaResponse();
        proxyResponse.setName("Caixa Teste");

        Mockito.when(caixaProxy.criarCaixa(request)).thenReturn(proxyResponse);

        // Act
        CaixaResponse result = caixaService.createCaixa(request);

        // Assert
        assertThat(result.getName()).isEqualTo("Caixa Teste");

        Mockito.verify(lojaService).getLojaByExternalId("EXT-LOJA-001");
        Mockito.verify(caixaRepository).save(any(Caixa.class));
        Mockito.verify(caixaProxy).criarCaixa(request);
    }

    @Test
    void testGetCaixaById() {
        CaixaResponse proxyResponse = new CaixaResponse();
        proxyResponse.setName("Caixa Encontrado");

        Mockito.when(caixaProxy.getCaixaById("123")).thenReturn(proxyResponse);

        CaixaResponse result = caixaService.getCaixaById("123");

        assertThat(result.getName()).isEqualTo("Caixa Encontrado");
        Mockito.verify(caixaProxy).getCaixaById("123");
    }
}
