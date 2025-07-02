package br.com.fiap.fastfood.payment.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "endereco_completo")
    private String addressLine;

    private double latitude;

    private double longitude;

    @Column(name = "referencia")
    private String reference;

}

