package br.com.fiap.fastfood.payment.repository;

import br.com.fiap.fastfood.payment.model.Caixa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaixaRepository extends JpaRepository<Caixa, Long> {
}
