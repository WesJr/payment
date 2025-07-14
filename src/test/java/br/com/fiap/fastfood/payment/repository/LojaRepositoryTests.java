package br.com.fiap.fastfood.payment.repository;

import br.com.fiap.fastfood.payment.model.Endereco;
import br.com.fiap.fastfood.payment.model.Loja;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class LojaRepositoryTests {

    @Autowired
    private LojaRepository lojaRepository;

    @Test
    void testSaveAndFindLoja() {
        Endereco endereco = new Endereco();

        endereco.setCityName("São Paulo");
        endereco.setStreetNumber("10");
        endereco.setStreetName("Rua Teste");
        endereco.setReference("Referencia de teste");

        Loja loja = new Loja();
        loja.setName("Loja Persistencia");
        loja.setExternalId("EXT-PERSIST");
        loja.setDateCreated("2025-07-13");
        loja.setEndereco(endereco);

        Loja saved = lojaRepository.save(loja);

        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getEndereco().getId()).isNotNull();

        Loja found = lojaRepository.findById(saved.getId()).orElse(null);

        assertThat(found).isNotNull();
        assertThat(Objects.requireNonNull(found).getName()).isEqualTo("Loja Persistencia");
        assertThat(found.getEndereco().getStreetName()).isEqualTo("Rua Teste");
    }

}
