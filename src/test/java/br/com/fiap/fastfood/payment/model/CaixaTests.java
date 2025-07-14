package br.com.fiap.fastfood.payment.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CaixaTests {

    @Test
    void testGettersAndSetters() {

        Endereco endereco = new Endereco();
        endereco.setCityName("São Paulo");
        endereco.setStreetNumber("10");
        endereco.setStreetName("Rua Teste");
        endereco.setReference("Referencia de teste");

        Loja loja = new Loja();
        loja.setName("Minha Loja");
        loja.setDateCreated("2025-07-13");
        loja.setExternalId("EXT-LOJA-001");
        loja.setEndereco(endereco);

        Caixa caixa = new Caixa();
        caixa.setName("Caixa Principal");
        caixa.setFixedAmout(true);
        caixa.setLoja(loja);
        caixa.setExternalId("EXT-CAIXA-001");
        caixa.setCategory(1);

        assertEquals("Caixa Principal", caixa.getName());
        assertTrue(caixa.isFixedAmout());
        assertEquals(loja, caixa.getLoja());
        assertEquals("EXT-CAIXA-001", caixa.getExternalId());
        assertEquals(1, caixa.getCategory());
    }

    @Test
    void testAllArgsConstructorAndToString() {
        Endereco endereco = new Endereco();
        endereco.setCityName("São Paulo");
        endereco.setStreetNumber("10");
        endereco.setStreetName("Rua Teste");
        endereco.setReference("Referencia de teste");

        Loja loja = new Loja();
        loja.setName("Minha Loja");
        loja.setDateCreated("2025-07-13");
        loja.setExternalId("EXT-LOJA-001");
        loja.setEndereco(endereco);

        Caixa caixa = new Caixa(null, "Caixa Completo", true, loja, "EXT-CAIXA-002", 2);

        assertEquals("Caixa Completo", caixa.getName());
        assertTrue(caixa.toString().contains("Caixa Completo"));
        assertTrue(caixa.toString().contains("Minha Loja"));
    }
}
