package br.com.fiap.fastfood.payment.repository;

import br.com.fiap.fastfood.payment.model.Caixa;
import br.com.fiap.fastfood.payment.model.Endereco;
import br.com.fiap.fastfood.payment.model.Loja;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class CaixaRepositoryTest {

    @Autowired
    private CaixaRepository caixaRepository;

    @Test
    void testSaveAndFindCaixa() {
        Caixa caixa = getCaixa();

        Caixa saved = caixaRepository.save(caixa);

        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getLoja().getId()).isNotNull();

        Caixa found = caixaRepository.findById(saved.getId()).orElse(null);

        assertThat(found).isNotNull();
        Assertions.assertNotNull(found);
        assertThat(found.getName()).isEqualTo("Caixa Persistência");
        assertThat(found.getLoja().getName()).isEqualTo("Minha Loja");
    }

    private static Caixa getCaixa() {
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
        return new Caixa(null, "Caixa Persistência", false, loja, "EXT-PERSIST", 5);
    }
}
