package br.com.fiap.fastfood.payment.service;

import br.com.fiap.fastfood.payment.model.Endereco;
import br.com.fiap.fastfood.payment.repository.EnderecoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class EnderecoServiceTests {

    @Test
    void testSaveEndereco() {
        EnderecoRepository repository = Mockito.mock(EnderecoRepository.class);

        EnderecoService enderecoService = new EnderecoService(repository);

        Endereco endereco = new Endereco();
        endereco.setStreetName("Rua Teste");
        endereco.setCityName("Cidade X");

        Endereco enderecoSaved = new Endereco();
        enderecoSaved.setId(1L);
        enderecoSaved.setStreetName("Rua Teste");
        enderecoSaved.setCityName("Cidade X");

        Mockito.when(repository.save(any(Endereco.class))).thenReturn(enderecoSaved);

        Endereco result = enderecoService.save(endereco);

        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getStreetName()).isEqualTo("Rua Teste");
        assertThat(result.getCityName()).isEqualTo("Cidade X");

        Mockito.verify(repository).save(endereco);
    }
}
