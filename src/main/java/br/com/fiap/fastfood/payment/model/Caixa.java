package br.com.fiap.fastfood.payment.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "caixa")
public class Caixa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "valor_fixo")
    private boolean fixedAmout;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "loja_id", referencedColumnName = "id")
    private Loja loja;

    @Column(name = "id_externo", unique = true)
    private String externalId;

    @Column(name = "categoria")
    private Integer category;

}
