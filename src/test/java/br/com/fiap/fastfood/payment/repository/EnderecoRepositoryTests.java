package br.com.fiap.fastfood.payment.repository;

import br.com.fiap.fastfood.payment.model.Endereco;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class EnderecoRepositoryTests {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Test
    void testSaveAndFindEndereco() {
        Endereco endereco = new Endereco();
        endereco.setCityName("São Paulo");
        endereco.setStreetNumber("10");
        endereco.setStreetName("Rua Teste");
        endereco.setReference("Referencia de teste");

        Endereco saved = enderecoRepository.save(endereco);

        assertThat(saved.getId()).isNotNull();

        Endereco found = enderecoRepository.findById(saved.getId()).orElse(null);

        assertThat(found).isNotNull();
        Assertions.assertNotNull(found);
        assertThat(found.getStreetName()).isEqualTo("Rua Teste");
        assertThat(found.getCityName()).isEqualTo("São Paulo");
    }
}
