package br.com.fiap.fastfood.payment.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class EnderecoTests {

    @Test
    void testGettersAndSetters() {
        Endereco endereco = new Endereco();
        endereco.setStreetNumber("123");
        endereco.setStreetName("Rua Principal");
        endereco.setCityName("Cidade Exemplo");
        endereco.setStateName("SP");
        endereco.setReference("Perto da padaria");

        assertEquals("123", endereco.getStreetNumber());
        assertEquals("Rua Principal", endereco.getStreetName());
        assertEquals("Cidade Exemplo", endereco.getCityName());
        assertEquals("SP", endereco.getStateName());
        assertEquals("Perto da padaria", endereco.getReference());
    }

    @Test
    void testAllArgsConstructorAndToString() {
        Endereco endereco = new Endereco(1L,"456", "Av. Central", "Cidade Teste", "RJ", "Em frente ao banco");

        assertEquals("456", endereco.getStreetNumber());
        assertTrue(endereco.toString().contains("456"));
        assertTrue(endereco.toString().contains("Av. Central"));
        assertTrue(endereco.toString().contains("Cidade Teste"));
    }
}
