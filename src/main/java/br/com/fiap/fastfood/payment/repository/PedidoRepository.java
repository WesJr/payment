package br.com.fiap.fastfood.payment.repository;

import br.com.fiap.fastfood.payment.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
