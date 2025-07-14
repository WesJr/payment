package br.com.fiap.fastfood.payment.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "item_pedido")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_produto")
    private String skuNumber;

    @Column(name = "categoria")
    private String category;

    @Column(name = "titulo")
    private String title;

    @Column(name = "descricao")
    private String description;

    @Column(name = "preco_unitario")
    private BigDecimal unitPrice;

    @Column(name = "quantidade")
    private int quantity;

    @Column(name = "valor_total")
    private BigDecimal totalAmount;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
}
