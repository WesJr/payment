package br.com.fiap.fastfood.payment.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LojaTests {

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

        assertEquals("Minha Loja", loja.getName());
        assertEquals("2025-07-13", loja.getDateCreated());
        assertEquals("EXT-LOJA-001", loja.getExternalId());
        assertEquals(endereco, loja.getEndereco());
    }

    @Test
    void testAllArgsConstructorAndToString() {
        Endereco endereco = new Endereco();

        endereco.setCityName("São Paulo");
        endereco.setStreetNumber("10");
        endereco.setStreetName("Rua Teste");
        endereco.setReference("Referencia de teste");
        Loja loja = new Loja(1L, "Loja X", "2025-07-13", "EXT-LOJA-002", endereco);

        assertEquals("Loja X", loja.getName());
        assertTrue(loja.toString().contains("Loja X"));
        assertTrue(loja.toString().contains("Rua Teste"));
    }

    @Test
    void testEqualsAndHashCode() {
        Endereco endereco = new Endereco();
        endereco.setCityName("São Paulo");
        endereco.setStreetNumber("10");
        endereco.setStreetName("Rua Teste");
        endereco.setReference("Referencia de teste");

        Loja l1 = new Loja(1L,"Loja Teste", "2025-07-13", "EXT-LOJA-003", endereco);
        Loja l2 = new Loja(2L,"Loja Teste", "2025-07-13", "EXT-LOJA-003", endereco);

        assertNotEquals(l1, l2);
        assertNotEquals(l1.hashCode(), l2.hashCode());
    }
}
