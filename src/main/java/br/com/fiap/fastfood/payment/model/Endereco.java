package br.com.fiap.fastfood.payment.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
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

