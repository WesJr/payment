package br.com.fiap.fastfood.payment.repository;

import br.com.fiap.fastfood.payment.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemPedido, Long> {
}
