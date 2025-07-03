package br.com.fiap.fastfood.payment.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "loja")
public class Loja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "store_id")
    private String storeId;

    @Column(name = "nome")
    private String name;

    @Column(name = "data_criacao")
    private String dateCreated;

    @Column(name = "id_externo")
    private String externalId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

}
