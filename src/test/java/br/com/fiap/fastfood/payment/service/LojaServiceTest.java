package br.com.fiap.fastfood.payment.service;

import br.com.fiap.fastfood.payment.model.Endereco;
import br.com.fiap.fastfood.payment.model.Loja;
import br.com.fiap.fastfood.payment.proxy.LojaProxy;
import br.com.fiap.fastfood.payment.repository.LojaRepository;
import br.com.fiap.fastfood.payment.request.LocationRequest;
import br.com.fiap.fastfood.payment.request.LojaRequest;
import br.com.fiap.fastfood.payment.response.LojaResponse;
import br.com.fiap.fastfood.payment.response.LojaResponsePaginada;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class LojaServiceTest {

    @Autowired
    private LojaService lojaService;

    @MockitoBean
    private LojaProxy lojaProxy;

    @MockitoBean
    private LojaRepository lojaRepository;

    @MockitoBean
    private EnderecoService enderecoService;

    @Test
    void testCriarLoja() {
        LojaRequest request = new LojaRequest();
        LocationRequest location = new LocationRequest();
        location.setStreetName("Rua X");
        location.setStreetNumber("123");
        location.setCityName("Cidade Y");
        location.setStateName("SP");
        location.setReference("Próximo ao mercado");
        request.setName("Minha Loja");
        request.setLocation(location);

        Endereco enderecoSaved = new Endereco();
        enderecoSaved.setStreetNumber("123");
        enderecoSaved.setStreetName("Rua Principal");
        enderecoSaved.setCityName("Cidade Exemplo");
        enderecoSaved.setStateName("SP");
        enderecoSaved.setReference("Perto da padaria");
        enderecoSaved.setId(1L);

        Mockito.when(enderecoService.save(any(Endereco.class))).thenReturn(enderecoSaved);

        LojaResponse proxyResponse = new LojaResponse();
        proxyResponse.setName("Minha Loja");
        Mockito.when(lojaProxy.criarLoja(("user123"), (request))).thenReturn(proxyResponse);

        LojaResponse result = lojaService.criarLoja("user123", request);

        assertThat(result.getName()).isEqualTo("Minha Loja");

        Mockito.verify(enderecoService).save(any(Endereco.class));
        Mockito.verify(lojaRepository).save(any(Loja.class));
        Mockito.verify(lojaProxy).criarLoja("user123", request);
    }

    @Test
    void testBuscarLojas() {
        LojaResponsePaginada paginada = new LojaResponsePaginada();
        Mockito.when(lojaProxy.buscarLojas("user123", "EXT-001")).thenReturn(paginada);

        LojaResponsePaginada result = lojaService.buscarLojas("user123", "EXT-001");

        assertThat(result).isNotNull();
        Mockito.verify(lojaProxy).buscarLojas("user123", "EXT-001");
    }

    @Test
    void testObterLoja() {
        LojaResponse lojaResponse = new LojaResponse();
        lojaResponse.setName("Loja XPTO");

        Mockito.when(lojaProxy.obterLoja("LOJA-ID")).thenReturn(lojaResponse);

        LojaResponse result = lojaService.obterLoja("LOJA-ID");

        assertThat(result.getName()).isEqualTo("Loja XPTO");
        Mockito.verify(lojaProxy).obterLoja("LOJA-ID");
    }

    @Test
    void testGetLojaByExternalId() {
        Loja loja = new Loja();
        loja.setExternalId("EXT-ABC");

        Mockito.when(lojaRepository.findByExternalId("EXT-ABC")).thenReturn(loja);

        Loja result = lojaService.getLojaByExternalId("EXT-ABC");

        assertThat(result.getExternalId()).isEqualTo("EXT-ABC");
        Mockito.verify(lojaRepository).findByExternalId("EXT-ABC");
    }
}
