package br.com.fiap.fastfood.payment.repository;

import br.com.fiap.fastfood.payment.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
