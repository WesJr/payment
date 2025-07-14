package br.com.fiap.fastfood.payment.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@Entity
@Table(name = "endereco")
@ToString
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero")
    private String streetNumber;

    @Column(name = "logradouro")
    private String streetName;

    @Column(name = "cidade")
    private String cityName;

    @Column(name = "estado")
    private String stateName;

    @Column(name = "referencia")
    private String reference;

}

