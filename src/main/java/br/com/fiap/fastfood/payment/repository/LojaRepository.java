package br.com.fiap.fastfood.payment.repository;

import br.com.fiap.fastfood.payment.model.Loja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Long> {

}
